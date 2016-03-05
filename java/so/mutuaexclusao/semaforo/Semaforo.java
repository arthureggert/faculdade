package br.com.ahe.so.mutuaexclusao.semaforo;

import java.util.concurrent.Semaphore;

public class Semaforo extends Semaphore{

	private static final long serialVersionUID = 1L;
	private int valor;
	private int processosBloqueados = 0;	

	public Semaforo (int i) {
		super(i);
		this.valor = i ;
	} 

	public synchronized void P() {
		if ( this.valor > 0 ) 
			this.valor = this.valor - 1; 
		else {
			this.processosBloqueados = this.processosBloqueados + 1;
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			this.processosBloqueados = this.processosBloqueados - 1;
		}

	}  

	public synchronized void V() {
		if (this.processosBloqueados > 0){
			notify();  
		}	else {
			this.valor++;  
		}
	} 
} 

