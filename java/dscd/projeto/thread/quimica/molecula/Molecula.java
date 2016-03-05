package br.com.ahe.dscd.projeto.thread.quimica.molecula;

import java.util.ArrayList;
import java.util.List;

import utils.AListUtils;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.Atomo;

public class Molecula {

	private List<Atomo> atomos;
	
	private String nome;
	
	private String classificacao;
	
	public Molecula(Atomo atomo) {
		this.atomos = new ArrayList<Atomo>();
		addAtomoLast(atomo);
	}

	public Molecula() {
		this.atomos = new ArrayList<Atomo>();
	}

	public List<Atomo> getAtomos() {
		return this.atomos;
	}

	public void addAtomoLast(Atomo atomo) {
		this.atomos.add(atomo);		
	}
	
	public void addAtomoFirst(Atomo atomo) {
		this.atomos.add(0, atomo);
	}

	public Integer getNox() {
		Integer nox = 0;
		for (Atomo atomo : this.atomos) {
			nox = nox + atomo.getNox();
		}
		return nox;
	}
	
	@Override
	public String toString() {
		String toString = "";
		toString = "[" + this.nome + " " + getSilgas() +  " " + getNox() + "]";
		return toString;
	}

	public String getSilgas() {
		String sigla = "";
		for (Atomo atomo : this.atomos) {
			sigla += atomo.getSigla();
		}
		return sigla;
	}

	public String getNome() {
		return this.nome.trim();
	}

	public void setNome(String nome) {
		this.nome = nome.replace("\n", "");
	}

	public Atomo getLastElementFromAtomos() {
		return AListUtils.getLastObjectFromList(this.atomos);
	}

	public Atomo getFisrtElementFromAtomos() {
		return AListUtils.getFirstObjectFromList(this.atomos);
	}

	public void removeAtomo(Atomo atomo) {
		this.atomos.remove(atomo);
	}

	public void addAtomos(List<Atomo> molecula) {
		this.atomos.addAll(molecula);
	}
	
	public String getClassificacao() {
		return this.classificacao.trim();
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
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
		Molecula other = (Molecula) obj;
		if (this.nome.trim() == null) {
			if (other.nome.trim()!= null)
				return false;
		} else if (!this.nome.trim().equals(other.nome.trim()))
			return false;
		return true;
	}
}
