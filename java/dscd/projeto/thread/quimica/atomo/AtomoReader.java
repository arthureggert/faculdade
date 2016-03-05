package br.com.ahe.dscd.projeto.thread.quimica.atomo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaElemento;
import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaFactory;

public class AtomoReader {
	private Scanner scan;

	private List<Atomo> atomos;

	public AtomoReader(Scanner scan) {
		this.scan = scan;
		this.atomos = new ArrayList<Atomo>();
	}

	public List<Atomo> getElementos() {
		while (this.scan.hasNext()) {
			String siglaAtomo = this.scan.next(); 
			criaAtomo(siglaAtomo);
		}
		return this.atomos;
	}

	private void criaAtomo(String siglaAtomo) {
		TabelaPeriodicaElemento elemento = TabelaPeriodicaFactory.getInstance().getElementBySigla(siglaAtomo);
		Atomo atomo = new Atomo(elemento);
		this.atomos.add(atomo);
	}

}
