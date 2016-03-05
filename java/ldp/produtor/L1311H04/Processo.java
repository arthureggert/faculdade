package br.com.ahe.ldp.produtor.L1311H04;

import java.util.Random;

public class Processo extends Thread {

	protected Armazem armazemColocar;
	protected Armazem armazemRetirar;
	protected Random r = new Random();

	private int id;

	protected int produto;
	protected int tempo;
	protected EStatusProcesso status;
	protected int total;

	protected boolean termina;
	protected PanelGenerico panel;

	public Processo(int id, Armazem armazemAnterior, Armazem armazemProximo) throws InterruptedException {
		this.id = id;
		this.armazemRetirar = armazemAnterior;
		this.armazemColocar = armazemProximo;
		this.termina = false;

		start();
	}

	public void setPanel(PanelGenerico panel) {
		this.panel = panel;
	}

	public void terminar() {
		this.termina = true;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getIdentificador() {
		return this.id;
	}

	public int getProduto() {
		return this.produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public int getTempo() {
		return this.tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public EStatusProcesso getStatus() {
		return this.status;
	}

	public void setStatus(EStatusProcesso status) {
		this.status = status;
	}

	protected void atualizarTempo() {
		if (this.panel != null) {
			this.panel.atualizarTempo();
		}
	}

	protected void atualizarPanel() {
		if (this.panel != null) {
			this.panel.atualizar();
		}
	}
}