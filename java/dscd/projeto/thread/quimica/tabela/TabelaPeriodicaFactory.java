package br.com.ahe.dscd.projeto.thread.quimica.tabela;

import java.util.List;
import java.util.Scanner;

import utils.AFileUtils;

/**
 * Classe responsavel pelo criação da tabela<br>
 * periodica com os "Atomos" e seuas informações iniciais
 * @author arthur
 **/
public class TabelaPeriodicaFactory {

	private List<TabelaPeriodicaElemento> elementos;
	
	private TabelaPeriodica tabelaPeriodica;
	
	private static TabelaPeriodicaFactory instance;

	private static final String ARQUIVO = "C:\\Users\\roa\\workspace\\git\\furb-all\\furb-all\\furb5\\src\\main\\resources\\TabelaPeriodica.txt"; 

	public static TabelaPeriodicaFactory getInstance() {
		if(instance == null){
			instance = new TabelaPeriodicaFactory();
		}
		return instance;
	}

	private TabelaPeriodicaFactory() {	
		Scanner scan = AFileUtils.getScannerFromFileWithSeparator(ARQUIVO, "#|\\n");
		TabelaPeriodicaElementoReader reader = new TabelaPeriodicaElementoReader(scan);
		this.elementos = reader.getElementos();
		this.tabelaPeriodica = new TabelaPeriodica(this.elementos);
	}


	public List<TabelaPeriodicaElemento> getElementos() {
		return this.elementos;
	}
	
	public TabelaPeriodica getTabelaPeriodica() {
		return this.tabelaPeriodica;
	}

	public TabelaPeriodicaElemento getElementBySigla(String siglaAtomo) {
		for (TabelaPeriodicaElemento elemento : this.elementos) {
			if(elemento.getSigla().equals(siglaAtomo)){
				return elemento;
			}
		}
		return null;
	}
}
