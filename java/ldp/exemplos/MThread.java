package br.com.ahe.ldp.exemplos;

public class MThread extends Thread {  
	Valor vl;    

	MThread(Valor v) {   
		this.vl = v;  
	}

	public void run() {   
		this.vl.add(100);  
	} 
}   
