package br.com.ahe.dscd.projeto.omp.atividade;

import java.util.ArrayList;
import java.util.List;

import jomp.runtime.OMP;
import utils.AListUtils;
import utils.AStringUtils;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;

public class Atividade2OMP_jomp {


	public static void main(String[] args) {

		List<?> moleculas = new ArrayList<Object>();
		int b = 0;
		OMP.setNumThreads(moleculas.size());

		// OMP PARALLEL BLOCK BEGINS
		{
			__omp_Class0 __omp_Object0 = new __omp_Class0();
			// shared variables
			__omp_Object0.b = b;
			__omp_Object0.moleculas = moleculas;
			__omp_Object0.args = args;
			// firstprivate variables
			try {
				jomp.runtime.OMP.doParallel(__omp_Object0);
			} catch(Throwable __omp_exception) {
				System.err.println("OMP Warning: Illegal thread exception ignored!");
				System.err.println(__omp_exception);
			}
			// reduction variables
			// shared variables
			b = __omp_Object0.b;
			moleculas = __omp_Object0.moleculas;
			args = __omp_Object0.args;
		}
		// OMP PARALLEL BLOCK ENDS



	}

	// OMP PARALLEL REGION INNER CLASS DEFINITION BEGINS
	private static class __omp_Class0 extends jomp.runtime.BusyTask {
		// shared variables
		int b;
		List<?> moleculas;
		String [ ] args;
		// firstprivate variables
		// variables to hold results of reduction

		public void go(int __omp_me) throws Throwable {
			// firstprivate variables + init
			// private variables
			// reduction variables, init to default
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
						__omp_WholeData2.stop = (long)( this.moleculas.size())+1;
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
								for(int b = (int)__omp_ChunkData1.start; b < __omp_ChunkData1.stop; b += __omp_ChunkData1.step) {
									// OMP USER CODE BEGINS
									{
										Molecula molecula = (Molecula) this.moleculas.get(b);
										String nomeAtomo = AListUtils.getLastObjectFromList(molecula.getAtomos()).getNome();
										while(AStringUtils.isTerminaEmVogal(nomeAtomo)){
											nomeAtomo = AStringUtils.removeLastCharFomString(nomeAtomo);
										}
										molecula.setNome(String.format("Acido %sidrico", nomeAtomo));
									}
									// OMP USER CODE ENDS
									if (b == (__omp_WholeData2.stop-1)) amLast = true;
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
			// output to _rd_ copy
			if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
			}
		}
	}
	// OMP PARALLEL REGION INNER CLASS DEFINITION ENDS

}

