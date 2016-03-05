package br.com.ahe.dscd.projeto.thread.quimica.reacao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import br.com.ahe.dscd.projeto.thread.quimica.atomo.Atomo;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.AtomoNaoEncontradoException;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;
import br.com.ahe.dscd.projeto.thread.utils.AQuimicaUtils;
import br.com.ahe.dscd.projeto.thread.utils.Armazem;

public class GeraReacaoAcidoBase {

	private Semaphore geraMolecula;	
	
	private Armazem dados;
	
	public GeraReacaoAcidoBase(Armazem armazem) {
		this.geraMolecula = new Semaphore(1);
		this.dados = armazem;
	}
	
	public void executaReacao() {
		try {
			if(this.dados.getAcidos().isEmpty() || this.dados.getBases().isEmpty()){
				return;
			}
			this.geraMolecula.acquire();
			Molecula acido = getAcido();
			Molecula base = getBase();
			List<Atomo> atomosAcido = new ArrayList<Atomo>(acido.getAtomos());
			List<Atomo> atomosBase = new ArrayList<Atomo>(base.getAtomos());
			ReacaoQuimica reacao = new ReacaoQuimica(acido, base);
			geraAgua(atomosAcido, atomosBase, reacao);
			geraSalResultante(atomosAcido, atomosBase, reacao);
			this.dados.addMoleculaResultado(reacao);
			this.geraMolecula.release();
			System.out.println(reacao.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void geraSalResultante(List<Atomo> atomosAcido, List<Atomo> atomosBase, ReacaoQuimica reacao) {
		Molecula sal = new Molecula();
		for (Atomo atomo : atomosAcido) {
			sal.addAtomoFirst(atomo);
		}
		for (Atomo atomo : atomosBase) {
			sal.addAtomoFirst(atomo);
		}
		reacao.addMoleculaResultante(sal);
	}

	private void geraAgua(List<Atomo> atomosAcido, List<Atomo> atomosBase, ReacaoQuimica reacao) {
		Molecula agua = new Molecula();
		try {
			Atomo atomo = AQuimicaUtils.getFirstAtomoFromList(atomosAcido, "H");
			atomosAcido.remove(atomo);
			agua.addAtomoFirst(atomo);
			atomo = AQuimicaUtils.getFirstAtomoFromList(atomosBase, "OH");
			atomosBase.remove(atomo);
			agua.addAtomoFirst(atomo);
			reacao.addMoleculaResultante(agua);
		} catch (AtomoNaoEncontradoException e) {
			e.printStackTrace();
		}
		
	}

	public Molecula getAcido(){
		Molecula acido = AQuimicaUtils.getRandomMoleculaFromList(this.dados.getAcidos());
		this.dados.removeMoleculaAcido(acido);
		return acido;
	}
	
	public Molecula getBase(){
		Molecula base = AQuimicaUtils.getRandomMoleculaFromList(this.dados.getBases());
		this.dados.removeMoleculaBase(base);
		return base;
	}
}
