package br.com.ahe.dscd.projeto.thread.utils;

import java.util.ArrayList;
import java.util.List;

import utils.AObjectUtils;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;
import br.com.ahe.dscd.projeto.thread.quimica.reacao.ReacaoQuimica;

public class Armazem {
	
	private List<Molecula> moleculas;
	
	private List<Molecula> acidos;
	
	private List<Molecula> bases;
	
	private List<ReacaoQuimica> resultados;
	
	public Armazem() {
		this.moleculas = new ArrayList<Molecula>();
		this.acidos = new ArrayList<Molecula>();
		this.bases = new ArrayList<Molecula>();
		this.resultados = new ArrayList<ReacaoQuimica>();
	}

	public List<Molecula> getMoleculas() {
		return this.moleculas;
	}
	
	public void addMolecula(Molecula molecula) {
		if(!AObjectUtils.isObjectNull(molecula)){
			this.moleculas.add(molecula);					
		}
	}

	public void removeMolecula(Molecula molecula) {
		this.moleculas.remove(molecula);		
	}

	public void addMoleculaAcido(Molecula molecula) {
		this.acidos.add(molecula);
	}
	
	public void removeMoleculaAcido(Molecula molecula) {
		this.acidos.remove(molecula);		
	}
	
	public void addMoleculaBase(Molecula molecula) {
		this.bases.add(molecula);
	}

	public void removeMoleculaBase(Molecula molecula) {
		this.bases.remove(molecula);
	}
	
	public void addMoleculaResultado(ReacaoQuimica reacao) {
		this.resultados.add(reacao);
	}
	
	public List<Molecula> getAcidos() {
		return this.acidos;
	}
	
	public List<Molecula> getBases() {
		return this.bases;
	}
	
	public List<ReacaoQuimica> getResultados() {
		return this.resultados;
	}
	
}
