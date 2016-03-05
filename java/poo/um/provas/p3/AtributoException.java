package br.com.ahe.poo.um.provas.p3;
/** Arthur Henrique Eggert **/

@SuppressWarnings("serial")
public class AtributoException extends Exception {

    public AtributoException(Throwable cause) {
        super(cause);
    }

    public AtributoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtributoException(String message) {
        super(message);
    }

    public AtributoException() {
    }
}
