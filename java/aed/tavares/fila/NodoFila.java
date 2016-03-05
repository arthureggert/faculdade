package br.com.ahe.aed.tavares.fila;


public class NodoFila {

	private Object info;
	private NodoFila proximo;
	
	public NodoFila(Object info){
		this.info = info;
		this.setProximo(null);
	}
	
	public Object getInfo() {
		return this.info;
	}

	public NodoFila getProximo() {
		return this.proximo;
	}

	public void setProximo(NodoFila proximo) {
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return "INFO = "+this.info;
	}	


}
