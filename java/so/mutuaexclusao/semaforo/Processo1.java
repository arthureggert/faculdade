package br.com.ahe.so.mutuaexclusao.semaforo;


public class Processo1 extends Thread {
	private RegiaoCritica RC;
	private Semaforo semaforo1;
	private Semaforo semaforo2;

	public Processo1(RegiaoCritica regiaoCritica, Semaforo semaforoUm, Semaforo semaforoDois){
		super("Processo1");
		this.RC = regiaoCritica;
		this.semaforo1 = semaforoUm; 
		this.semaforo2 = semaforoDois; 
	}
	
	private void threadSleep() {
		try {
			Thread.sleep(150);
		} catch( InterruptedException iException ) {
			iException.printStackTrace();
		}
	}
	
	public void run(){
		for ( int i = 1; i <= 10; i++ ) {
			threadSleep();
			this.semaforo1.P();         
			this.RC.escreveBuffer(i);
			this.semaforo2.V();
		}	
	}
} 