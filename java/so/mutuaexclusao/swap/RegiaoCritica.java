package br.com.ahe.so.mutuaexclusao.swap;

public class RegiaoCritica {
	private int memoria;
	public boolean ativoGlobal = false;

	public boolean isAtivoGlobal() {
		return this.ativoGlobal;
	}

	public void setAtivoGlobal(boolean ativoGlobal) {
		this.ativoGlobal = ativoGlobal;
	}
		
	public void escreveBuffer(int valor){
		System.out.println( Thread.currentThread().getName() +" fez " + valor);
	    this.memoria = valor;
	}
	public int lerBuffer(){
	    System.out.println( Thread.currentThread().getName() +" usou " + this.memoria );
	    return this.memoria;
	}


} 

