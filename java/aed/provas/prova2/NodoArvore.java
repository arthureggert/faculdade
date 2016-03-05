package br.com.ahe.aed.provas.prova2;


public class NodoArvore {
	
	private int info;
	private NodoArvore esquerda;
	private NodoArvore direita;

	public NodoArvore(int info) 
	{
		this.info = info;
		this.esquerda = null;
		this.direita = null;
	}	
	
	public int getInfo() {
		return this.info;
	}

	public NodoArvore getEsquerda() {
		return this.esquerda;
	}
	public void setEsquerda(NodoArvore esquerda) {
		this.esquerda = esquerda;
	}
	public NodoArvore getDireita() {
		return this.direita;
	}
	public void setDireita(NodoArvore direita) {
		this.direita = direita;
	}

}
