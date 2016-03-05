package br.com.ahe.dscd.projeto.thread.threads;

import br.com.ahe.dscd.projeto.thread.quimica.reacao.GeraReacaoAcidoBase;

public class TExecutaReacao extends Thread {

	private GeraReacaoAcidoBase geracao;
	
	public TExecutaReacao(GeraReacaoAcidoBase reacao) {
		this.geracao = reacao;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			this.geracao.executaReacao();
		}
	}
}
