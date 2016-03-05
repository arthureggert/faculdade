package br.com.ahe.sd.trabalho.corba.impl;

import java.util.Objects;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import br.com.ahe.sd.trabalho.corba.AcaoDAO;
import br.com.ahe.sd.trabalho.corba.AcaoDAOHelper;
import br.com.ahe.sd.trabalho.corba.CarteiraDAO;
import br.com.ahe.sd.trabalho.corba.CarteiraDAOHelper;
import br.com.ahe.sd.trabalho.corba.EmpresaDAO;
import br.com.ahe.sd.trabalho.corba.EmpresaDAOHelper;
import br.com.ahe.sd.trabalho.corba.IFuncoesCorba;
import br.com.ahe.sd.trabalho.corba.IFuncoesCorbaHelper;
import br.com.ahe.sd.trabalho.corba.UsuarioDAO;
import br.com.ahe.sd.trabalho.corba.UsuarioDAOHelper;

/**
 * Created by aheggert on 23/06/14.
 */
public class CorbaUtils {
    private static CorbaUtils ourInstance = new CorbaUtils();

    private IFuncoesCorba funcoesCorba;

    private UsuarioDAO usuarioDAO;

    private EmpresaDAO empresaDAO;

    private AcaoDAO acaoDAO;

    private CarteiraDAO carteiraDAO;

    private boolean serverRunning;

    public static CorbaUtils get() {
        return ourInstance;
    }


    private CorbaUtils() {
        this.funcoesCorba = null;
        this.serverRunning = false;
    }

    public void runClient(String[] args) {
        if(Objects.isNull(this.funcoesCorba)) {
            try {
                // Cria e inicializa o ORB
                ORB orb = ORB.init(args, null);

                // Obtem referencia para o servico de nomes
                org.omg.CORBA.Object objRef = null;
                objRef = orb.resolve_initial_references("NameService");

                NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

                // Obtem referencia para o servidor
                for (String name : getNome()) {
                    if(name.contains("Corba")){
                        this.funcoesCorba = IFuncoesCorbaHelper.narrow(ncRef.resolve_str(name));
                    } else if (name.contains("Usuario")){
                        this.usuarioDAO = UsuarioDAOHelper.narrow(ncRef.resolve_str(name));
                    } else if (name.contains("Empresa")){
                        this.empresaDAO = EmpresaDAOHelper.narrow(ncRef.resolve_str(name));
                    } else if (name.contains("Acao")){
                        this.acaoDAO = AcaoDAOHelper.narrow(ncRef.resolve_str(name));
                    } else if (name.contains("Carteira")) {
                        this.carteiraDAO = CarteiraDAOHelper.narrow(ncRef.resolve_str(name));
                    }
                }
            } catch (InvalidName invalidName) {
                invalidName.printStackTrace();
            } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
                invalidName.printStackTrace();
            } catch (CannotProceed cannotProceed) {
                cannotProceed.printStackTrace();
            } catch (NotFound notFound) {
                notFound.printStackTrace();
            }
        }
    }


    public void runServer(String[] args){
        if(!this.serverRunning) {
            try {
                // Cria e inicializa o ORB
                ORB orb = ORB.init(args, null);
                // Cria a implementa��o e registra no ORB
                IFuncoesCorbaImpl impl = new IFuncoesCorbaImpl();
                UsuarioDAOImpl usuarioDAOimpl = new UsuarioDAOImpl();
                EmpresaDAOImpl empresaDAOimpl = new EmpresaDAOImpl();
                AcaoDAOImpl acaoDAOimpl = new AcaoDAOImpl();
                CarteiraDAOImpl carteiraDAOImpl = new CarteiraDAOImpl();
                // Ativa o POA
                POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
                rootpoa.the_POAManager().activate();
                // Pega a refer�ncia do servidor
                org.omg.CORBA.Object ref = rootpoa.servant_to_reference(impl);
                IFuncoesCorba href = IFuncoesCorbaHelper.narrow(ref);
                org.omg.CORBA.Object ref1 = rootpoa.servant_to_reference(usuarioDAOimpl);
                UsuarioDAO href1 = UsuarioDAOHelper.narrow(ref1);
                org.omg.CORBA.Object ref2 = rootpoa.servant_to_reference(empresaDAOimpl);
                EmpresaDAO href2 = EmpresaDAOHelper.narrow(ref2);
                org.omg.CORBA.Object ref3 = rootpoa.servant_to_reference(acaoDAOimpl);
                AcaoDAO href3 = AcaoDAOHelper.narrow(ref3);
                org.omg.CORBA.Object ref4 = rootpoa.servant_to_reference(carteiraDAOImpl);
                CarteiraDAO href4 = CarteiraDAOHelper.narrow(ref4);
                // Obt�m uma refer�ncia para o servidor de nomes
                org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
                NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
                // Registra o servidor no servico de nomes
                for (String name : getNome()) {
                    if(name.contains("Corba")){
                        NameComponent path[] = ncRef.to_name(name);
                        ncRef.rebind(path, href);
                    } else if (name.contains("Usuario")){
                        NameComponent path[] = ncRef.to_name(name);
                        ncRef.rebind(path, href1);
                    } else if (name.contains("Empresa")){
                        NameComponent path[] = ncRef.to_name(name);
                        ncRef.rebind(path, href2);
                    } else if (name.contains("Acao")){
                        NameComponent path[] = ncRef.to_name(name);
                        ncRef.rebind(path, href3);
                    } else if(name.contains("Carteira")) {
                        NameComponent path[] = ncRef.to_name(name);
                        ncRef.rebind(path, href4);
                    }
                }
                System.out.println("Servidor aguardando requisicoes ....");
                // Aguarda chamadas dos clientes
                orb.run();
            } catch (ServantNotActive servantNotActive) {
                servantNotActive.printStackTrace();
            } catch (CannotProceed cannotProceed) {
                cannotProceed.printStackTrace();
            } catch (WrongPolicy wrongPolicy) {
                wrongPolicy.printStackTrace();
            } catch (InvalidName invalidName) {
                invalidName.printStackTrace();
            } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
                invalidName.printStackTrace();
            } catch (AdapterInactive adapterInactive) {
                adapterInactive.printStackTrace();
            } catch (NotFound notFound) {
                notFound.printStackTrace();
            }
        }
    }

    private static String[] getNome() {
        return new String[]{"IFuncoesCorba", "UsuarioDAO","EmpresaDAO","AcaoDAO","CarteiraDAO"};
    }

    public IFuncoesCorba getFuncoesCORBA() {
        return this.funcoesCorba;
    }

    public UsuarioDAO getUsuarioDAO() {
        return this.usuarioDAO;
    }

    public EmpresaDAO getEmpresaDAO() {
        return this.empresaDAO;
    }

    public AcaoDAO getAcaoDAO() {
        return this.acaoDAO;
    }

    public CarteiraDAO getCarteiraDAO() {
        return this.carteiraDAO;
    }
}
