package dscd.atividade2.um;

public class Consumidor extends Thread {

	private Fila armazem;
	
	public Consumidor(Fila armazem) {
		this.armazem = armazem;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0 ; i <= 1000 ; i++){
				armazem.get();
				sleep(1900);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
