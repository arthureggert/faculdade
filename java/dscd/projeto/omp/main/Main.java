package br.com.ahe.dscd.projeto.omp.main;

import br.com.ahe.dscd.projeto.omp.omps.ClassificaReacaoQuimicaOMP_jomp;
import br.com.ahe.dscd.projeto.omp.omps.CriaReacoesOMP_jomp;
import br.com.ahe.dscd.projeto.omp.omps.NomeiaSaisOMP_jomp;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimicaFactory;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.AtomoFactory;

public class Main {

	public static void main(String[] args) {
		AtomoFactory.getInstance().getAtomos();
	
		CriaReacoesOMP_jomp omp = new CriaReacoesOMP_jomp();
		ReacaoQuimica2[] reacoes = omp.criaReacoes(ReacaoQuimicaFactory.getInstance().getReacoes());
		ClassificaReacaoQuimicaOMP_jomp classificaOMP = new ClassificaReacaoQuimicaOMP_jomp();
		classificaOMP.classificaReacaoQuimica(reacoes, omp);
		NomeiaSaisOMP_jomp nomOMP = new NomeiaSaisOMP_jomp();
		nomOMP.nomearSal(reacoes, omp);
		
		for (ReacaoQuimica2 reacao: reacoes) {
			System.out.println(reacao);
		}
	}



}
