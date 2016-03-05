package br.com.ahe.aed.tavares.arvore;

import br.com.ahe.aed.tavares.fila.FilaEncadeada;
import br.com.ahe.aed.tavares.pilha.NodoPilhaComMarca;
import br.com.ahe.aed.tavares.pilha.PilhaEncadeada;
import br.com.ahe.aed.tavares.pilha.PilhaEncadeadaComMarca;

/**
 * Class to working with a binary tree
 * @author arthur
 **/

public class ArvoreBinaria {

	private NodoArvore raiz;
	 
	/**
	 * Class constructor of the binary tree
	 **/
	public ArvoreBinaria(){
		this.raiz = null;
	}
	
	/**
	 * @return the root of the binary tree
	 **/
	public NodoArvore getRaiz() {
		return this.raiz;
	}
	
	/**
	 * Set the root of the binary tree
	 * @param raiz
	 **/
	public void setRaiz(NodoArvore raiz) {
		this.raiz = raiz;
	}
	
	/**
	 * Insert a new element into the binary tree
	 * this method does not work with recursion.
	 * @param the element to insert into the binary tree
	 **/
	public void insere2(int info) {
		NodoArvore nodo = new NodoArvore(info);
		if( this.raiz == null){
			this.raiz = nodo;
			return;
		} else {
		    NodoArvore t = this.raiz;
		    while ( true ){
		    	if (info < t.getInfo()) {
		    		if( t.getEsquerda() != null) {
		    			t = t.getEsquerda();		    			
		    		} else {
		    			t.setEsquerda(nodo);
		    			return;
		    		}
		    	} else {
		    		if(t.getDireita() != null) {
		    			t = t.getDireita();
		    		} else {
		    			t.setDireita(nodo);
		    			return;
		    		}
		    	}
		    }   
		}
	}
	
	/**
	 * Insert a new element in the binary tree
	 * This method call a another private method, working with recursion
	 * @param the element to insert (must be a integer)
	 **/
    public void insere(int info) {
    	this.raiz = insere(this.raiz,info);
    }
    
    /**
     * A helper method for the method insere()
     * This method work with recursion
     * @param The root of the tree
     * @param The element to insert
     * @return New NodoArvore of the binary tree
     */
    private NodoArvore insere(NodoArvore nodoRaiz, int info){
    	if(nodoRaiz == null){
    		nodoRaiz = new NodoArvore(info);
       	} else {
    		if(info < nodoRaiz.getInfo()){
    			nodoRaiz.setEsquerda(insere(nodoRaiz.getEsquerda(),info));
    		} else {
    			nodoRaiz.setDireita(insere(nodoRaiz.getDireita(), info));
    		}
    	}
    	return nodoRaiz;
    }
    

    
    public String preFixadoRecusivo(){
    	return prefixadoRecursivoAux(this.raiz,"");
    }

	private String prefixadoRecursivoAux(NodoArvore raiz, String strTmp) {
		if(raiz != null){
			strTmp += raiz.getInfo() + ", ";
			strTmp = prefixadoRecursivoAux(raiz.getEsquerda(), strTmp);
			strTmp = prefixadoRecursivoAux(raiz.getDireita(), strTmp);
		}	
		return strTmp;
	}
	
	public String imprimePre(){
		return imprimePre(this.raiz);
	}
	
    private String imprimePre(NodoArvore no) {
        String s = new String("");
        s += "<";
        if (no != null) {
            s = s + no.getInfo();
            s = s + imprimePre(no.getEsquerda());
            s = s + imprimePre(no.getDireita());
        }
        s += ">";

        return s;
    }
    
	public void preFixadoNaoRecursivo() {
		PilhaEncadeada p = new PilhaEncadeada();
		p.empilha(this.raiz);
		NodoArvore nodo;
		while (!p.isVazia()) {
			nodo = (NodoArvore) p.desempilha();
			if( nodo != null) {
				System.out.println(nodo.getInfo());
				p.empilha(nodo.getDireita());
				p.empilha(nodo.getEsquerda());
			}
		}
	}
	
