package br.com.ahe.banco.tabela;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode(of = {"nome","tipo"})
public class Coluna {

	@Getter
	private String nome;
	
	@Getter
	private TipoColuna tipo;
	
	@Getter
	private int tamanhoMaximo;
	
	@Getter
	private boolean chavePrimaria;
	
}
