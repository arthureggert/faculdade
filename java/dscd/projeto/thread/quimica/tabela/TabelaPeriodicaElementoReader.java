package br.com.ahe.dscd.projeto.thread.quimica.tabela;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TabelaPeriodicaElementoReader {

	private Scanner scan;
	
	private List<TabelaPeriodicaElemento> elementos;

	public TabelaPeriodicaElementoReader(Scanner scan) {
		this.scan = scan;
		this.elementos = new ArrayList<TabelaPeriodicaElemento>();
	}
	
	public List<TabelaPeriodicaElemento> getElementos() {
		while (this.scan.hasNext()) {
			String nomeAtomo = this.scan.next();
			Integer noxAtomo = this.scan.nextInt();
			String siglaAtomo = this.scan.next();
			Integer pesoAtomo = this.scan.nextInt();
			String grupoAtomo = this.scan.next();	
			criaElementoTabela(nomeAtomo,noxAtomo,siglaAtomo,pesoAtomo,grupoAtomo);
		}
		return this.elementos;
	}

	private void criaElementoTabela(String nomeAtomo, Integer noxAtomo,String siglaAtomo, Integer pesoAtomo, String grupoAtomo) {
		TabelaPeriodicaElemento tabelaPeriodicaElemento = new TabelaPeriodicaElemento(nomeAtomo,noxAtomo,siglaAtomo,pesoAtomo,grupoAtomo);
		this.elementos.add(tabelaPeriodicaElemento);
	}

}
