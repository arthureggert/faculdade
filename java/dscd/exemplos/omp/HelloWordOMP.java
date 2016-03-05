package br.com.ahe.dscd.exemplos.omp;

import jomp.runtime.OMP;


public class HelloWordOMP {

	public static void main(String[] args) {

		int myid;
		OMP.setNumThreads(15);

		//omp parallel private(myid)
		{
			myid = OMP.getThreadNum();
			System.out.println("Hello From " + myid);
		}
	}
}