	public void posFixadoRecursivo(){
		posFixadoRecursivoAux(this.raiz);
	}

	private void posFixadoRecursivoAux(NodoArvore raiz) {
		if(raiz != null){
			posFixadoRecursivoAux(raiz.getEsquerda());
			posFixadoRecursivoAux(raiz.getDireita());
			System.out.println(raiz.getInfo());
		}
	}
	
	
	public void posFixadoNaoRecursivo() {
		NodoPilhaComMarca nodopilha;
		PilhaEncadeadaComMarca p = new PilhaEncadeadaComMarca();
		NodoArvore nodoArvore;
		p.empilha(this.raiz, false);
		while (!p.vazia()) {
			nodopilha = (NodoPilhaComMarca) p.desempilha();
			nodoArvore = (NodoArvore) nodopilha.getElemento();
			if(  nodoArvore != null) {
				if( nodopilha.getMarca() == false) {
					p.empilha(nodoArvore, true);
					p.empilha(nodoArvore.getDireita(), false);
					p.empilha(nodoArvore.getEsquerda(), false);
				} else {
					System.out.println(nodoArvore.getInfo());
				}
			}
		}
	}
	
	public void centralFixadoRecursivo(){
		centralFixadoRecursivoAux(this.raiz);
	}

	private void centralFixadoRecursivoAux(NodoArvore raiz) {
		if(raiz != null){
			centralFixadoRecursivoAux(raiz.getEsquerda());
			System.out.println(raiz.getInfo());
			centralFixadoRecursivoAux(raiz.getDireita());			
		}
	}
	
    public void centralFixadoNaoRecursivo(){
    	NodoPilhaComMarca nodopilha;
		PilhaEncadeadaComMarca p = new PilhaEncadeadaComMarca();
		NodoArvore nodoArvore;
		p.empilha(this.raiz, false);
		while (!p.vazia()) {
			nodopilha = (NodoPilhaComMarca) p.desempilha();
			nodoArvore = (NodoArvore) nodopilha.getElemento();
			if(nodoArvore != null){
				if(!nodopilha.isMarca()){
					p.empilha(nodoArvore.getDireita(), false);
					p.empilha(nodoArvore, true);
					p.empilha(nodoArvore.getEsquerda(), false);
				} else {
					System.out.println(nodoArvore.getInfo());
				}
			}
		}  	
    }
	
    public int contaElementoNaoRecursivo() {
        int conta = 0;
        PilhaEncadeada p = new PilhaEncadeada();
        p.empilha(this.raiz);
        NodoArvore nodo;
        while (!p.isVazia()) {
            nodo = (NodoArvore) p.desempilha();
            if (nodo != null) {
                conta++;
                p.empilha(nodo.getDireita());
                p.empilha(nodo.getEsquerda());
            }
        }
        return conta;
    }
	
	public int contaElementoRecursivo() {
		return contaElementoRecursivoAux(this.raiz, 0);
	}
	
	private int contaElementoRecursivoAux(NodoArvore raiz, int conta) {
		if (raiz != null) {
			conta++;
			conta = contaElementoRecursivoAux(raiz.getEsquerda(), conta);
			conta = contaElementoRecursivoAux(raiz.getDireita(), conta);
		}
		return conta;
	}
	
	public int contaElementoRecursivoSemVariavel(NodoArvore raiz){
		if(raiz != null) {
			return (contaElementoRecursivoSemVariavel(raiz.getEsquerda())+contaElementoRecursivoSemVariavel(raiz.getDireita())+1);
		} else {
			return 0;
		}
	}
	
	/**
	 * Public method to count the number of leafs from the binary tree
	 * This method call a another method. 
	 * @return the number of leafs;
	 **/
	public int contaFolhas(){
		return contaFolhas(this.raiz,0);
	}
	
