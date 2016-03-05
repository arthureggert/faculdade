package br.com.ahe.dscd.projeto.omp.omps;

import jomp.runtime.OMP;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;

public class NomeiaSaisOMP_jomp {


	public void nomearSal(ReacaoQuimica2[] reacoes, CriaReacoesOMP_jomp omp ) {
		OMP.setNumThreads(omp.getQtdReacoes());
		//int i = 0;

		// OMP PARALLEL BLOCK BEGINS
		{
			__omp_Class0 __omp_Object0 = new __omp_Class0();
			// shared variables
			__omp_Object0.omp = omp;
			__omp_Object0.reacoes = reacoes;
			// firstprivate variables
			try {
				jomp.runtime.OMP.doParallel(__omp_Object0);
			} catch(Throwable __omp_exception) {
				System.err.println("OMP Warning: Illegal thread exception ignored!");
				System.err.println(__omp_exception);
			}
			// reduction variables
			// shared variables
			omp = __omp_Object0.omp;
			reacoes = __omp_Object0.reacoes;
		}
		// OMP PARALLEL BLOCK ENDS

	}

	private Molecula nomearSal(Molecula sal) {
		if(sal.getClassificacao().equals("Oxissais")){
			sal.setNome("Hipoclorito de " + sal.getLastElementFromAtomos().getNome());
		} else {
			sal.setNome(sal.getFisrtElementFromAtomos().getNome()+"eto de "+sal.getLastElementFromAtomos().getNome());
		}
		return sal;
	}

	// OMP PARALLEL REGION INNER CLASS DEFINITION BEGINS
	private class __omp_Class0 extends jomp.runtime.BusyTask {
		// shared variables
		CriaReacoesOMP_jomp omp;
		ReacaoQuimica2 [ ] reacoes;
		// firstprivate variables
		// variables to hold results of reduction

		public void go(int __omp_me) throws Throwable {
			// firstprivate variables + init
			// private variables
			int i = 0;
			// reduction variables, init to default
			// OMP USER CODE BEGINS

			{
				for ( ; i < this.omp.getQtdReacoes() ; i++) {
					ReacaoQuimica2 reacao = this.reacoes[i];
					Molecula sal = reacao.getSal();
					sal = nomearSal(sal);
					reacao.setSal(sal);
					this.reacoes[i] = reacao;
				}
			}
			// OMP USER CODE ENDS
			// call reducer
			// output to _rd_ copy
			if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
			}
		}
	}
	// OMP PARALLEL REGION INNER CLASS DEFINITION ENDS

}

