package br.com.ahe.banco.exception;

public class PaginaEmUsoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PaginaEmUsoException ( int pageID ) {
    	super( pageID + " in use!" );
    }
    
}
