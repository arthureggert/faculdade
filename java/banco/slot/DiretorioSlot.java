package br.com.ahe.banco.slot;

import br.com.ahe.banco.tabela.Registro;
import br.com.ahe.banco.tabela.Tabela;

public class DiretorioSlot {
	
	private static final int MAX_SIZE = 128;

	private Slot raiz;
	
	public void addSlot(Registro dado , Tabela tabela , int paginaID) {
		Slot tmp = Slot.criaSlot(paginaID , raiz , tabela , dado, getQtdSlots() + 1);
		raiz = tmp;
	}
	
	public int getPossicaoEspacoLivre() {
		return MAX_SIZE - tamanhoAtual();
	}
	
	public int getQtdSlots() {
		int qtd = 0;
		Slot tmp = raiz;
		while ( raiz != null ) {
			qtd++;
			tmp = tmp.getProximo();
		}
		return qtd;
	}
	
	
	private int tamanhoAtual() {
		int tamanho = 0;
		Slot tmp = raiz;
		if( tmp != null ) {
			tamanho += tmp.getTamanho();
			tmp = tmp.getProximo();
		}
		return tamanho;
	}

}
