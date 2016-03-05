package br.com.ahe.aed.provas.prova2;

public class NodoPilha

{
	private Object elemento;
	private NodoPilha anterior;

	public NodoPilha(Object elemento) {
		this.elemento = elemento;
		this.anterior = null;
	}

	public void setAnterior(NodoPilha nodo) {
		this.anterior = nodo;
	}

	public Object getElemento() {
		return this.elemento;
	}

	public NodoPilha getAnterior() {
		return this.anterior;
	}
}