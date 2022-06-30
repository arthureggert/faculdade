package dscd.projeto.thread.quimica.molecula;

import java.util.ArrayList;
import java.util.List;

import core.utils.AListUtils;
import dscd.projeto.thread.quimica.atomo.Atomo;

public class Molecula {

	private List<Atomo> atomos;
	
	private String nome;
	
	public Molecula(Atomo atomo) {
		atomos = new ArrayList<Atomo>();
		addAtomoLast(atomo);
	}

	public Molecula() {
		atomos = new ArrayList<Atomo>();
	}

	public List<Atomo> getAtomos() {
		return atomos;
	}

	public void addAtomoLast(Atomo atomo) {
		atomos.add(atomo);		
	}
	
	public void addAtomoFirst(Atomo atomo) {
		atomos.add(0, atomo);
	}

	public Integer getNox() {
		Integer nox = 0;
		for (Atomo atomo : atomos) {
			nox = nox + atomo.getNox();
		}
		return nox;
	}
	
	@Override
	public String toString() {
		String toString = "";
		toString = "[" + nome + " " + getSilgas() +  " " + getNox() + "]";
		return toString;
	}

	public String getSilgas() {
		String sigla = "";
		for (Atomo atomo : atomos) {
			sigla += atomo.getSigla();
		}
		return sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Atomo getLastElementFromAtomos() {
		return AListUtils.getLastObjectFromList(atomos);
	}

	public void removeAtomo(Atomo atomo) {
		atomos.remove(atomo);
	}
	
	
}
