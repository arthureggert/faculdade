package br.com.ahe.aed.rodacki.pilhas;

public class NoPilha {
	
	private int info;
	private NoPilha prox;

	public int getInfo() {
		return this.info;
	}
	
	public NoPilha getProx() {
		return this.prox;
	}
	
	public void setInfo(int info) {
		this.info = info;
	}
	
	public void setProx(NoPilha prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		return "NoLista [Valor = " + this.info+" ]";
	}
	
	

}
