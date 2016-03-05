package br.com.ahe.poo.um.provas.p5;

public class AtributoObrigatorioException extends Exception {

	private static final long serialVersionUID = 1L;

	public AtributoObrigatorioException(Throwable cause) {
        super(cause);
    }

    public AtributoObrigatorioException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtributoObrigatorioException(String message) {
        super(message);
    }

    public AtributoObrigatorioException() {
    }
}
