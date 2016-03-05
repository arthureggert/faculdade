package br.com.ahe.cop.copilador.gals2;

public class LexicalError extends AnalysisError
{
	private static final long serialVersionUID = 1L;
	
    public LexicalError(String msg, int possicao, int linha, String token){
        super(msg, possicao, linha, token);
    }

    public LexicalError(String msg){
        super(msg);
    }
    
}
