package br.com.ahe.aed.tavares.lista;

public class ListaEncadeada {
	
	private NodoLista inicio;

	public ListaEncadeada(){
		this.setInicio(null);
	}
	
	public NodoLista getInicio() {
		return this.inicio;
	}

	public void setInicio(NodoLista inicio) {
		this.inicio = inicio;
	}
	
	public void insere(int info){
		NodoLista tmp = new NodoLista(info);
		tmp.setProximo(this.getInicio());
		this.setInicio(tmp);
	}
	
	public boolean insereOrdenado(int info){
		NodoLista tmp = new NodoLista(info);	
		if(isVazia() || this.getInicio().getInfo() > info){
			tmp.setProximo(this.getInicio());
			this.setInicio(tmp);
			return true;
		}
		NodoLista ant = null;
		NodoLista p = this.getInicio();
		while(p != null){
			if(p.getInfo() > info){
				tmp.setProximo(p);
				ant.setProximo(tmp);
				return true;
			} else {
				ant = p;
				p = p.getProximo();		
			}
		}
		ant.setProximo(tmp);
		return true;
	}
	
	private boolean isVazia() {
		if(this.getInicio() == null){
			return true;
		} else {
			return false;	
		}
		
	}

	public boolean pesquisa(int info){
		NodoLista tmp = this.getInicio();
		
		while (tmp != null){
			if(tmp.getInfo() == info){
				return true;
			} else {
				tmp = tmp.getProximo();
			}
		}
		return false;
	}
	
	public NodoLista pesquisaNodo(int indice) throws Exception{
		NodoLista tmp = this.getInicio();
		int indiceAux  = 0;
		
		while (tmp != null){
			if(indice == indiceAux){
				return tmp;
			} else {
				indiceAux++;
				tmp = tmp.getProximo();
			}
		}
		throw new Exception("Erro: Lista esta Vazia");
	}
	
	
	public void imprime(){
		System.out.println(this.toString());
	}
	
	public NodoLista retiraInicio() throws Exception{
		if (this.getInicio() == null){
			throw new Exception("ERRO: Fila esta Vazia");
		} else {
			NodoLista tmp = this.getInicio();
			this.setInicio(tmp.getProximo());
			return tmp;
		}
	}
	public boolean retiraUltimo(){
		NodoLista ant = null;
		NodoLista p = this.getInicio();
		
		if(this.getInicio() == null){
			return false;
		} else if (p.getProximo() == null){
			this.setInicio(null);
			return true;
		} else {
			while (p != null ){
				ant = p;
				p = p.getProximo();
			}	
			ant.setProximo(null);
			return true;
		}
	}
	
	public void retira(int v){
		NodoLista ant = null;
		NodoLista p = this.getInicio();
		while (p != null && p.getInfo() != v ){
			ant = p;
			p = p.getProximo();
		}
		try {
			if (ant == null){
				this.setInicio(p.getProximo());
			} else {
				ant.setProximo(p.getProximo());
			}			
		} catch (NullPointerException NPE) {
			System.out.println("Elemento não encontrado");
		}
	}

	@Override
	public String toString() {
		NodoLista p = this.getInicio();; 
		StringBuilder tmp = new StringBuilder("LISTA: Inicio -> ");
		while (p != null) {
			tmp.append(p.getInfo() + " -> ");
			p = p.getProximo();
		}
		tmp.append("Fim");
		return tmp.toString();
	}
	
	public void ordenaLista(){
		NodoLista p = this.getInicio();
		NodoLista ant = null;
		
		while(p != null){
			NodoLista tmp = p.getProximo();
			while(tmp != null){
				if(p.getInfo() > tmp.getInfo()){				
					p.setProximo(tmp.getProximo());
					tmp.setProximo(p);
					
					if(this.getInicio().equals(p)){
						this.setInicio(tmp);
					} else {
						ant.setProximo(tmp);
					}
					ant = tmp;
				}
				tmp = tmp.getProximo();
				
			}
			ant = p;
			p = p.getProximo();
		}
	}
	
