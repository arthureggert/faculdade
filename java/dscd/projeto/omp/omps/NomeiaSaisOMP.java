package br.com.ahe.dscd.projeto.omp.omps;

import jomp.runtime.OMP;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;

public class NomeiaSaisOMP {

	public void nomearSal(ReacaoQuimica2[] reacoes, CriaReacoesOMP_jomp omp ) {
		OMP.setNumThreads(omp.getQtdReacoes());
		int i = 0;
		//omp parallel private(i)
		{
			for ( ; i < omp.getQtdReacoes() ; i++) {
				ReacaoQuimica2 reacao = reacoes[i];
				Molecula sal = reacao.getSal();
				sal = nomearSal(sal);
				reacao.setSal(sal);
				reacoes[i] = reacao;
			}
		}
	}

	private Molecula nomearSal(Molecula sal) {
		if(sal.getClassificacao().equals("Oxissais")){
			sal.setNome("Hipoclorito de " + sal.getLastElementFromAtomos().getNome());
		} else {
			sal.setNome(sal.getFisrtElementFromAtomos().getNome()+"eto de "+sal.getLastElementFromAtomos().getNome());
		}
		return sal;
	}
}
