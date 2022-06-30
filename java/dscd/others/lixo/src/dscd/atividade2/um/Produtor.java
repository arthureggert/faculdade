package dscd.atividade2.um;

import java.util.Date;


public class Produtor extends Thread {

	private Fila armazem;
	
	public Produtor(Fila armazem) {
		this.armazem = armazem;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0 ; i <= 1000 ; i++){
				String dado = new Date().toString();
				armazem.put(dado);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
