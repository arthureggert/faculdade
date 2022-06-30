package dscd.projeto.thread.quimica.tabela;

import java.util.List;
import java.util.Scanner;

import core.utils.AFileUtils;

/**
 * Classe responsavel pelo criação da tabela<br>
 * periodica com os "Atomos" e seuas informações iniciais
 * @author arthur
 **/
public class TabelaPeriodicaFactory {

	private List<TabelaPeriodicaElemento> elementos;
	
	private TabelaPeriodica tabelaPeriodica;
	
	private static TabelaPeriodicaFactory instance;

	private static final String ARQUIVO = "resources/TabelaPeriodica"; 

	public static TabelaPeriodicaFactory getInstance() {
		if(instance == null){
			instance = new TabelaPeriodicaFactory();
		}
		return instance;
	}

	private TabelaPeriodicaFactory() {	
		Scanner scan = AFileUtils.getScannerFromFileWithSeparator(ARQUIVO, "#|\\n");
		TabelaPeriodicaElementoReader reader = new TabelaPeriodicaElementoReader(scan);
		elementos = reader.getElementos();
		tabelaPeriodica = new TabelaPeriodica(elementos);
	}


	public List<TabelaPeriodicaElemento> getElementos() {
		return elementos;
	}
	
	public TabelaPeriodica getTabelaPeriodica() {
		return tabelaPeriodica;
	}

	public TabelaPeriodicaElemento getElementBySigla(String siglaAtomo) {
		for (TabelaPeriodicaElemento elemento : elementos) {
			if(elemento.getSigla().equals(siglaAtomo)){
				return elemento;
			}
		}
		return null;
	}
}
