package br.com.ahe.poo.dois.adapter;

public class ClienteClasse {

	InterfaceAlvo alvos;
	
	public void inicializaAlvos() {
		this.alvos = new AdaptadorClasse();
	}
	
	public void executaAlvos() {
		for (int i = 0; i < 10; i++) {
			this.alvos.operacao();
		}
	}
}
