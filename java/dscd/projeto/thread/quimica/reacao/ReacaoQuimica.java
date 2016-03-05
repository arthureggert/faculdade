package br.com.ahe.dscd.projeto.thread.quimica.reacao;

import java.util.ArrayList;
import java.util.List;

import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;

public class ReacaoQuimica {

	private Molecula acido;
	
	private Molecula base;
	
	private List<Molecula> moleculasResultantes;

	public ReacaoQuimica(Molecula acido, Molecula base) {
		this.setAcido(acido);
		this.setBase(base);
		this.moleculasResultantes = new ArrayList<Molecula>();
	}

	public Molecula getBase() {
		return this.base;
	}

	public void setBase(Molecula base) {
		this.base = base;
	}

	public Molecula getAcido() {
		return this.acido;
	}

	public void setAcido(Molecula acido) {
		this.acido = acido;
	}
	
	public List<Molecula> getMoleculasResultantes() {
		return this.moleculasResultantes;
	}

	public void addMoleculaResultante(Molecula molecula) {
		this.moleculasResultantes.add(molecula);		
	}
	
	@Override
	public String toString() {
		return  this.acido.getNome() + "|" + this.acido.getSilgas() + 
				"\n" + this.base.getNome() + "|" + this.base.getSilgas() +
				"\n" + getResultos();
	}

	public String getResultos() {
		String str = "";
		for (Molecula molecula : this.moleculasResultantes) {
			str += molecula.getSilgas() + " ";
		}
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.acido == null) ? 0 : this.acido.hashCode());
		result = prime * result + ((this.base == null) ? 0 : this.base.hashCode());
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
		ReacaoQuimica other = (ReacaoQuimica) obj;
		if (this.acido == null) {
			if (other.acido != null)
				return false;
		} else if (!this.acido.equals(other.acido))
			return false;
		if (this.base == null) {
			if (other.base != null)
				return false;
		} else if (!this.base.equals(other.base))
			return false;
		return true;
	}
	
	
}
