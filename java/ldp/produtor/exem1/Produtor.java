package br.com.ahe.ldp.produtor.exem1;
import java.util.Random;

class Produtor extends Processo {

	private Armazem armazem;

	private pnlProdutor panel;

	private Random r = new Random();

	public Produtor(int id, Armazem a, pnlProdutor p) {
		super(id);
		this.setNome("Produtor "+id);
		this.armazem = a;
		this.panel = p;
		
		start();
	}

	private int produz() {
		return this.r.nextInt(100); // nmero randmico entre 0 e 99

	}

	public void run() {
		while (!this.isFlagTerminar()) {
			try {

				this.prod = produz();
				this.panel.refresh();
				System.out.println("Sou o produtor " + getIdentificador()
						+ " produzindo produto " + this.prod);
				this.setStatus("Parado");
				this.armazem.coloca(this.prod);

				this.contador++;
				this.setStatus("Produzindo");
				for(int i= 0; i < this.prod;i++){
					this.panel.lbTmpProd.setText(" Tempo Prod: "+(i+1));
					Thread.sleep(250);				
				}
				
							
				
			} catch (InterruptedException e) {
			}
		}
		this.setStatus("Finalizado");
	
	}

	
	public void setStatus(String status) {
		this.status = status;
		this.panel.refresh();
	}

}
