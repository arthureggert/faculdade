package br.com.ahe.ldp.produtor.L1311H04;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Armazem {

	private int armazem[];

	private int inicioFilaCircular;

	private int fimFilaCircular;

	private final int tamanho;

	private PanelArmazem panel;

	private List<Processo> listaProcessos;

	private Semaphore exclusivo;

	private Semaphore naoCheio;

	private Semaphore naoVazio;

	public Armazem(int tam) {
		this.tamanho = tam;
		this.armazem = new int[this.tamanho];
		this.inicioFilaCircular = this.fimFilaCircular = 0;
		this.exclusivo = new Semaphore(1);
		this.naoCheio = new Semaphore(this.tamanho);
		this.naoVazio = new Semaphore(0);
	}

	public void coloca(int produto) throws InterruptedException {
		this.naoCheio.acquire();
		this.exclusivo.acquire();
		this.armazem[this.fimFilaCircular] = produto;
		this.fimFilaCircular = (this.fimFilaCircular + 1) % this.tamanho;
		this.exclusivo.release();
		this.naoVazio.release();
		atualizaPanel();
	}

	public int retira() throws InterruptedException {
		int tempo = 10;
		if (this.naoVazio.tryAcquire(tempo * 6, TimeUnit.SECONDS)) {
			this.exclusivo.acquire();
			int produtoTemporario = this.armazem[this.inicioFilaCircular];
			this.armazem[this.inicioFilaCircular] = 0;
			this.inicioFilaCircular = (this.inicioFilaCircular + 1) % this.tamanho;
			this.exclusivo.release();
			this.naoCheio.release();
			atualizaPanel();
			return produtoTemporario;
		} else if (todosProcessosSerieAnteriorFinalizados()) {
			return -1;
		}

		return -1;
	}

	private boolean todosProcessosSerieAnteriorFinalizados() {
		if (this.listaProcessos != null) {
			for (Processo p : this.listaProcessos) {
				if (p.termina == false || !p.getStatus().equals(EStatusProcesso.FINALIZADO)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	private void atualizaPanel() {
		if (this.panel != null) {
			this.panel.atualizar(this.armazem, this.inicioFilaCircular, this.fimFilaCircular);
		}
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public void setListaProcessos(List<Processo> produtores) {
		this.listaProcessos = produtores;
	}

	public void setPanel(PanelArmazem armazemPanel) {
		this.panel = armazemPanel;
	}
}