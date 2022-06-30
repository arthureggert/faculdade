package dscd.projeto.thread.quimica.atomo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dscd.projeto.thread.quimica.tabela.TabelaPeriodicaElemento;
import dscd.projeto.thread.quimica.tabela.TabelaPeriodicaFactory;

public class AtomoReader {
private Scanner scan;
	
	private List<Atomo> atomos;

	public AtomoReader(Scanner scan) {
		this.scan = scan;
		this.atomos = new ArrayList<Atomo>();
	}
	
	public List<Atomo> getElementos() {
		while (scan.hasNext()) {
			String siglaAtomo = scan.next(); 
			criaAtomo(siglaAtomo);
		}
		return atomos;
	}

	private void criaAtomo(String siglaAtomo) {
		TabelaPeriodicaElemento elemento = TabelaPeriodicaFactory.getInstance().getElementBySigla(siglaAtomo);
		Atomo atomo = new Atomo(elemento);
		atomos.add(atomo);
	}

}
