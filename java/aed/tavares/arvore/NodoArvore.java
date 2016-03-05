package br.com.ahe.aed.tavares.arvore;

public class NodoArvore implements Comparable<NodoArvore>{

	private NodoArvore esquerda;
	private NodoArvore direita;
	private int info;
	
	public NodoArvore(int info){
		this.setInfo(info);
		this.setEsquerda(null);
		this.setDireita(null);
	}
	
	public NodoArvore() {
	}

	public NodoArvore getEsquerda() {
		return this.esquerda;
	} 
	
	public NodoArvore getDireita() {
		return this.direita;
	}
	
	public int getInfo() {
		return this.info;
	} 
	
	public void setEsquerda(NodoArvore esquerda) {
		this.esquerda = esquerda;
	}
	
	public void setDireita(NodoArvore direita) {
		this.direita = direita;
	}
	
	public void setInfo(int info) {
		this.info = info;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.direita == null) ? 0 : this.direita.hashCode());
		result = prime * result	+ ((this.esquerda == null) ? 0 : this.esquerda.hashCode());
		result = prime * result + this.info;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodoArvore other = (NodoArvore) obj;
		if (this.direita == null) {
			if (other.direita != null)
				return false;
		} else if (!this.direita.equals(other.direita))
			return false;
		if (this.esquerda == null) {
			if (other.esquerda != null)
				return false;
		} else if (!this.esquerda.equals(other.esquerda))
			return false;
		if (this.info != other.info)
			return false;
		return true;
	}

	@Override
	public int compareTo(NodoArvore o) {
		return this.getInfo() - o.getInfo();
	}
	
	
	
}
