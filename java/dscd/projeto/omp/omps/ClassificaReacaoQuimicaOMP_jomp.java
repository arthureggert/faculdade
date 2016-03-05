package br.com.ahe.dscd.projeto.omp.omps;

import jomp.runtime.OMP;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.thread.utils.AQuimicaUtils;

public class ClassificaReacaoQuimicaOMP_jomp {


	@SuppressWarnings( "synthetic-access" )
	public void classificaReacaoQuimica(ReacaoQuimica2[] reacoes, CriaReacoesOMP_jomp omp ){
		OMP.setNumThreads(omp.getQtdReacoes());
		
		// OMP PARALLEL BLOCK BEGINS
		{
			System.out.println(OMP.getThreadNum());
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

	// OMP PARALLEL REGION INNER CLASS DEFINITION BEGINS
	private class __omp_Class0 extends jomp.runtime.BusyTask {
		// shared variables
		CriaReacoesOMP_jomp omp;
		ReacaoQuimica2 [ ] reacoes;
		// firstprivate variables
		// variables to hold results of reduction

		@Override
        public void go(int __omp_me) throws Throwable {
			// firstprivate variables + init
			// private variables
			int i = 0;
			// reduction variables, init to default
			// OMP USER CODE BEGINS

			{
				for ( ; i < this.omp.getQtdReacoes() ; i++) {
					ReacaoQuimica2 reacao = this.reacoes[i];
					{ // OMP SECTIONS BLOCK BEGINS
						// copy of firstprivate variables, initialized
						// copy of lastprivate variables
						// variables to hold result of reduction
						boolean amLast = false;
						{
							// firstprivate variables + init
							// [last]private variables
							// reduction variables + init to default
							// -------------------------------------
							System.out.println(amLast);
							__ompName_1: while(true) {
								switch((int)jomp.runtime.OMP.getTicket(__omp_me)) {
								// OMP SECTION BLOCK 0 BEGINS
								case 0: {
									// OMP USER CODE BEGINS

									{
										// OMP CRITICAL BLOCK BEGINS
										synchronized (jomp.runtime.OMP.getLockByName("")) {
											// OMP USER CODE BEGINS

											{
												reacao = AQuimicaUtils.classificaAcidoPorGrauDissociacaoIonica(reacao);							
											}
											// OMP USER CODE ENDS
										}
										// OMP CRITICAL BLOCK ENDS

									}
									// OMP USER CODE ENDS
								}  break;
								// OMP SECTION BLOCK 0 ENDS
								// OMP SECTION BLOCK 1 BEGINS
								case 1: {
									// OMP USER CODE BEGINS

									{
										// OMP CRITICAL BLOCK BEGINS
										synchronized (jomp.runtime.OMP.getLockByName("")) {
											// OMP USER CODE BEGINS

											{
												reacao = AQuimicaUtils.classificaBasePorGrauDissociacaoIonica(reacao);
											}
											// OMP USER CODE ENDS
										}
										// OMP CRITICAL BLOCK ENDS

									}
									// OMP USER CODE ENDS
								}  break;
								// OMP SECTION BLOCK 1 ENDS
								// OMP SECTION BLOCK 2 BEGINS
								case 2: {
									// OMP USER CODE BEGINS

									{
										// OMP CRITICAL BLOCK BEGINS
										synchronized (jomp.runtime.OMP.getLockByName("")) {
											// OMP USER CODE BEGINS

											{
												reacao = AQuimicaUtils.classificaBasePorOH(reacao);
											}
											// OMP USER CODE ENDS
										}
										// OMP CRITICAL BLOCK ENDS

									}
									// OMP USER CODE ENDS
									amLast = true;
								}  break;
								// OMP SECTION BLOCK 2 ENDS

								default: break __ompName_1;
								} // of switch
							} // of while
						// call reducer
						jomp.runtime.OMP.resetTicket(__omp_me);
						jomp.runtime.OMP.doBarrier(__omp_me);
						// copy lastprivate variables out
//						if (amLast) {
//						}
						}
						// update lastprivate variables
//						if (amLast) {
//						}
						// update reduction variables
//						if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
//						}
					} // OMP SECTIONS BLOCK ENDS

					this.reacoes[i] = reacao;
				}

			}
			// OMP USER CODE ENDS
			// call reducer
			// output to _rd_ copy
//			if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
//			}
		}
	}
	// OMP PARALLEL REGION INNER CLASS DEFINITION ENDS

}

