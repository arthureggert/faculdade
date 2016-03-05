package br.com.ahe.banco.exception;

public class PaginaNaoEncontradaException extends Exception {

    private static final long serialVersionUID = 1L;

    public PaginaNaoEncontradaException () {
    	super("Pagina não encontrada na lista!");
    }
}
