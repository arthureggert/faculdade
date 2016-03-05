package br.com.ahe.dscd.projeto.omp.omps;

import jomp.runtime.OMP;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.thread.utils.AQuimicaUtils;

public class ClassificaReacaoQuimicaOMP {

	public void classificaReacaoQuimica(ReacaoQuimica2[] reacoes, CriaReacoesOMP_jomp omp ){
		OMP.setNumThreads(omp.getQtdReacoes());
		int i = 0;
		//omp parallel private(i)
		{
			for ( ; i < omp.getQtdReacoes() ; i++) {
				ReacaoQuimica2 reacao = reacoes[i];
				//omp sections
				{
					//omp section
					{
						//omp critical
						{
							reacao = AQuimicaUtils.classificaAcidoPorGrauDissociacaoIonica(reacao);							
						}
					}
					//omp section
					{
						//omp critical
						{
							reacao = AQuimicaUtils.classificaBasePorGrauDissociacaoIonica(reacao);
						}
					}
					
					//omp section
					{
						//omp critical
						{
							reacao = AQuimicaUtils.classificaBasePorOH(reacao);
						}
					}
				}
				reacoes[i] = reacao;
			}
			
		}
	}
}
