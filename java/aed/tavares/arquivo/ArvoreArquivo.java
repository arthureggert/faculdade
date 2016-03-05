package br.com.ahe.aed.tavares.arquivo;


public class ArvoreArquivo {

	private NodoArvore raiz;
	
	public ArvoreArquivo(NodoArvore raiz) {
		super();
		this.raiz = raiz;
	}

	public NodoArvore getRaiz() {
		return this.raiz;
	}

	public void setRaiz(NodoArvore raiz) {
		this.raiz = raiz;
	}
	
   public void insere(int referenciaAluno, int possicaoArquivo) {
    	this.raiz = insere(this.raiz,referenciaAluno,possicaoArquivo);
    }
	    
    private NodoArvore insere(NodoArvore nodoRaiz, int referenciaAluno, int possicaoArquivo){
    	if(nodoRaiz == null){
    		nodoRaiz = new NodoArvore(referenciaAluno);
       	} else {
    		if(referenciaAluno < nodoRaiz.getReferenciaAluno()){
    			nodoRaiz.setNodoEsquerda(insere(nodoRaiz.getNodoEsquerda(),referenciaAluno, possicaoArquivo));
    		} else {
    			nodoRaiz.setNodoDireita(insere(nodoRaiz.getNodoDireita(), referenciaAluno, possicaoArquivo));
    		}
    	}
    	return nodoRaiz;
    }
}
