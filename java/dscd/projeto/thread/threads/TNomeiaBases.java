package br.com.ahe.dscd.projeto.thread.threads;

import br.com.ahe.dscd.projeto.thread.quimica.molecula.GeraNomeMolecula;

public class TNomeiaBases extends Thread {

	private GeraNomeMolecula geraNome;

	public TNomeiaBases(GeraNomeMolecula nomes) {
		this.geraNome = nomes;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			this.geraNome.nomeiaBases();
		}
	}	
}