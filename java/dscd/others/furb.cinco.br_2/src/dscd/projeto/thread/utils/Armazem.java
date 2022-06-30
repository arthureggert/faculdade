package dscd.projeto.thread.utils;

import java.util.ArrayList;
import java.util.List;

import core.utils.AObjectUtils;
import dscd.projeto.thread.quimica.molecula.Molecula;
import dscd.projeto.thread.quimica.reacao.ReacaoQuimica;

public class Armazem {
	
	private List<Molecula> moleculas;
	
	private List<Molecula> acidos;
	
	private List<Molecula> bases;
	
	private List<ReacaoQuimica> resultados;
	
	public Armazem() {
		moleculas = new ArrayList<Molecula>();
		acidos = new ArrayList<Molecula>();
		bases = new ArrayList<Molecula>();
		resultados = new ArrayList<ReacaoQuimica>();
	}

	public List<Molecula> getMoleculas() {
		return moleculas;
	}
	
	public void addMolecula(Molecula molecula) {
		if(!AObjectUtils.isObjectNull(molecula)){
			moleculas.add(molecula);					
		}
	}

	public void removeMolecula(Molecula molecula) {
		moleculas.remove(molecula);		
	}

	public void addMoleculaAcido(Molecula molecula) {
		acidos.add(molecula);
	}
	
	public void removeMoleculaAcido(Molecula molecula) {
		acidos.remove(molecula);		
	}
	
	public void addMoleculaBase(Molecula molecula) {
		bases.add(molecula);
	}

	public void removeMoleculaBase(Molecula molecula) {
		bases.remove(molecula);
	}
	
	public void addMoleculaResultado(ReacaoQuimica reacao) {
		resultados.add(reacao);
	}
	
	public List<Molecula> getAcidos() {
		return acidos;
	}
	
	public List<Molecula> getBases() {
		return bases;
	}
	
	public List<ReacaoQuimica> getResultados() {
		return resultados;
	}
	
}
