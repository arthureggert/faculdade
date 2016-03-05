package br.com.ahe.dscd.projeto.omp.omps;

import jomp.runtime.OMP;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.thread.quimica.reacao.ReacaoQuimica;
import br.com.ahe.dscd.projeto.thread.utils.AQuimicaUtils;

public class CriaReacoesOMP {
	
	private int qtdReacoes;

	public ReacaoQuimica2[] criaReacoes(ReacaoQuimica[] dados){
		ReacaoQuimica2[] reacoes = new ReacaoQuimica2[dados.length]; 

		int i;
		int qtdReacoes = 0;

		OMP.setNumThreads(5);
		
		//omp parallel reduction(+:qtdReacoes)
		{
			//omp for
			for (i = 0 ; i < dados.length; i++) {
				ReacaoQuimica reacao = dados[i];
				ReacaoQuimica2 reacao2 = new ReacaoQuimica2();
				reacao2.setAcido(reacao.getAcido());
				reacao2.setBase(reacao.getBase());
				reacao2.setAgua(AQuimicaUtils.getMoleculaAgua(reacao.getMoleculasResultantes()));							
				reacao2.setSal(AQuimicaUtils.getMoleculaSal(reacao.getMoleculasResultantes()));
				reacoes[i] = reacao2;
				qtdReacoes++;
			}
		}
		this.qtdReacoes = qtdReacoes;
		return reacoes;
	}
	
	public int getQtdReacoes() {
		return this.qtdReacoes;
	}
}
