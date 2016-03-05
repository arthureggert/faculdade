package br.com.ahe.so.mutuaexclusao.semaforo;

public class Processo2 extends Thread {
	private RegiaoCritica RC;
	private Semaforo semaforo1;
	private Semaforo semaforo2;

	public Processo2(RegiaoCritica regiaoCritica, Semaforo semaforoUm, Semaforo semaforoDois){
		super("Processo2");
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
			this.semaforo2.P();  
			this.RC.lerBuffer();
			this.semaforo1.V();  
		}
	}

}