	/**
	 * A helper method for the method contaFolhas()
	 * This methos wrok with recursion
	 * @param raiz is the main NodoArvore of the binary tree 
	 * @param totFolhas is the counter of leafs
	 * @return The number of leafs of the binary tree
	 **/
	private int contaFolhas(NodoArvore raiz, int totFolhas) {
		if(raiz.getEsquerda() == null && raiz.getDireita() == null){
			return ++totFolhas;
		} else {	
			if(raiz.getDireita() != null){
				totFolhas = contaFolhas(raiz.getDireita(), totFolhas);				
			} 
			if (raiz.getEsquerda() != null){
				totFolhas = contaFolhas(raiz.getEsquerda(), totFolhas);				
			}
		}
		return totFolhas;
	}
    
	public NodoArvore criaArvore(){
		return (criaArvore("abc**d***", 0));
	}
	
	private NodoArvore criaArvore(String c, int i){
		
		char simbolo = c.charAt(i);
		
		if (simbolo == '*'){
			return null;
		} else {
			
			NodoArvore no = new NodoArvore(simbolo);
			
			no.setEsquerda(criaArvore(c, i+1));
			
			no.setDireita(criaArvore(c, i+2));
			
			System.out.println(i + " " + no.getInfo());
			return no;
		}	
	}
	/**
	 * Public method to compare two binary trees, call another method to make the comparison
	 * @param A1 is the another tree who the method use to compare
	 * @return true if the two trees are equals
	 **/
	public boolean compara(ArvoreBinaria A1){
		return compara(A1.getRaiz(), this.getRaiz());	
	}

	/**
	 * A private helper method to make a comparison on two nodes of the binary tree
	 * @param raizOutra is the node of the another tree 
	 * @param raizThis is the node of this tree
	 * @return true if the two nodes are equals
	 */
	private boolean compara(NodoArvore raizOutra, NodoArvore raizThis) {
		boolean iguais = true;
		if(raizOutra != null && raizThis != null){
			if(raizOutra.equals(raizThis)){
				iguais = compara(raizOutra.getEsquerda(), raizThis.getEsquerda());
				iguais = compara(raizOutra.getDireita(), raizThis.getDireita());
			} else {
				return false;
			}
		}		
		return iguais;
	}
	
	/**
	 * Public method to clone a binary tree into another binary tree
	 * @return the new binary tree
	 **/
    public ArvoreBinaria copia() {
        ArvoreBinaria tmpArv = new ArvoreBinaria();
        NodoArvore temp = tmpArv.raiz;
        copiaNo(temp, this.raiz);
        return tmpArv;
    }

    /**
     * A helper method to clone a node of the binary tree
	 * @param raizOutra is the node of the another tree 
	 * @param raizThis is the node of this tree
     **/
    private void copiaNo(NodoArvore raizOutra, NodoArvore raizThis) {
        if (raizThis != null) {
            raizOutra = new NodoArvore(raizThis.getInfo());
            copiaNo(raizOutra.getEsquerda(), raizThis.getEsquerda());
            copiaNo(raizOutra.getDireita(), raizThis.getDireita());
        }
    }
    
    
    public ArvoreBinaria copiaNR() {
		ArvoreBinaria r = new ArvoreBinaria();
		r.setRaiz(copiadorNR(this.getRaiz()));
		return r;
	}

