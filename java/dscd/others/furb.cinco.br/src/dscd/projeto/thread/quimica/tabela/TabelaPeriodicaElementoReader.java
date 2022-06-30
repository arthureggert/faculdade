package dscd.projeto.thread.quimica.tabela;

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
		while (scan.hasNext()) {
			String nomeAtomo = scan.next();
			Integer noxAtomo = scan.nextInt();
			String siglaAtomo = scan.next();
			Integer pesoAtomo = scan.nextInt();
			String grupoAtomo = scan.next();	
			criaElementoTabela(nomeAtomo,noxAtomo,siglaAtomo,pesoAtomo,grupoAtomo);
		}
		return elementos;
	}

	private void criaElementoTabela(String nomeAtomo, Integer noxAtomo,String siglaAtomo, Integer pesoAtomo, String grupoAtomo) {
		TabelaPeriodicaElemento tabelaPeriodicaElemento = new TabelaPeriodicaElemento(nomeAtomo,noxAtomo,siglaAtomo,pesoAtomo,grupoAtomo);
		elementos.add(tabelaPeriodicaElemento);
	}

}
