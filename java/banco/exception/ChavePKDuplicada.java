package br.com.ahe.banco.exception;

public class ChavePKDuplicada extends Exception {

	public ChavePKDuplicada(String chave , String tabela) {
		super(String.format("Chave primaria em duplicidade(chave: %s , tabela: %s)", chave , tabela));
	}

	private static final long serialVersionUID = 1L;

}
