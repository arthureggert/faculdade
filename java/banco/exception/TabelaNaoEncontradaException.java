package br.com.ahe.banco.exception;

public class TabelaNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 1L;

	public TabelaNaoEncontradaException(String nome) {
		super(String.format("Tabela %s não encontrada", nome));
	}

}
