package br.com.ahe.sd.trabalho.rmi;

import java.rmi.RemoteException;

import br.com.ahe.sd.trabalho.corba.Acao;
import br.com.ahe.sd.trabalho.corba.Carteira;
import br.com.ahe.sd.trabalho.corba.Empresa;
import br.com.ahe.sd.trabalho.corba.impl.CorbaUtils;
import br.com.ahe.sd.trabalho.webservice.CompraXML;
import br.com.ahe.sd.trabalho.webservice.WebserviceUtils;

public class IFuncoesRMIImpl implements IFuncoesRMI {

    private String lastError = "";

    @Override
    public void comprarAcao(String codEmpresa, String usuario, double quantidade, double valor) throws RemoteException {
        try {
            Acao acao = null;
            Empresa empresa = WebserviceUtils.get().getEmpresaWS(codEmpresa);
            if (!CorbaUtils.get().getEmpresaDAO().isEmpresaCadastrada(empresa)) {
                CorbaUtils.get().getEmpresaDAO().cadastraEmpresa(empresa);
                acao = CorbaUtils.get().getAcaoDAO().criaAcao(empresa.sigla);
            } else {
                acao = CorbaUtils.get().getAcaoDAO().buscaAcap(codEmpresa);
            }
            CompraXML compra = WebserviceUtils.get().comprarAcao(codEmpresa, String.valueOf(valor), String.valueOf(quantidade));
            Carteira carteira = CorbaUtils.get().getCarteiraDAO().buscaCarteira(usuario);
            if(carteira.valorReal == 0d){
                carteira = CorbaUtils.get().getCarteiraDAO().criaCarteira(usuario);
            }
            if(carteira.valorReal < (quantidade * valor)) {
                throw new IllegalArgumentException("Valor da Carteira Insufucuente");
            }
            if (compra.getAprovada().equals("Sim")) {
                CorbaUtils.get().getAcaoDAO().criaMovimentacaoAcao(acao , "COMPRA");
                CorbaUtils.get().getCarteiraDAO().criaMovimentacaoCarteira(acao,carteira,valor,quantidade,"COMPRA");
            } else if (compra.getAprovada().equals("Pendente")){
                CorbaUtils.get().getAcaoDAO().criaMovimentacaoAcao(acao , "PENDENTE");
                CorbaUtils.get().getCarteiraDAO().criaMovimentacaoCarteira(acao,carteira,valor,quantidade,"PENDENTE");
            }else {
                throw new IllegalArgumentException(compra.getMensagem());
            }
        } catch (IllegalArgumentException iae) {
            this.lastError = iae.getMessage();
            throw new RemoteException();
        }
    }

    @Override
    public void venderAcao(String codEmpresa, String usuario, double quantidade, double valor) throws RemoteException {
        try {
            Acao acao = null;
            Empresa empresa = WebserviceUtils.get().getEmpresaWS(codEmpresa);
            if (!CorbaUtils.get().getEmpresaDAO().isEmpresaCadastrada(empresa)) {
                CorbaUtils.get().getEmpresaDAO().cadastraEmpresa(empresa);
                acao = CorbaUtils.get().getAcaoDAO().criaAcao(empresa.sigla);
            } else {
                acao = CorbaUtils.get().getAcaoDAO().buscaAcap(codEmpresa);
            }
            CompraXML venda = WebserviceUtils.get().comprarAcao(codEmpresa, String.valueOf(valor), String.valueOf(quantidade));
            Carteira carteira = CorbaUtils.get().getCarteiraDAO().buscaCarteira(usuario);

            if(!CorbaUtils.get().getCarteiraDAO().isAcaoComprada(acao , carteira , Double.valueOf(quantidade).intValue())) {
                throw new IllegalArgumentException("Qtd não sufuciente para venda");
            }
            if (venda.getAprovada().equals("Sim")) {
                CorbaUtils.get().getAcaoDAO().criaMovimentacaoAcao(acao , "VENDA");
                CorbaUtils.get().getCarteiraDAO().criaMovimentacaoCarteira(acao,carteira,valor,quantidade,"VENDA");
            } else if (venda.getAprovada().equals("Pendente")){
                CorbaUtils.get().getAcaoDAO().criaMovimentacaoAcao(acao , "PENDENTE");
                CorbaUtils.get().getCarteiraDAO().criaMovimentacaoCarteira(acao,carteira,valor,quantidade,"PENDENTE");
            }else {
                throw new IllegalArgumentException(venda.getMensagem());
            }
        } catch (IllegalArgumentException iae) {
            this.lastError = iae.getMessage();
            throw new RemoteException();
        }
    }

    public String getLastError() {
        System.out.println(this.lastError);
        return this.lastError;
    }
}
