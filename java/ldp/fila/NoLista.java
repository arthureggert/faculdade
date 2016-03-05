package br.com.ahe.ldp.fila;

public class NoLista {

	private String info;
	private NoLista prox;

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public NoLista getProx() {
		return this.prox;
	}

	public void setProx(NoLista prox) {
		this.prox = prox;
	}
}
