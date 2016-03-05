package br.com.ahe.so.mutuaexclusao.monitores;

public class Processo1 extends Thread {

	private RegiaoCritica RC;
	
	public Processo1(RegiaoCritica regiaoCritica){
		super("Processo1");
		this.RC = regiaoCritica; 
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
			this.RC.escreveBuffer(i);
		}	
	}
} 