package dscd.projeto.thread.quimica.reacao;

import java.util.ArrayList;
import java.util.List;

import dscd.projeto.thread.quimica.molecula.Molecula;

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
		return base;
	}

	public void setBase(Molecula base) {
		this.base = base;
	}

	public Molecula getAcido() {
		return acido;
	}

	public void setAcido(Molecula acido) {
		this.acido = acido;
	}
	
	public List<Molecula> getMoleculasResultantes() {
		return moleculasResultantes;
	}

	public void addMoleculaResultante(Molecula molecula) {
		moleculasResultantes.add(molecula);		
	}
	
	@Override
	public String toString() {
		return "Acido = " + acido.getNome() + "\nBase = " + base.getNome() + "\nResultado = " + getResultos();
	}

	private String getResultos() {
		String str = "";
		for (Molecula molecula : moleculasResultantes) {
			str += molecula.getSilgas() + " ";
		}
		return str;
	}

}
