package br.com.ahe.aed.rodacki.listas;

public class NoListaDupla {
	
	private int info;
	private NoListaDupla prox;
	private NoListaDupla ant;
	
	public int getInfo() {
		return this.info;
	}
	
	public NoListaDupla getProx() {
		return this.prox;
	}
	
	public NoListaDupla getAnt() {
		return this.ant;
	}
	
	public void setInfo(int info) {
		this.info = info;
	}
	
	public void setProx(NoListaDupla prox) {
		this.prox = prox;
	}
	
	public void setAnt(NoListaDupla ant) {
		this.ant = ant;
	}
	
	@Override
	public String toString() {
		return "Valor = "+this.info;
	}
}
