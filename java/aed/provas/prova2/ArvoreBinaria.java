package br.com.ahe.aed.provas.prova2;


public class ArvoreBinaria {
	
	private NodoArvore raiz;
	
	public ArvoreBinaria()
	{
		this.raiz = null;
	}
	
	public void setRaiz(NodoArvore r)
	{
		this.raiz = r;
	}
	
	public void insereArvore(int info)
	{
		NodoArvore nodo = new NodoArvore(info);
		if( this.raiz == null)
		{
			this.raiz = nodo;
			return;
		}
		else
		{
		    NodoArvore t = this.raiz;
		    while ( true)
		    {
		    	if(info < t.getInfo())
		    	{
		    		if( t.getEsquerda() != null)
		    		{
		    			t = t.getEsquerda();
		    			
		    		}
		    		else
		    		{
		    			t.setEsquerda(nodo);
		    			return;
		    		}
		    	}
		    	else
		    	{
		    		if(t.getDireita() != null)
		    		{
		    			t = t.getDireita();
		    		}
		    		else
		    		{
		    			t.setDireita(nodo);
		    			return;
		    		}
		    	}
		    }
		    
		    
		}
				
		 
	}
	public void insere2(int info){
		this.raiz=insere2(this.raiz,info);
	}
	
	
	private NodoArvore insere2(NodoArvore nodoRaiz, int info) {
		if(nodoRaiz == null){
			nodoRaiz = new NodoArvore(info);
		} else {
			if(info < nodoRaiz.getInfo()){
				nodoRaiz.setEsquerda(insere2(nodoRaiz.getEsquerda(),info));
			} else {
				nodoRaiz.setDireita(insere2(nodoRaiz.getDireita(),info));
			}
		}
		return nodoRaiz;
		
	}

	public void preFixadoNR()
	{
		Pilha p = new Pilha();
		p.empilha(this.raiz);
		NodoArvore nodo;
		while (!p.vazia())
		{
			nodo = (NodoArvore) p.desempilha();
			if( nodo != null)
			{
				System.out.println(nodo.getInfo());
				p.empilha(nodo.getDireita());
				p.empilha(nodo.getEsquerda());
			}
			
		}
		
	}
	
	public void posFixadoNR()
	{
		NodoPilhaComMarca nodopilha;
		PilhaComMarca p = new PilhaComMarca();
		NodoArvore nodoArvore;
		p.empilha(this.raiz, false);
		while (!p.vazia())
		{
			nodopilha = (NodoPilhaComMarca) p.desempilha();
			nodoArvore = (NodoArvore) nodopilha.getElemento();
			if(  nodoArvore != null)
			{
				if( nodopilha.getMarca() == false)
				{
					p.empilha(nodoArvore, true);
					p.empilha(nodoArvore.getDireita(), false);
					p.empilha(nodoArvore.getEsquerda(), false);
					
				}
				else
				{
					System.out.println(nodoArvore.getInfo());
				}
			}
			
			
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
	
	public void preFixadocomChar()
	{
		preFixadocomCharR(this.raiz);
	}
	
	private void preFixadocomCharR(NodoArvore a)
	{
		if( a != null)
		{
			System.out.println((char) a.getInfo());
			preFixadocomCharR(a.getEsquerda());
			preFixadocomCharR(a.getDireita());
		}
	}
	
	public void preFixado()
	{
		preFixadoR(this.raiz);
	}
	
	private void preFixadoR(NodoArvore a)
	{
		if( a != null)
		{
			System.out.println(a.getInfo());
			preFixadoR(a.getEsquerda());
			preFixadoR(a.getDireita());
		}
	}
	public void posFixado()
	{
		posFixadoR(this.raiz);
	}
	
	private void posFixadoR(NodoArvore a)
	{
		if( a != null)
		{
			posFixadoR(a.getEsquerda());
			posFixadoR(a.getDireita());
			System.out.println(a.getInfo());
		}
	}
	public void central()
	{
		centralR(this.raiz);
	}
	
	private void centralR(NodoArvore a)
	{
		if( a != null)
		{
			centralR(a.getEsquerda());
			System.out.println(a.getInfo());			
			centralR(a.getDireita());

		}
	}	
	
	public boolean pesquisaArvore(int info)
	{
		return true;
		
	}
	
	public NodoArvore constroiArvore(String c)
	{
         return(constroiArvore(c, 0));
		
	}
	
	private NodoArvore constroiArvore(String c, int i)
	{
		char simbolo = c.charAt(i);
		
		if( simbolo == '*')
			return null;
		else{
			NodoArvore a = new NodoArvore(simbolo);

			a.setEsquerda(constroiArvore(c, i+1));

			a.setDireita(constroiArvore(c, i+2));
			return a;
		}
			
	}
	
	public int contaRepetidos(int info){
		int ret = 0;
		return contaRepetidos(this.raiz, info, ret);
	}
	
	
	private int contaRepetidos(NodoArvore raiz, int info, int ret) {
		
		if(raiz != null){
			if(raiz.getInfo() == info){
				ret++;
			}
			
			if(raiz.getInfo() <= info){
				ret = contaRepetidos(raiz.getDireita(),info, ret);
			} else {
				ret = contaRepetidos(raiz.getEsquerda(), info, ret);
			}
		}
		
		return ret;
	}

	
	public int antecessor(int info){
		int ant = 0;
		return antecessor(this.raiz,info, ant);
		
	}
	
	private int antecessor(NodoArvore raiz, int info, int ant) {
		
		if(raiz != null){
			if(raiz.getInfo() < info){
				ant = raiz.getInfo();
			}
			if(raiz.getInfo() <= info){
				ant = antecessor(raiz.getDireita(),info, ant);
			} else {
				ant = antecessor(raiz.getEsquerda(), info, ant);
			}
		}
		return ant;
	}

	public static void main(String[] args)
	{
		ArvoreBinaria a = new ArvoreBinaria();
		
		a.insereArvore(65);
		a.insereArvore(45);
		a.insereArvore(25);
		a.insereArvore(50);
		a.insereArvore(85);
		a.insereArvore(90);
		a.insereArvore(65);
		a.insereArvore(65);
		a.insereArvore(70);
		a.insereArvore(80);
		a.insereArvore(66);
		a.insereArvore(65);
		
		//a.preFixado();
		int xpto = a.antecessor(85);
		System.out.println(xpto);
  	}
}
