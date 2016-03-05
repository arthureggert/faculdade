package br.com.ahe.banco.tabela;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoColuna {

	VARCHAR("Varchar");
	
	@Getter
	private String nome;
	
}
