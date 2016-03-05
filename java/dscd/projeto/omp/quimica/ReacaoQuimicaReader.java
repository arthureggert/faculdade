package br.com.ahe.dscd.projeto.omp.quimica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ahe.dscd.projeto.thread.quimica.atomo.Atomo;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;
import br.com.ahe.dscd.projeto.thread.quimica.reacao.ReacaoQuimica;
import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaElemento;
import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaFactory;

public class ReacaoQuimicaReader {

	private Scanner scan;

	private List<ReacaoQuimica> reacoes;

	public ReacaoQuimicaReader(Scanner scan) {
		this.scan = scan;
		this.reacoes = new ArrayList<ReacaoQuimica>();		
	}

	public List<ReacaoQuimica> getReacoes() {
		while (this.scan.hasNext()) {
			criaReacao(this.scan);
		}
		return this.reacoes;
	}

	private void criaReacao(Scanner scan) {
		String nomeAcido = scan.next().replaceAll("\\r", "");
		String moleculaAcido = scan.next().replaceAll("\\r", "");
		String nomeBase = scan.next().replaceAll("\\r", "");
		String moleculaBase = scan.next().replaceAll("\\r", "");
		String resultadoRecao = scan.next().replaceAll("\\r", "");
		Molecula acido = criaMolecula(nomeAcido, moleculaAcido);
		Molecula base = criaMolecula(nomeBase, moleculaBase);
		ReacaoQuimica reacao = new ReacaoQuimica(acido, base);
		reacao.addMoleculaResultante(criaMolecula("", resultadoRecao));
		this.reacoes.add(reacao);
	}

	private Molecula criaMolecula(String nome, String molecula) {
		Molecula mol = new Molecula();
		mol.setNome(nome);
		mol.addAtomos(criaAtomos(molecula));
		return mol;
	}

	private List<Atomo> criaAtomos(String molecula) {
		List<Atomo> atomosMolecula = new ArrayList<Atomo>();
		String[] moleculaSplit = molecula.split("(?=\\p{Lu})");

		for (String siglaAtomo : moleculaSplit) {
			if(!siglaAtomo.trim().isEmpty()){
				TabelaPeriodicaElemento elemento = TabelaPeriodicaFactory.getInstance().getElementBySigla(siglaAtomo.trim());
				atomosMolecula.add(new Atomo(elemento));					
			}
		}
		return atomosMolecula;
	}

}
