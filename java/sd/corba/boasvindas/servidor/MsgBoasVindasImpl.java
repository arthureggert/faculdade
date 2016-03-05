package br.com.ahe.sd.corba.boasvindas.servidor;

import br.com.ahe.sd.corba.boasvindas.stub.MsgBoasVindasPOA;


public class MsgBoasVindasImpl extends MsgBoasVindasPOA {

	@Override
	public String boasVindas() {
		return "Bem-vindo ao CORBA"; 
	}


}