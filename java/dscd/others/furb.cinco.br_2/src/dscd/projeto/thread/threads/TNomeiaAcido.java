package dscd.projeto.thread.threads;

import dscd.projeto.thread.quimica.molecula.GeraNomeMolecula;

public class TNomeiaAcido extends Thread {

	private GeraNomeMolecula geraNome;

	public TNomeiaAcido(GeraNomeMolecula nomes) {
		this.geraNome = nomes;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			geraNome.nomeiaAcidos();
		}
	}	
}
