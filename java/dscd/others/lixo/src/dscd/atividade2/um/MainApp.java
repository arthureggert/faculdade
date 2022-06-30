package dscd.atividade2.um;

public class MainApp {

	public static void main(String[] args) {
		Fila l = new Fila();
		Consumidor c = new Consumidor(l);
		Produtor p = new Produtor(l);
		
		p.start();
		c.start();
	}
}