	private NodoArvore copiadorNR(NodoArvore a) {
		PilhaEncadeada p = new PilhaEncadeada();

		if (a == null)
			return null;
		else {
			NodoArvore b = new NodoArvore(a.getInfo());
			p.empilha(b);
			p.empilha(a);
			NodoArvore v;
			NodoArvore n;
			while (!p.isVazia()) {
				v = (NodoArvore) p.desempilha();
				n = (NodoArvore) p.desempilha();
				n.setInfo(v.getInfo());
				if (v.getDireita() != null) {
					NodoArvore t = new NodoArvore();
					n.setDireita(t);
					p.empilha(t);
					p.empilha(v.getDireita());
				} else {
					n.setDireita(null);
				}
				if (v.getEsquerda() != null) {
					NodoArvore t = new NodoArvore();
					n.setEsquerda(t);
					p.empilha(t);
					p.empilha(v.getEsquerda());
				} else {
					n.setEsquerda(null);
				}
			}
			return b;
		}

	}
    
    /**
     * Public method to count the height of the binary tree
     * @return the height of the binary tree
     **/
    public int maxNivel(){
    	if(this.raiz != null){
    		return maxNivel(this.raiz, 1);    		
    	} 
    	return 0;
    	
    }

    /**
     * Private method to count the height of the binary tree 
     * @param raiz is a node of the binary tree
     * @param nivel is the height of the tree 
     * @return the height of the binary tree
     **/
	private int maxNivel(NodoArvore raiz, int nivel) {
		if(raiz.getDireita() != null || raiz.getEsquerda() != null){
			nivel++;
			if(raiz.getDireita() != null){
				nivel = maxNivel(raiz.getDireita(), nivel);
			}
			if(raiz.getEsquerda() != null){
				nivel = maxNivel(raiz.getEsquerda(), nivel);
			}
		}
		return nivel;
	}
	
    public NodoArvore retira(int v) {
        return retira(this.raiz, v);
    }

    private NodoArvore retira(NodoArvore noRaiz, int info) {
        if (noRaiz == null) {
            return null;
        } else {
        	if(info < noRaiz.getInfo()){
        		noRaiz.setEsquerda(retira(noRaiz.getEsquerda(),info));
        	} else {
        		if (info > noRaiz.getInfo()){
        			noRaiz.setDireita(retira(noRaiz.getDireita(),info));
        		} else {
        			if(noRaiz.getEsquerda() == null && noRaiz.getDireita() == null){
        				noRaiz = null;
        			} else {
        				if(noRaiz.getEsquerda() == null){
        					noRaiz = noRaiz.getDireita();
        				} else {
        					if(noRaiz.getDireita() == null){
        						noRaiz = noRaiz.getEsquerda();
        					} else {
        						NodoArvore p = noRaiz.getEsquerda();
        						while(p.getDireita() != null){
        							p = p.getDireita();
        						}
        						noRaiz.setInfo(p.getInfo());
        						p.setInfo(info);
        						noRaiz.setEsquerda(retira(noRaiz.getEsquerda(),info));
        					}
        				}
        			}
        		}
        	}
        }
        return noRaiz;
    }
    
    public void excluiFolhas() {
		if (this.raiz != null)
			setRaiz(this.excluiFolhasR(this.raiz));
	}

	public NodoArvore excluiFolhasR(NodoArvore n) {
		if ((n.getEsquerda() == null) && (n.getDireita() == null))
			return null;
		else {
			System.out.println(n.getInfo());
			if (n.getEsquerda() != null)
				n.setEsquerda(excluiFolhasR(n.getEsquerda()));
			if (n.getDireita() != null)
				n.setDireita(excluiFolhasR(n.getDireita()));
			return n;
		}
	}

    
    public String percoreAplitude(){
    	NodoArvore tmp;
    	FilaEncadeada fila = new FilaEncadeada();
    	String ret = "";
    	fila.insereFila(this.raiz);
    	while(!fila.isVazia()){
    		tmp = (NodoArvore) fila.removeFila();
    		if(tmp != null){
    			ret += " "+tmp.getInfo();
    			if(tmp.getDireita() != null){
    				fila.insereFila(tmp.getDireita());
    			}
    			if(tmp.getEsquerda() != null){
    				fila.insereFila(tmp.getEsquerda());
    			}
    			if(tmp.getDireita() != null){
    				fila.insereFila(tmp.getDireita());
    			}
    		}
    	}
    	return ret;
    }
    
