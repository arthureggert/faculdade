package br.com.ahe.aed.tavares.arquivo;

public class NodoArvore {
	
	private int referenciaAluno;
	private int possicaoArquivo;
	private NodoArvore nodoEsquerda;
	private NodoArvore nodoDireita;
	
	
	
	public NodoArvore(int referenciaAluno, int possicaoArquivo) {
		this.referenciaAluno = referenciaAluno;
		this.possicaoArquivo = possicaoArquivo;
	}

	public NodoArvore ( int referenciaAluno2 ) {
    }

	public int getReferenciaAluno() {
		return this.referenciaAluno;
	}
	
	public int getPossicaoArquivo() {
		return this.possicaoArquivo;
	}
	
	public NodoArvore getNodoEsquerda() {
		return this.nodoEsquerda;
	}
	
	public NodoArvore getNodoDireita() {
		return this.nodoDireita;
	}
	
	public void setReferenciaAluno(int referenciaAluno) {
		this.referenciaAluno = referenciaAluno;
	}
	
	public void setPossicaoArquivo(int possicaoArquivo) {
		this.possicaoArquivo = possicaoArquivo;
	}
	
	public void setNodoEsquerda(NodoArvore nodoEsquerda) {
		this.nodoEsquerda = nodoEsquerda;
	}
	
	public void setNodoDireita(NodoArvore nodoDireita) {
		this.nodoDireita = nodoDireita;
	}
	
}
