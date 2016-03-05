package br.com.ahe.aed.provas.prova1;

public class ListaEncadeada
{
     NodoLista inicio;
         
     public ListaEncadeada()
     {
         this.inicio = null;
     }
     
     public NodoLista getInicio()
     {
        return this.inicio;
     }
     
     public void insereLista(int info) // insere no inicio da lista
     {
    	 NodoLista nodo = new NodoLista(info);
    	 nodo.setProximo(this.inicio);
    	 this.inicio = nodo;
     }
    
 	public boolean listaVazia() {
 		if( this.inicio == null)
 			return true;
 		else
 			return false;
 	}

 	public void insereOrdem(int info)
    {
 		if( this.inicio == null) {
            this.inicio = new NodoLista(info);
            return;
         } else {
             NodoLista p, p_ant;
             p = this.inicio;
             p_ant = this.inicio;
             while( p.getInfo() < info ) {
                if( p.getProximo() != null ) {
                   p_ant = p;
                   p = p.getProximo(); }
                else {
                   NodoLista nodo = new NodoLista(info);
                   p.setProximo(nodo);
                   return; }
             }
             NodoLista nodo = new NodoLista(info);
             nodo.setProximo(p);
             if( this.inicio == p) {
                this.inicio = nodo; }
             else 
                p_ant.setProximo(nodo);
             return;
          }
      }

	public String imprime(){
		NodoLista p = this.inicio;
		String s = new String();
		s = "";
		while (p != null){
			s = s + p.getInfo() + " ";
			p = p.getProximo();
		}
		return s;
	}
	
	public ListaEncadeada divideLista(){
		ListaEncadeada listaNova = new ListaEncadeada();
	
		if(listaVazia() || this.getInicio().getProximo() == null){
			return new ListaEncadeada();
		} else {
			NodoLista tmp = this.getInicio();
			NodoLista tmp2 = this.getInicio().getProximo();
			
			while(tmp != null){
				if(tmp2 != null){
					listaNova.insereLista(tmp2.getInfo());
					tmp.setProximo(tmp2.getProximo());
					tmp = tmp.getProximo();
					if(tmp2.getProximo() != null){
						tmp2 = tmp2.getProximo().getProximo();					
					}
				} else {
					tmp = tmp.getProximo();
				}
			}
		}
		return listaNova;
			
	}

	public void insereI_esima(int i, int info){
		int indice = 1;
		NodoLista tmp = this.getInicio();
		
		if(i == 0){
			this.insereLista(info);
		} else if(i > this.getTamanho()){
			while(tmp != null){
				if(tmp.getProximo() == null){
					NodoLista novo = new NodoLista(info);
					tmp.setProximo(novo);
					novo.setProximo(null);
				}
				tmp = tmp.getProximo();
			}
			tmp = this.getInicio();
		} else {
			while(tmp != null){
				if(i == indice){
					NodoLista p = new NodoLista(info);
					p.setProximo(tmp.getProximo());
					tmp.setProximo(p);
					return;
				} else {
					tmp = tmp.getProximo();
					indice++;
				}
				
			}
		}
	}
	
	
	public int contaElementosDiferentes(){
		int dif = 0;
		
		if(this.getInicio() != null){
			NodoLista tmp = this.getInicio();
			NodoLista tmp2 = this.getInicio().getProximo();
			dif++;
			while(tmp2 != null){
				if(tmp.getInfo() != tmp2.getInfo()){
					dif++;
					tmp = tmp.getProximo();
					tmp2 = tmp2.getProximo();
				} else {
					tmp = tmp.getProximo();
					tmp2 = tmp2.getProximo();
				}
			}
		}
		return dif;			
		
	}
	public int getTamanho() {
		NodoLista p = this.inicio;
		int tam = 0;
		while(p != null){
			tam++;
			p = p.getProximo();
		}
		return tam;
	}
}
