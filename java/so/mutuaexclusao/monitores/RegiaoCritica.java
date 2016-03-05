package br.com.ahe.so.mutuaexclusao.monitores;

public class RegiaoCritica {
	private int memoria = -1;
	private boolean acessivel = true; 
	
	private void threadSleep() {
		try {
	            wait( ); 
	       }
	       catch ( InterruptedException e) {
	            e.printStackTrace( ); 
	       }
	}

	public synchronized void escreveBuffer( int valor ){
		while(!this.acessivel) {
			threadSleep();
		}
		
		System.out.println( Thread.currentThread().getName() + " fez " + valor );
		this.memoria = valor;
		this.acessivel = false;  
		notify( ); 
	}

	public synchronized int lerBuffer(){
		while(this.acessivel) { // nao eh a vez de ler
			threadSleep();
		}
		
		System.out.println( Thread.currentThread().getName() + " usou " + this.memoria );
		this.acessivel = true;  
		notify( );    
		return this.memoria;
	}
} 