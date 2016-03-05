package financeiro.app.exception;

/**
 * Generic exception thrown by the application in any invalid state.
 */
public class ApplicationException extends Exception {

    private static final long serialVersionUID = 1L;

	public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
