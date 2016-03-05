package br.com.ahe.dscd.projeto.omp.quimica;

import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;

public class ReacaoQuimica2 {

	private Molecula acido;

	private Molecula base;

	private Molecula agua;

	private Molecula sal;

	public ReacaoQuimica2(Molecula acido, Molecula base, Molecula agua, Molecula sal) {
		this.acido = acido;
		this.base = base;
		this.agua = agua;
		this.sal = sal;
	}

	public ReacaoQuimica2() {

	}

	public Molecula getAcido() {
		return this.acido;
	}

	public void setAcido(Molecula acido) {
		this.acido = acido;
	}

	public Molecula getBase() {
		return this.base;
	}

	public void setBase(Molecula base) {
		this.base = base;
	}

	public Molecula getAgua() {
		return this.agua;
	}

	public void setAgua(Molecula agua) {
		this.agua = agua;
	}

	public Molecula getSal() {
		return this.sal;
	}

	public void setSal(Molecula sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return  this.acido.getNome() + "#" + this.acido.getSilgas() + "#" + 
				this.base.getNome() + "#" + this.base.getSilgas()  + "#" + 
				this.agua.getNome() + "#" + this.agua.getSilgas() + "#" +
				this.sal.getNome() + "#" + this.sal.getSilgas();  
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.acido == null) ? 0 : this.acido.hashCode());
		result = prime * result + ((this.agua == null) ? 0 : this.agua.hashCode());
		result = prime * result + ((this.base == null) ? 0 : this.base.hashCode());
		result = prime * result + ((this.sal == null) ? 0 : this.sal.hashCode());
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
		ReacaoQuimica2 other = (ReacaoQuimica2) obj;
		if (this.acido == null) {
			if (other.acido != null)
				return false;
		} else if (!this.acido.equals(other.acido))
			return false;
		if (this.agua == null) {
			if (other.agua != null)
				return false;
		} else if (!this.agua.equals(other.agua))
			return false;
		if (this.base == null) {
			if (other.base != null)
				return false;
		} else if (!this.base.equals(other.base))
			return false;
		if (this.sal == null) {
			if (other.sal != null)
				return false;
		} else if (!this.sal.equals(other.sal))
			return false;
		return true;
	}
	
	
	
	

}
