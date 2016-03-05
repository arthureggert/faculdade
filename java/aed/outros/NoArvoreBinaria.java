package br.com.ahe.aed.outros;

public class NoArvoreBinaria {
	
	private int info;
	
	private NoArvoreBinaria esq;
	
	private NoArvoreBinaria dir;
	
	public NoArvoreBinaria(int info) {
		setInfo(info);
		setEsq(null);
		setDir(null);
	}

	public NoArvoreBinaria(int info, NoArvoreBinaria esq, NoArvoreBinaria dir) {
		setInfo(info);
		setEsq(esq);
		setDir(dir);
	}

	public int getInfo() {
		return this.info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public NoArvoreBinaria getEsq() {
		return this.esq;
	}

	public void setEsq(NoArvoreBinaria esq) {
		this.esq = esq;
	}

	public NoArvoreBinaria getDir() {
		return this.dir;
	}

	public void setDir(NoArvoreBinaria dir) {
		this.dir = dir;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getInfo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dir == null) ? 0 : this.dir.hashCode());
		result = prime * result + ((this.esq == null) ? 0 : this.esq.hashCode());
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
		NoArvoreBinaria other = (NoArvoreBinaria) obj;
		if (this.dir == null) {
			if (other.dir != null)
				return false;
		} else if (!this.dir.equals(other.dir))
			return false;
		if (this.esq == null) {
			if (other.esq != null)
				return false;
		} else if (!this.esq.equals(other.esq))
			return false;
		if (this.info != other.info)
			return false;
		return true;
	}
	
}
