package br.com.ahe.aed.provas.prova2;


public class NodoPilhaComMarca 
{
	private Object elemento;
	private boolean marca;
	private NodoPilhaComMarca anterior;

	public NodoPilhaComMarca(Object elemento, boolean marca) 
	{
		this.elemento = elemento;
		this.marca = marca;
		this.anterior = null;
	}

	public void setAnterior(NodoPilhaComMarca nodo) {
		this.anterior = nodo;
	}

	public Object getElemento() {
		return this.elemento;
	}

	public NodoPilhaComMarca getAnterior() {
		return this.anterior;
	}

	public boolean getMarca() {
		return this.marca;
	}

	public void setMarca(boolean marca) {
		this.marca = marca;
	}
	
	
}
