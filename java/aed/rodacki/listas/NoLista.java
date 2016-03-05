package br.com.ahe.aed.rodacki.listas;

public class NoLista {
	
	private int info;
	private NoLista prox;
	
	public int getInfo() {
		return this.info;
	}
	
	public NoLista getProx() {
		return this.prox;
	}
	
	public void setInfo(int info) {
		this.info = info;
	}
	
	public void setProx(NoLista prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		return "NoLista [Valor = " + this.info+" ]";
	}
	
	

}
