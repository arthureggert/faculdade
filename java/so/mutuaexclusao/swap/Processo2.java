package br.com.ahe.so.mutuaexclusao.swap;

public class Processo2 extends Thread {
	private RegiaoCritica RC;
	public boolean ativoLocal = false;
	   
	public boolean isAtivoLocal() {
		return this.ativoLocal;
	}

	public void setAtivoLocal(boolean ativoLocal) {
		this.ativoLocal = ativoLocal;
	}
	
	public void swap(){
		this.RC.setAtivoGlobal(true);
		setAtivoLocal(false);
	}

	public Processo2(RegiaoCritica regiaoCritica){
		super("Processo2");
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
		setAtivoLocal(true);
			while (isAtivoLocal() == true) {
				swap();
				this.RC.lerBuffer();
				threadSleep();
			}
				this.RC.setAtivoGlobal(false);
	}
}


