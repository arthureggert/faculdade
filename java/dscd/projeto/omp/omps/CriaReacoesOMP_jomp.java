package br.com.ahe.dscd.projeto.omp.omps;

import jomp.runtime.OMP;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.thread.quimica.reacao.ReacaoQuimica;
import br.com.ahe.dscd.projeto.thread.utils.AQuimicaUtils;

public class CriaReacoesOMP_jomp {


	private int qtdReacoes;

	public ReacaoQuimica2[] criaReacoes(ReacaoQuimica[] dados){
		ReacaoQuimica2[] reacoes = new ReacaoQuimica2[dados.length]; 

		int qtdReacoes = 0;

		OMP.setNumThreads(5);

		// OMP PARALLEL BLOCK BEGINS
		{
			__omp_Class0 __omp_Object0 = new __omp_Class0();
			// shared variables
			__omp_Object0.reacoes = reacoes;
			__omp_Object0.dados = dados;
			// firstprivate variables
			try {
				jomp.runtime.OMP.doParallel(__omp_Object0);
			} catch(Throwable __omp_exception) {
				System.err.println("OMP Warning: Illegal thread exception ignored!");
				System.err.println(__omp_exception);
			}
			// reduction variables
			qtdReacoes  += __omp_Object0._rd_qtdReacoes;
			reacoes = __omp_Object0.reacoes;
			dados = __omp_Object0.dados;
		}
		// OMP PARALLEL BLOCK ENDS

		this.qtdReacoes = qtdReacoes;
		return reacoes;
	}

	public int getQtdReacoes() {
		return this.qtdReacoes;
	}

	// OMP PARALLEL REGION INNER CLASS DEFINITION BEGINS
	private class __omp_Class0 extends jomp.runtime.BusyTask {
		ReacaoQuimica2 [ ] reacoes;
		ReacaoQuimica [ ] dados;
		// firstprivate variables
		// variables to hold results of reduction
		int _rd_qtdReacoes;

		public void go(int __omp_me) throws Throwable {
			// firstprivate variables + init
			// private variables
			// reduction variables, init to default
			int qtdReacoes = 0;
			// OMP USER CODE BEGINS

			{
				{ // OMP FOR BLOCK BEGINS
					// copy of firstprivate variables, initialized
					// copy of lastprivate variables
					// variables to hold result of reduction
					boolean amLast=false;
					{
						// firstprivate variables + init
						// [last]private variables
						// reduction variables + init to default
						// -------------------------------------
						jomp.runtime.LoopData __omp_WholeData2 = new jomp.runtime.LoopData();
						jomp.runtime.LoopData __omp_ChunkData1 = new jomp.runtime.LoopData();
						__omp_WholeData2.start = (long)( 0);
						__omp_WholeData2.stop = (long)( this.dados.length);
						__omp_WholeData2.step = (long)(1);
						jomp.runtime.OMP.setChunkStatic(__omp_WholeData2);
						while(!__omp_ChunkData1.isLast && jomp.runtime.OMP.getLoopStatic(__omp_me, __omp_WholeData2, __omp_ChunkData1)) {
							for(;;) {
								if(__omp_WholeData2.step > 0) {
									if(__omp_ChunkData1.stop > __omp_WholeData2.stop) __omp_ChunkData1.stop = __omp_WholeData2.stop;
									if(__omp_ChunkData1.start >= __omp_WholeData2.stop) break;
								} else {
									if(__omp_ChunkData1.stop < __omp_WholeData2.stop) __omp_ChunkData1.stop = __omp_WholeData2.stop;
									if(__omp_ChunkData1.start > __omp_WholeData2.stop) break;
								}
								for(int i = (int)__omp_ChunkData1.start; i < __omp_ChunkData1.stop; i += __omp_ChunkData1.step) {
									// OMP USER CODE BEGINS
									{
										ReacaoQuimica reacao = this.dados[i];
										ReacaoQuimica2 reacao2 = new ReacaoQuimica2();
										reacao2.setAcido(reacao.getAcido());
										reacao2.setBase(reacao.getBase());
										reacao2.setAgua(AQuimicaUtils.getMoleculaAgua(reacao.getMoleculasResultantes()));							
										reacao2.setSal(AQuimicaUtils.getMoleculaSal(reacao.getMoleculasResultantes()));
										this.reacoes[i] = reacao2;
										qtdReacoes++;
									}
									// OMP USER CODE ENDS
									if (i == (__omp_WholeData2.stop-1)) amLast = true;
								} // of for 
								if(__omp_ChunkData1.startStep == 0)
									break;
								__omp_ChunkData1.start += __omp_ChunkData1.startStep;
								__omp_ChunkData1.stop += __omp_ChunkData1.startStep;
							} // of for(;;)
						} // of while
						// call reducer
						jomp.runtime.OMP.doBarrier(__omp_me);
						// copy lastprivate variables out
						if (amLast) {
						}
					}
					// set global from lastprivate variables
					if (amLast) {
					}
					// set global from reduction variables
					if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
					}
				} // OMP FOR BLOCK ENDS

			}
			// OMP USER CODE ENDS
			// call reducer
			qtdReacoes = (int) jomp.runtime.OMP.doPlusReduce(__omp_me, qtdReacoes);
			// output to _rd_ copy
			if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
				this._rd_qtdReacoes = qtdReacoes;
			}
		}
	}
	// OMP PARALLEL REGION INNER CLASS DEFINITION ENDS

}