	public int getTamanho(){
		NodoLista tmp = this.getInicio();
		int tamanho = 0;
		while (tmp != null){
			tamanho++;
			tmp = tmp.getProximo();
		}
		return tamanho;
	}
	
	public NodoLista getUltimo(){
		NodoLista tmp = this.getInicio();
		while (tmp != null){
			if(tmp.getProximo() == null){
				return tmp;	
			} else {
				tmp = tmp.getProximo();
			}
		}
		return null;
	}
	
	
	public boolean comparaListas(ListaEncadeada l2){
		NodoLista tmp = this.getInicio().getProximo();
		NodoLista tmp2 = l2.getInicio().getProximo();
		
		if(!this.getInicio().equals(l2.getInicio()) || this.getTamanho() != l2.getTamanho()){
			return false;
		} else {
			while (tmp != null){
				if(tmp.equals(tmp2)){
					tmp = tmp.getProximo();
					tmp2 = tmp2.getProximo();	
				} else {
					return false;
				}
			}
			return true;
		}
	}
	
	public ListaEncadeada concatenaListas(ListaEncadeada l2){
		ListaEncadeada l3 = new ListaEncadeada();
		NodoLista tmp = this.getInicio();
		NodoLista tmp2 = l2.getInicio();
		
		while(l3.getTamanho() != this.getTamanho() + l2.getTamanho()){
			if(tmp == null){
				l3.insere(tmp2.getInfo());
				tmp2 = tmp2.getProximo();
			} else if(tmp2 == null){
				l3.insere(tmp.getInfo());
				tmp = tmp.getProximo();
			} else {
				l3.insere(tmp.getInfo());
				l3.insere(tmp2.getInfo());
				tmp = tmp.getProximo();
				tmp2 = tmp2.getProximo();
			}
		}
		l3.ordenaLista();
		return l3;
	}
	
	private void liberaLista(){
		this.setInicio(null);
	}
	
	public void inverteLista() throws Exception{
		NodoLista tmp = this.getInicio();
		int tamanho = this.getTamanho();
		int[] ltmp = new int[tamanho];
		
		for (int i = 0; i < ltmp.length; i++) {
			ltmp[i] = tmp.getInfo();
			tmp = tmp.getProximo();
		}
		
		this.liberaLista();

		for (int i = 0; i < ltmp.length; i++) {
			this.insere(ltmp[i]);
		}
	}
	
	public ListaEncadeada geraLista(ListaContigua lc){
		ListaEncadeada tmp = new ListaEncadeada();
		for (int i = 0; i < lc.getTamanho(); i++){
			tmp.insere(lc.pesquisaIndice(i));
		}
		return tmp;
	}
	
	public boolean igualRecursivo(ListaEncadeada l){
		return igualRecursivoAux(this.getInicio(), l.getInicio());
	}

	private boolean igualRecursivoAux(NodoLista l1, NodoLista l2) {
		if(l1 == null && l2 == null){
			return true;
		} else {
			if(l1 == null || l2 == null){
				return false;
			} else {
				return (l1.getInfo() == l2.getInfo()) && igualRecursivoAux(l1.getProximo(), l2.getProximo());
			}
		}
	}

		/**RECURSIVIDADE**/
	
	public void imprimeLista2(){ 
		System.out.println("\n " + imprimeListaR(this.inicio)); 
	} 

	private String imprimeListaR(NodoLista n)	{ 
		if( n != null){ 
			return(n.getInfo() + " "+ imprimeListaR(n.getProximo())); 
		} else {
			return ""; 			
		}
	} 


	public NodoLista pesquisaLista2(int info) { 
		return pesquisaListaR(this.inicio, info); 
	} 

	private NodoLista pesquisaListaR(NodoLista n, int info) { 
		if (n != null) { 
			if (n.getInfo() == info){
				return n; 				
			} else { 
				return( pesquisaListaR(n.getProximo(), info)); 
			} 
		} 
		return null; 
	}
}
