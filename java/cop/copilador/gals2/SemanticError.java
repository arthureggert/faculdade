package br.com.ahe.cop.copilador.gals2;

public class SemanticError extends AnalysisError
{
	private static final long serialVersionUID = 1L;
	
    public SemanticError(String msg, int possicao, int linha, String token){
        super(msg, possicao, linha, token);
    }

    public SemanticError(String msg){
        super(msg);
    }
}
