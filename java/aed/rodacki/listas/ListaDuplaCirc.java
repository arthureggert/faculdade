package br.com.ahe.aed.rodacki.listas;


public class ListaDuplaCirc {

	private NoListaDupla prim;
	
	public ListaDuplaCirc() {
		this.prim = null;
	}
	
	public void insere(int v){
	    NoListaDupla novo = new NoListaDupla();
	    novo.setInfo(v);
	    if(this.prim == null){
		novo.setProx(novo);
		novo.setAnt(novo);
	    } else {
		novo.setAnt(this.prim.getAnt());
		novo.setProx(this.prim);			
		this.prim.getAnt().setProx(novo);
		this.prim.setAnt(novo);
	    }
	    this.prim = novo;
	}
	
	
	public void imprime(){
	    NoListaDupla p = this.prim;
	    if(this.prim != null){
		do{
		    System.out.println("ANT: "+ p.getAnt()+" PROX: "+ p.getProx()+" INFO: "+p.getInfo());
		    p =p.getProx();
		} while(p != this.prim);
	    }
	}
	
	public void insereFim(int v) {
	    NoListaDupla novo = new NoListaDupla();
	    novo.setInfo(v);
	    
	    if (this.prim == null) {
		novo.setAnt(novo);
		novo.setProx(novo);
		this.prim = novo;
		} else {
		    novo.setProx(this.prim);
		    novo.setAnt(this.prim.getAnt());
		    this.prim.getAnt().setProx(novo);
		    this.prim.setAnt(novo);
		}
	}
	
	public void retira(int v ) {
		NoListaDupla no = busca(v);
		
		if (no!=null) {
			if (no==no.getProx()) {
				libera();
			} else {
				no.getAnt().setProx(no.getProx());
				no.getProx().setAnt(no.getAnt());
				if (no==this.prim) {
					this.prim = this.prim.getProx();
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		NoListaDupla p = this.prim;
		
		if (p!=null) {
			do {
				str += p.toString() + " ";
				p = p.getProx();
			} while (p!=this.prim);
		} else {
			str = "Lista Vazia";
		}
		return str;
	}
	
	public boolean vazia() {
		if(this.prim == null ){
			return true;
		} else {
			return false;
		}
	}
	
	public NoListaDupla busca(int v) {
		NoListaDupla p = this.prim;
		if (p != null) {
			do {
				if (p.getInfo() == v) {
					return p; 
				}
				p = p.getProx();
			} while (p != this.prim);
		}		
		return null;
	}

	public NoListaDupla buscaIndice(int i) {
		NoListaDupla novo = this.prim;
		int indice = 0;
		
		if (novo != null) {
			do {
				if (indice==i) {
					return novo;
				} else {
					i++;
				}
				novo = novo.getProx();
			} while (novo != this.prim);
		}		
		return null;
	}
	
	public void libera() {
		this.prim = null;
	}
	
	public boolean igual(ListaDuplaCirc l) {
		NoListaDupla p1 = new NoListaDupla();
		p1 = this.prim;
		NoListaDupla p2 = new NoListaDupla();
		p2 = l.prim;
		
		if (p1==null && p2==null) {
			return true;
		}
		if (p1==null || p2==null) {
			return false;
		}
		while(p1.getProx() != this.prim){
			if(p1.getInfo() != p2.getInfo()){
				return false;
			}	
			if (p1.getInfo() == p2.getInfo()) {
				p1 = p1.getProx();
				p2 = p2.getProx();
			}
		}
		return true;
		
	}

	public ListaDuplaCirc separa(int n) {
		ListaDuplaCirc l2 = new ListaDuplaCirc();
        for (NoListaDupla p = this.prim; p.getProx() != this.prim; p = p.getProx()) {
            if (p.getInfo() == n) {
                for (NoListaDupla novoNo = p.getProx(); novoNo.getProx()!= l2.prim; novoNo = novoNo.getProx()) {
                	l2.insere(novoNo.getInfo());
                }
                p.setProx(null);
                return l2;
            }
        }
        return null;
    }
	
	/** METODOS DA PROVA */
	public int lastIndexOf(int v){
		int indiceNo = 0;
		if(this.prim != null){
			for(NoListaDupla p = this.prim ; p.getProx() != this.prim; p = p.getProx()){
				if(p.getInfo() == v){
					return indiceNo;
				} else {
					indiceNo++;
				}
			}
		} 
		return -1;
	}
	
	public ListaDuplaCirc subList(int fromIndex, int toIndex){
		ListaDuplaCirc l2 = new ListaDuplaCirc();
		int auxIndice = 0;
		for(NoListaDupla p = this.prim ; p.getProx() != this.prim; p = p.getProx()){
			if(auxIndice == fromIndex){
				if(fromIndex <= toIndex){
					l2.insere(p.getInfo());
				}
				fromIndex++;
				auxIndice++;
			}
		}
		return l2;		
	}
	
	public void imprimeInvertido(){
		NoListaDupla p = this.prim.getAnt();
		String str = "";
		if(this.prim != null){
			do{
				str += p.getInfo() + " ";
				p = p.getAnt();
			} while(p != this.prim.getAnt());
			System.out.println(str);
		}
				
	}
}
