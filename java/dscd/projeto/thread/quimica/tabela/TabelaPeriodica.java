package br.com.ahe.dscd.projeto.thread.quimica.tabela;

import java.util.ArrayList;
import java.util.List;

public class TabelaPeriodica {

	private List<TabelaPeriodicaElemento> elementos;
	
	public TabelaPeriodica(List<TabelaPeriodicaElemento> elementos) {
		this.elementos = elementos;
	}
	
	public List<TabelaPeriodicaElemento> getElementos() {
		return this.elementos;
	}
	
	public List<String> getSilgaElementosAsLIst(){
		List<String> siglas = new ArrayList<String>();
		for (TabelaPeriodicaElemento elemento : this.elementos) {
			siglas.add(elemento.getSigla());
		}
		return siglas;
	}

}
