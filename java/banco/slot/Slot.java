package br.com.ahe.banco.slot;

import br.com.ahe.banco.tabela.Registro;
import br.com.ahe.banco.tabela.Tabela;
import lombok.Getter;

public class Slot {
	
	@Getter
	private RID rid;
	
	@Getter
	private Slot proximo;
	
	@Getter
	private String[] informacoes;

	public int getTamanho() {
		return informacoes.length;
	}

	private void criaInformacoes(Tabela tabela, Registro dado) {	
		char[] charArray = dado.getRegistroAsString().toCharArray();
		informacoes = new String[tabela.getQtdColunas() + charArray.length];
		int indexSize = tabela.getQtdColunas();
		int proxIndex = 0 + indexSize;
		int i = 0;
		informacoes[i] = String.valueOf(proxIndex);
		for (int j = 0 ; i < dado.getRegistro().length -1 ;  j++ ) {
			i++;
			String sDado = dado.getRegistro()[j];
			proxIndex += sDado .length();
			informacoes[i] = String.valueOf(proxIndex);
		}
		for (int j = 0; j < charArray.length; j++) {
			i++;
			informacoes[i] = String.valueOf(charArray[j]);
		}
		

	}

	public static Slot criaSlot(int paginaID, Slot prox, Tabela tabela, Registro dado, int slotID) {
		Slot slot = new Slot();
		slot.rid = new RID(paginaID, slotID);
		slot.proximo = prox;
		slot.criaInformacoes(tabela , dado);
		return slot;
	}


}
