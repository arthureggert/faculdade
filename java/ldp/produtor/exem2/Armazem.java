package br.com.ahe.ldp.produtor.exem2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Armazem {

	private int armazem[];
	private int iniFila;
	private int fimFila;
	private final int TAMANHO;
	private int qtdProdutores;
	private PanelArmazem panel;
	private Semaphore exclusivo;
	private Semaphore naoCheio;
	private Semaphore naoVazio;

	public Armazem(int tam, int qtdProdutores) {
		this.TAMANHO = tam;
		this.qtdProdutores = qtdProdutores;
		this.armazem = new int[this.TAMANHO];
		this.iniFila = this.fimFila = 0;

		this.exclusivo = new Semaphore(1);
		this.naoCheio = new Semaphore(this.TAMANHO);
		this.naoVazio = new Semaphore(0);
	}

	public void coloca(int produto) throws InterruptedException {
		this.naoCheio.acquire();
		this.exclusivo.acquire();
		this.armazem[this.fimFila] = produto;
		this.fimFila = (this.fimFila + 1) % this.TAMANHO;
		this.exclusivo.release();
		this.naoVazio.release();
		atualizaPanel();
	}

	public int retira() throws InterruptedException {
		if (this.naoVazio.tryAcquire(200 * 200 * this.qtdProdutores, TimeUnit.MILLISECONDS)) {
			this.exclusivo.acquire();
			int produtoTemporario = this.armazem[this.iniFila];
			this.armazem[this.iniFila] = 0;
			this.iniFila = (this.iniFila + 1) % this.TAMANHO;
			this.exclusivo.release();
			this.naoCheio.release();
			atualizaPanel();
			return produtoTemporario;
		}
		atualizaPanel();
		return -1;
	}

	private void atualizaPanel() {
		if (this.panel != null) {
			this.panel.atualizar(this.armazem, this.iniFila, this.fimFila);
		}
	}

	public int getTamanho() {
		return this.TAMANHO;
	}

	public void setPanel(PanelArmazem armazemPanel) {
		this.panel = armazemPanel;
	}
}
