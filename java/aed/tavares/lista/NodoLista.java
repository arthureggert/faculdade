package br.com.ahe.aed.tavares.lista;

public class NodoLista {

	private int info;
	private NodoLista proximo;
	
	public NodoLista(int info){
		this.info = info;
		this.setProximo(null);
	}
	
	public int getInfo() {
		return this.info;
	}

	public NodoLista getProximo() {
		return this.proximo;
	}

	public void setProximo(NodoLista proximo) {
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return "INFO = "+this.info;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.info;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		NodoLista other = (NodoLista) obj;
		if (this.info != other.info)
			return false;
		return true;
	}
	
	
}
