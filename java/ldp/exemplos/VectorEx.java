package br.com.ahe.ldp.exemplos;

import java.util.Vector;

public class VectorEx extends Thread {
	
	private Vector<String> xpto = new Vector<String>();

	public Vector<String> getXpto() {
		return this.xpto;
	}

	public void setXpto(Vector<String> xpto) {
		this.xpto = xpto;
	}
	
	public static void main(String[] args) {
		VectorEx vex = new VectorEx();
		vex.start();
		vex.run();
	}
}
