package br.com.ahe.so.mutuaexclusao.semaforo;

public class RegiaoCritica {
	private int memoria;
	   
	public void escreveBuffer(int valor){
		System.out.println( Thread.currentThread().getName() +" fez " + valor );
	    this.memoria = valor;
	}
	public int lerBuffer(){
	    System.out.println( Thread.currentThread().getName() +" usou " + this.memoria );
	    return this.memoria;
	}
} 