	public NodoArvore pesquisaArvoreBinaria(int elemento) {
		NodoArvore temp = this.raiz;
		while ((temp != null) && (temp.getInfo() != elemento)) {

			if (temp.getInfo() > elemento)
				temp = temp.getEsquerda();
			else
				temp = temp.getDireita();
		}
		return temp;
	}
	
	public void listaNivel(int nivel) {
		int nnivel = 0;
		listaNivelR(this.raiz, nivel, nnivel);
	}

	private void listaNivelR(NodoArvore r, int nivel, int nivelAtual) {
		if (r != null)
			if (nivel == nivelAtual)
				System.out.println(r.getInfo());
			else {
				if (nivelAtual < nivel) {
					nivelAtual++;
					listaNivelR(r.getEsquerda(), nivel, nivelAtual);
					listaNivelR(r.getDireita(), nivel, nivelAtual);
				}
			}
	}

	
	public boolean ehFolha(NodoArvore p) {
		if ((p.getEsquerda() == null) && (p.getDireita() == null))
			return true;
		else
			return false;
	}
	
	public NodoArvore pai(NodoArvore p)
	{
		NodoArvore q = null;
		NodoArvore nodo;
		if(this.raiz.getInfo() == p.getInfo())
		{
              return null;
		}
		else{
			boolean achei = false;
			nodo = this.raiz;
			while ((nodo != null) && (!achei ))
			{
				if(nodo.getInfo() == p.getInfo())
				{
					return q;
				}
				else
					if(nodo.getInfo() > p.getInfo())
					{
						q = nodo;
						nodo = nodo.getEsquerda();
					}
					else
					{   q = nodo;
						nodo = nodo.getDireita();
					}
			}
			return null;
				
			}

		}
			
		
	public NodoArvore sucessorCentral(NodoArvore p)
	{
	    NodoArvore n = p.getDireita();
	    boolean achei = false;
	    while (( n != null) && (!achei ))
	    {
	    	if(n.getEsquerda() != null)
	    		n = n.getEsquerda();
	    	else
	    		achei = true;
	    }
	    return n;
	}
	
	public void removeArvore(NodoArvore p)
	{
		removeArvoreR(this.raiz, p);
	}
	

	private void removeArvoreR(NodoArvore r, NodoArvore p)
	{
		NodoArvore q = pai(p);
		System.out.println("!pai = " + q.getInfo());
		
		if(p.getEsquerda() == null )
		{
			if( pai(p) == null)  // se pai == null -> � a raiz
				this.raiz = p.getDireita();
			else
			{
				if ( q.getEsquerda() == p )
					q.setEsquerda(p.getDireita());
				else
					q.setDireita(p.getDireita());
			}
		}
		else {
			if(p.getDireita() == null)
			{
				if( pai(p) == null)
					this.raiz = p.getDireita();
				else
				{
					if(q.getDireita() == p)
						q.setDireita(p.getEsquerda());
					else
						q.setEsquerda(p.getEsquerda());
				}
			}
			else
			{
				NodoArvore t = sucessorCentral(p);
				p.setInfo(t.getInfo());
				removeArvoreR(r, t);
				return;
				
			}
		}
				
	}
	
	
	public void excluiFolhas2() {
		this.setRaiz(excluiFolhasR(this.raiz));
	}

	public NodoArvore excluiFolhasR2(NodoArvore n) {
		NodoArvore proximoE = n.getEsquerda();
		if (proximoE != null)
			if (ehFolha(proximoE))
				n.setEsquerda(null);
			else
				excluiFolhasR2(n.getEsquerda());
		NodoArvore proximoD = n.getDireita();
		if (proximoD != null)
			if (ehFolha(proximoD))
				n.setDireita(null);
			else
				excluiFolhasR2(n.getDireita());
		return n;
	}
}



	
	
