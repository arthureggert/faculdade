package br.com.ahe.aed.tavares.lista;

public class ListaEncadeadaDuplamente{
	
    private NodoListaDupla inicio;
    
    public ListaEncadeadaDuplamente()    {
        this.inicio = null;
    }
    
    public void instalaNodoDireita(NodoListaDupla nodo, NodoListaDupla p) {
        nodo.setAnterior(p);
        NodoListaDupla q = p.getSucessor();
        nodo.setSucessor(q);
        if( q != null ){
        	q.setAnterior(nodo);        	
        }
        p.setSucessor(nodo);
    }
    
    public void desinstalaNododoMeio(NodoListaDupla nodo){
        NodoListaDupla p = nodo.getAnterior();
        NodoListaDupla q = nodo.getSucessor();
        p.setSucessor(q);
        q.setAnterior(p);
    }
    
    public void inverteNodos(NodoListaDupla p, NodoListaDupla q){
        NodoListaDupla p1 = p.getAnterior();
        NodoListaDupla p2 = p.getSucessor();
        NodoListaDupla q1 = q.getAnterior();
        NodoListaDupla q2 = q.getSucessor();
        
        p1.setSucessor(q);
        q.setAnterior(p1);
        q.setSucessor(p2);
        p2.setAnterior(q);
        p.setAnterior(q1);
        q1.setSucessor(p);
        q2.setAnterior(p);
        p.setSucessor(q2);
    }
    
    public boolean insereListaDupla(Integer info){
        if( this.inicio == null) {        
           this.inicio = new NodoListaDupla(info);
           return true; 
        }  else {
           NodoListaDupla p = this.inicio;
           if( ((Integer)p.getInfo()).intValue() > info.intValue()) {
              NodoListaDupla nodo = new NodoListaDupla(info);
              nodo.setSucessor(this.inicio);
              this.inicio.setAnterior(nodo);
              this.inicio = nodo;
              return true; 
           } else {
              while ((p.getSucessor() != null) && ( ((Integer)p.getInfo()).intValue() < info.intValue())) {
                 p = p.getSucessor();
              if( ((Integer)p.getInfo()).intValue() == info.intValue()) {
                 return false;
              } else {
                 if( ((Integer)p.getInfo()).intValue() > info.intValue() ){
                    p = p.getAnterior();
                 }
                 NodoListaDupla nodo = new NodoListaDupla(info);
                 instalaNodoDireita(nodo, p);
                 return true;
              }
           }
         }
      }
		return false;
    }
     
    public NodoListaDupla pesquisaListaDupla(Integer info)
    {
        NodoListaDupla p = this.inicio;
        
        while (p != null){
            if(((Integer) p.getInfo()).intValue() == info.intValue()){
                return p;
            } else {
                p = p.getSucessor();
            }
        }
        return null;
    }
     public void imprimeListaDupla() {
        NodoListaDupla p = this.inicio;
        while ( p != null ) {
           System.out.println(" " + ((Integer)p.getInfo()).intValue());
           p = p.getSucessor();
        }
     } 
     
}   
    
        
    