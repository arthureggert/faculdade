package br.com.ahe.ldp.produtor.exem1;
public class ProdutorConsumidor extends Processo {

	private Armazem armazemProd;

	private Armazem armazemCons;

	private pnlProdCons panel;

	public ProdutorConsumidor(int id, Armazem aCons, Armazem aProd,
			pnlProdCons p) {
		super(id);

		this.setNome("Produtor/Consumidor " + id);
		this.armazemProd = aProd;
		this.armazemCons = aCons;
		this.panel = p;

		start();
	}

	public void run() {

		while (!this.flagTerminar) {

			try {
				this.setStatus("Parado");
				this.prod = this.armazemCons.retira(0);

				if (this.prod != -1) { // se produto != 0, n�o saiu por timeout

					if (this.prod > 0) {
						this.setStatus("Consumindo");
						System.out.println("Sou o prodcons "
								+ getIdentificador() + " consumindo produto "
								+ this.prod);

						for (int i = 0; i < this.prod; i++) {
							this.panel.lbTmpProd.setText(" Tempo Prod: " + i);
							Thread.sleep(250);
						}

						try {

							System.out.println("Sou o prodcons "
									+ getIdentificador()
									+ " produzindo produto " + this.prod);
							this.setStatus("Parado");
							
							this.armazemProd.coloca(this.prod);
							this.contador++;
							this.setStatus("Produzindo");
							for (int i = 0; i < this.prod; i++) {
								this.panel.lbTmpProd.setText(" Tempo Prod: "
										+ (i + 1));
								Thread.sleep(250);
							}

						} catch (InterruptedException e) {
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
