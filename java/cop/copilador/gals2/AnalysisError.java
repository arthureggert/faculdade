package br.com.ahe.cop.copilador.gals2;

public class AnalysisError extends Exception
{
	private static final long serialVersionUID = 1L;
	
	private int possicao;
	private int linha;
	private String token;

    public AnalysisError(String msg, int possicao, int linha, String token){
        super(msg);
        this.possicao = possicao;
        this.linha = linha;
        this.token = token;
        
    }

    public AnalysisError(String msg) {
        super(msg);
        this.possicao = -1;
        this.linha = -1;
    }

    public int getPossicao(){
        return this.possicao;
    }
    
    public int getLinha() {
		return this.linha;
	}
    
    public String getToken() {
		return this.token;
	}

    public String toString(){ 
        return super.toString() + ", @ " + this.possicao + ", @ " + this.linha;
    }
    
    @Override
    public String getMessage() {
    	return "Erro na linha " + getLinha() + " - " + super.getMessage();
    }
}
