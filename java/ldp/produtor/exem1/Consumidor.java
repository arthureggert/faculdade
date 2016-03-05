package br.com.ahe.ldp.produtor.exem1;
class Consumidor extends Processo {

	private Armazem armazem;

	private pnlConsumidor panel;

	public Consumidor(int id, Armazem a, pnlConsumidor p) {
		super(id);
		this.setNome("Consumidor "+id);
		this.armazem = a;

		this.panel = p;

		start();

	}

	public void run() {

		while (!this.flagTerminar) {

			try {
				this.setStatus("Parado");
				this.prod = this.armazem.retira(1);
				
				
				if (this.prod != -1) { // se produto != -1, n�o saiu por timeout

					if (this.prod > 0) {

						System.out.println("Sou o consumidor "
								+ getIdentificador() + " consumindo produto "
								+ this.prod);

						this.setStatus("Consumindo");
						this.contador++;
						//panel.lbProd.setText(" Produto: " + prod);
						for (int i = 0; i < this.prod; i++) {
							this.panel.lbTmpProd.setText(" Tempo Prod: " + (i+1));
							Thread.sleep(250);
						}
					}

				} else {

					terminar();

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
