package br.com.ahe.ldp.produtor.L1311H04;


public class Produtor extends Processo {

	public Produtor(int id, Armazem armazem) throws InterruptedException {
		super(++id, null, armazem);
		setStatus(EStatusProcesso.PRODUZINDO);
	}

	private int produz() {
		return 50 + (int) (150 * Math.random());
	}

	public void run() {
		while (!this.termina) {
			try {
				int prod = produz();
				setStatus(EStatusProcesso.PRODUZINDO);
				setProduto(prod);
				atualizarPanel();
				for (int i = 0; i < prod; i++) {
					setTempo(i + 1);
					atualizarPanel();
					atualizarTempo();
					Thread.sleep(100);
				}

				setStatus(EStatusProcesso.PARADO);
				atualizarPanel();

				this.armazemColocar.coloca(prod);

				setTempo(0);
				setProduto(0);
				setTotal(getTotal() + 1);
				atualizarTempo();
				atualizarPanel();

			} catch (InterruptedException e) {
				
			}
		}
		
		setTempo(0);
		setProduto(0);
		setStatus(EStatusProcesso.FINALIZADO);
		atualizarPanel();
	}
}