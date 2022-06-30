package dscd.projeto.thread.quimica.reacao;

import java.util.concurrent.Semaphore;

import dscd.projeto.thread.quimica.atomo.Atomo;
import dscd.projeto.thread.quimica.atomo.AtomoNaoEncontradoException;
import dscd.projeto.thread.quimica.molecula.Molecula;
import dscd.projeto.thread.utils.AQuimicaUtils;
import dscd.projeto.thread.utils.Armazem;

public class GeraReacaoAcidoBase {

	private Semaphore geraMolecula;	
	
	private Armazem dados;
	
	public GeraReacaoAcidoBase(Armazem armazem) {
		this.geraMolecula = new Semaphore(1);
		this.dados = armazem;
	}
	
	public void executaReacao() {
		try {
			if(dados.getAcidos().isEmpty() || dados.getBases().isEmpty()){
				return;
			}
			geraMolecula.acquire();
			Molecula acido = getAcido();
			Molecula base = getBase();
			ReacaoQuimica reacao = new ReacaoQuimica(acido, base);
			geraAgua(acido, base, reacao);
			geraSalResultante(acido, base, reacao);
			dados.addMoleculaResultado(reacao);
			geraMolecula.release();
			System.out.println(reacao.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void geraSalResultante(Molecula acido, Molecula base, ReacaoQuimica reacao) {
		Molecula sal = new Molecula();
		for (Atomo atomo : acido.getAtomos()) {
			sal.addAtomoFirst(atomo);
		}
		for (Atomo atomo : base.getAtomos()) {
			sal.addAtomoFirst(atomo);
		}
		reacao.addMoleculaResultante(sal);
	}

	private void geraAgua(Molecula acido, Molecula base, ReacaoQuimica reacao) {
		Molecula agua = new Molecula();
		try {
			Atomo atomo = AQuimicaUtils.getFirstAtomoFromList(acido.getAtomos(), "H");
			acido.removeAtomo(atomo);
			agua.addAtomoFirst(atomo);
			atomo = AQuimicaUtils.getFirstAtomoFromList(base.getAtomos(), "OH");
			base.removeAtomo(atomo);
			agua.addAtomoFirst(atomo);
			reacao.addMoleculaResultante(agua);
		} catch (AtomoNaoEncontradoException e) {
			e.printStackTrace();
		}
		
	}

	public Molecula getAcido(){
		Molecula acido = AQuimicaUtils.getRandomMoleculaFromList(dados.getAcidos());
		dados.removeMoleculaAcido(acido);
		return acido;
	}
	
	public Molecula getBase(){
		Molecula base = AQuimicaUtils.getRandomMoleculaFromList(dados.getBases());
		dados.removeMoleculaBase(base);
		return base;
	}
}
