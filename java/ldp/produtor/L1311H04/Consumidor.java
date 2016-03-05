package br.com.ahe.ldp.produtor.L1311H04;


public class Consumidor extends Processo {

	public Consumidor(int id, Armazem a) throws InterruptedException {
		super(++id, a, null);
		setStatus(EStatusProcesso.PARADO);
	}

	public void run() {
		while (!this.termina) {
			try {
				setStatus(EStatusProcesso.PARADO);
				atualizarPanel();
				int prod = this.armazemRetirar.retira();
				if (prod != -1) {
					setStatus(EStatusProcesso.CONSUMINDO);
					setProduto(prod);
					atualizarPanel();
					for (int i = 0; i < prod; i++) {
						setTempo(i + 1);
						atualizarTempo();
						Thread.sleep(150);
					}

					setTempo(0);
					setProduto(0);
					setTotal(getTotal() + 1);
					atualizarTempo();
					atualizarPanel();
				} else {
					terminar();
				}
			} catch (InterruptedException e) {
				
			}
		}
		setTempo(0);
		setProduto(0);
		setStatus(EStatusProcesso.FINALIZADO);
		atualizarPanel();
	}
}