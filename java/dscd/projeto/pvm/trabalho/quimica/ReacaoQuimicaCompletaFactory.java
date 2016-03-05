package br.com.ahe.dscd.projeto.pvm.trabalho.quimica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import utils.AFileUtils;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.Atomo;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.AtomoFactory;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;
import br.com.ahe.dscd.projeto.thread.quimica.reacao.ReacaoQuimica;
import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaElemento;
import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaFactory;

public class ReacaoQuimicaCompletaFactory {

	private HashSet<ReacaoQuimica> reacoes;
	
	public ReacaoQuimicaCompletaFactory() {
		AtomoFactory.getInstance().getAtomos();
		this.reacoes = new HashSet<ReacaoQuimica>();
	}
	
	public HashSet<ReacaoQuimica> criaReacoes(){
		String filePath = "c:\\temp\\saida";
		scanneiaReacoes(AFileUtils.getScannerFromFileWithSeparator(filePath, "\\n"));
		return this.reacoes;
	}

	private void scanneiaReacoes(Scanner scan) {
		while (scan.hasNext()) {
			criaReacao(scan);
		}
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
