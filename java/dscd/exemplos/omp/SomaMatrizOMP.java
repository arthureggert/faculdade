package br.com.ahe.dscd.exemplos.omp;

import jomp.runtime.OMP;
import utils.ANumberUtils;

public class SomaMatrizOMP {

	
	public static void main(String[] args) {
		
		int[][] matriz = new int[5][4];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = ANumberUtils.getRandomNumberWithMaxNumber(100);
				System.out.println(String.format("Matriz[%d][%d] = %d", i,j,matriz[i][j]));
			}
		}
		
		int i;
		int myid;
		int b = 0;
		OMP.setNumThreads(5);
		//omp parallel private(myid,i) reduction(+:b)
		{
			myid = OMP.getThreadNum();
			for (i = 0; i < 4; i++) {
				b += matriz[myid][i];
				System.out.println(String.format("Thread %d - Total %d", myid, b));
			}
		}
		
		System.out.println(String.format("Valor Final de B %d", b));
		
		
	}
}
