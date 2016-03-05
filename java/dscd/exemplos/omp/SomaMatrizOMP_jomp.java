package br.com.ahe.dscd.exemplos.omp;

import jomp.runtime.OMP;
import utils.ANumberUtils;

public class SomaMatrizOMP_jomp {



	public static void main(String[] args) {

		int[][] matriz = new int[5][4];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = ANumberUtils.getRandomNumberWithMaxNumber(100);
				System.out.println(String.format("Matriz[%d][%d] = %d", i,j,matriz[i][j]));
			}
		}

		int b = 0;
		OMP.setNumThreads(5);

		// OMP PARALLEL BLOCK BEGINS
		{
			__omp_Class0 __omp_Object0 = new __omp_Class0();
			// shared variables
			__omp_Object0.matriz = matriz;
			__omp_Object0.args = args;
			// firstprivate variables
			try {
				jomp.runtime.OMP.doParallel(__omp_Object0);
			} catch(Throwable __omp_exception) {
				System.err.println("OMP Warning: Illegal thread exception ignored!");
				System.err.println(__omp_exception);
			}
			// reduction variables
			b  += __omp_Object0._rd_b;
			// shared variables
			matriz = __omp_Object0.matriz;
			args = __omp_Object0.args;
		}
		// OMP PARALLEL BLOCK ENDS


		System.out.println(String.format("Valor Final de B %d", b));


	}

	// OMP PARALLEL REGION INNER CLASS DEFINITION BEGINS
	private static class __omp_Class0 extends jomp.runtime.BusyTask {
		// shared variables
		int [ ] [ ] matriz;
		String [ ] args;
		// firstprivate variables
		// variables to hold results of reduction
		int _rd_b;

		public void go(int __omp_me) throws Throwable {
			// firstprivate variables + init
			// private variables
			int myid;
			int i;
			// reduction variables, init to default
			int b = 0;
			// OMP USER CODE BEGINS

			{
				myid = OMP.getThreadNum();
				for (i = 0; i < 4; i++) {
					b += this.matriz[myid][i];
					System.out.println(String.format("Thread %d - Total %d", myid, b));
				}
			}
			// OMP USER CODE ENDS
			// call reducer
			b = (int) jomp.runtime.OMP.doPlusReduce(__omp_me, b);
			// output to _rd_ copy
			if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
				this._rd_b = b;
			}
		}
	}
	// OMP PARALLEL REGION INNER CLASS DEFINITION ENDS

}

