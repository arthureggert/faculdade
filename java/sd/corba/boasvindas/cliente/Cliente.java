package br.com.ahe.sd.corba.boasvindas.cliente;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import br.com.ahe.sd.corba.boasvindas.stub.MsgBoasVindas;
import br.com.ahe.sd.corba.boasvindas.stub.MsgBoasVindasHelper;


public class Cliente {

	public static void main(String args[]) {

		try {
			// Cria e inicializa o ORB
			ORB orb = ORB.init(args, null);

			// Obtem referencia para o servico de nomes
			Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// Obtem referencia para o servidor
			String name = "Msg_Boas_Vindas";
			MsgBoasVindas server = MsgBoasVindasHelper.narrow(ncRef.resolve_str(name));

			// Imprime mensagem de boas-vindas
			System.out.println(server.boasVindas());

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}
}

