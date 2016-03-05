package br.com.ahe.banco.exception;

public class TamanhoDoRegistroException extends Exception {

	private static final long serialVersionUID = 1L;

	public TamanhoDoRegistroException(String nome, int esperado , int recebido) {
		super(String.format("Qtd de campos invalidos para inserir na tabela %s(Esperado %s recebido %s)", nome , esperado , recebido));
	}
}
