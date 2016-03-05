package br.com.ahe.cop.copilador.gals2;

public class SyntaticError extends AnalysisError
{
	private static final long serialVersionUID = 1L;
	
    public SyntaticError(String msg, int possicao, int linha, String token){
        super(msg, possicao, linha, token);
    }

    public SyntaticError(String msg) {
        super(msg);
    }
    
    @Override
    public String getMessage() {
    	return super.getMessage() + " Encontrado " + getToken();
    }
}
