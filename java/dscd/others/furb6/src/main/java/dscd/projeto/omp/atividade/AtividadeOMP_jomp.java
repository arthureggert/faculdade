package dscd.projeto.omp.atividade;

import java.util.ArrayList;
import java.util.List;

import core.utils.AListUtils;
import core.utils.AStringUtils;
import dscd.projeto.thread.quimica.molecula.Molecula;

public class AtividadeOMP_jomp {


	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static void main(String[] args) {

		List moleculas = new ArrayList();
		Molecula molecula = AListUtils.getRandomElementFromList(moleculas);
		int b = 0;

		// OMP PARALLEL BLOCK BEGINS
		{
			__omp_Class0 __omp_Object0 = new __omp_Class0();
			// shared variables
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
			b  += __omp_Object0._rd_b;
			// shared variables
			moleculas = __omp_Object0.moleculas;
			args = __omp_Object0.args;
		}
		// OMP PARALLEL BLOCK ENDS


		System.out.println(String.format("Qtd de moleculas nomeadas \u00e9 de %d", b));

	}

	// OMP PARALLEL REGION INNER CLASS DEFINITION BEGINS
	private static class __omp_Class0 extends jomp.runtime.BusyTask {
		// shared variables
		@SuppressWarnings("rawtypes")
		List moleculas;
		String [ ] args;
		// firstprivate variables
		// variables to hold results of reduction
		int _rd_b;

		public void go(int __omp_me) throws Throwable {
			// firstprivate variables + init
			// private variables
			Molecula molecula = new Molecula();
			// reduction variables, init to default
			int b = 0;
			// OMP USER CODE BEGINS

			{
				String nomeAtomo = AListUtils.getLastObjectFromList(molecula.getAtomos()).getNome();
				while(AStringUtils.isTerminaEmVogal(nomeAtomo)){
					nomeAtomo = AStringUtils.removeLastCharFomString(nomeAtomo);
				}
				molecula.setNome(String.format("Acido %sico", nomeAtomo));
			}
			// OMP USER CODE ENDS
			// call reducer
			b = (int) jomp.runtime.OMP.doPlusReduce(__omp_me, b);
			// output to _rd_ copy
			if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
				_rd_b = b;
			}
		}
	}
	// OMP PARALLEL REGION INNER CLASS DEFINITION ENDS

}

