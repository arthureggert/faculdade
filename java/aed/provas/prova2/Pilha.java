package br.com.ahe.aed.provas.prova2;

public class Pilha {
	private NodoPilha topo;
	private NodoPilha base;

	public Pilha() {
		this.topo = null;
		setBase(null);
	}

	public void empilha(Object elemento) {
		NodoPilha nodo = new NodoPilha(elemento);
		if (this.topo == null) /* pilha vazia */
			setBase(nodo);
		nodo.setAnterior(this.topo);
		this.topo = nodo;
	}
	
	public Object desempilha() {

		if (this.topo != null) {
			NodoPilha nodo = this.topo;
			this.topo = nodo.getAnterior();
			return nodo.getElemento();
		} else
			return null;
	}

	public boolean vazia() {
		if (this.topo == null)
			return true;
		else
			return false;
	}

	public NodoPilha getBase() {
		return this.base;
	}

	public void setBase(NodoPilha base) {
		this.base = base;
	}
}
