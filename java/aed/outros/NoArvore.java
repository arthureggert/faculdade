package br.com.ahe.aed.outros;


public class NoArvore {
	
	private NoArvore prim;
	
	private NoArvore prox;

	private int info;
	
	public NoArvore(int info) {
		setInfo(info);
		setPrim(null);
		setProx(null);
	}
	
	public NoArvore getPrim() {
		return this.prim;
	}

	public void setPrim(NoArvore prim) {
		this.prim = prim;
	}

	public NoArvore getProx() {
		return this.prox;
	}

	public void setProx(NoArvore prox) {
		this.prox = prox;
	}

	public int getInfo() {
		return this.info;
	}

	public void setInfo(int info) {
		this.info = info;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.info;
		result = prime * result + ((this.prim == null) ? 0 : this.prim.hashCode());
		result = prime * result + ((this.prox == null) ? 0 : this.prox.hashCode());
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
		NoArvore other = (NoArvore) obj;
		if (this.info != other.info)
			return false;
		if (this.prim == null) {
			if (other.prim != null)
				return false;
		} else if (!this.prim.equals(other.prim))
			return false;
		if (this.prox == null) {
			if (other.prox != null)
				return false;
		} else if (!this.prox.equals(other.prox))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(getInfo());
	}
	
}
