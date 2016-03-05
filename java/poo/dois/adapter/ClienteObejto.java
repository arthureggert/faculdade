package br.com.ahe.poo.dois.adapter;

public class ClienteObejto {
	
	Alvo alvos;
	
	public void inicializaAlvos() {
		this.alvos = new AdaptadorObjeto();
	}

	public void executaAlvos() {
		for (int i = 0; i < 10; i++) {
			this.alvos.operacao();
		}
	}
}