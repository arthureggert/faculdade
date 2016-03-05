package br.com.ahe.aed.tavares.hash;
public class Entrada {
	
    private int chave;
    private int info;
    private char situacao;
    
    public Entrada(int chave, int info) {
       this.chave = chave;
       this.info = info;
       this.situacao = 2;   // ocupado
    }
    
	public int getChave() {
		return this.chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public int getInfo() {
		return this.info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public char getSituacao() {
		return this.situacao;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}
}
