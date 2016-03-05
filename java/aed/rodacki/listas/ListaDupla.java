package br.com.ahe.aed.rodacki.listas;


public class ListaDupla {

	private NoListaDupla prim;

	public ListaDupla() {}
	
	public void insere(int v){
		NoListaDupla novo = new NoListaDupla();
		novo.setInfo(v);
		novo.setProx(this.prim);
		novo.setAnt(null);
		if(this.prim != null){
			this.prim.setAnt(novo);
		}
			this.prim = novo;
	}
	
	public void insereOrdenado(int v) {
			NoListaDupla ant = null;
			//NoListaDupla prox = null;
			NoListaDupla novo;
			NoListaDupla p = this.prim;
			// procura posicao correta, guardando anterior
			
			while (p != null && p.getInfo() < v) {
				ant = p;
				p = p.getProx();
			}
			
			novo = new NoListaDupla();
			novo.setInfo(v);
			
			if (ant==null){
				novo.setProx(this.prim);
				this.prim = novo;
			} else {
				novo.setProx(ant.getProx());
				ant.setProx(novo);
			}
		}
	
	public void imprime(){
		NoListaDupla p = this.prim;
		while (p != null) {
			System.out.print(p.getInfo()+" ");
			p = p.getProx();
		}
	}
	
	@Override
	public String toString() {
		return "ListaDupla [prim=" + this.prim.getInfo() + "]";
	}
	
	public boolean vazia(){
		if (this.prim == null){
			return true;
		} else {
			return false;
		}
	}
	
	public int comprimento(){
		int auxCont = 0;
		NoListaDupla p = this.prim;
		while(p != null){
			p = p.getProx();
			auxCont++;
		}
		return auxCont;
	}
	
	public NoListaDupla busca(int v){
		NoListaDupla p = this.prim;
		while (p != null) {
			if (p.getInfo() == v){
				return p;
			} else {
				p = p.getProx();
			}
		}
		return null;
	}
	
	public boolean buscaBolean(int v){
		NoListaDupla p = this.prim;
		while (p != null) {
			if (p.getInfo() == v){
				return true;
			} else {
				p = p.getProx();
			}
		}
		return false;
	}
	
	public NoListaDupla buscaIndice(int v){
		int auxCont = 0;
		NoListaDupla p = this.prim;
		while (p != null){
			if (auxCont == v){
				return p;
			} else {
				auxCont++;
				p = p.getProx();
			}
		}
		return null;
	}
	
	public void retira(int v){		
		NoListaDupla p = this.prim;
		while (p != null && p.getInfo() != v ){
			p = p.getProx();
		}
		if (p.getAnt() == null){
			this.prim = p.getProx();
		} else if (p.getProx() == null){
			p.getAnt().setProx(null);
		} else {
			p.getAnt().setProx(p.getProx());
			p.getProx().setAnt(p.getAnt());
		}
	}
	
	public void libera(){
		this.prim = null;
	}
	
	public boolean igual(ListaDupla l){
		NoListaDupla p1 = this.prim;
		NoListaDupla p2 = l.prim;
		
		if(p1 == null && p2 != null){
			return false;
		}
		
		if(p1 != null && p2 == null){
			return false;
		}
		
		if (p1 == null && p2 == null){
			return true;
		}
		
		if(p1.getInfo() != p2.getInfo()){
			return false;
		}
		
		while (p1 != null && p2 != null){
			if (p1.getInfo() == p2.getInfo()){
				p1 = p1.getProx();
				p2 = p2.getProx();
			} else {
				return false;
			}
		}
		return true;
	}

	public ListaDupla inverte(){
		ListaDupla l2 = new ListaDupla();
		NoListaDupla p1 =  this.prim;
		while (this.comprimento() != l2.comprimento()){
			l2.insere(p1.getInfo());
			p1 = p1.getProx();
		}
		return l2;
	}
	
	public ListaDupla merge(ListaDupla l2){
		NoListaDupla p1 = this.prim;
		NoListaDupla p2 = l2.prim;
		ListaDupla l3 = new ListaDupla();
		while (l3.comprimento() != l2.comprimento() + this.comprimento()){
			if(p1 == null){
				l3.insere(p2.getInfo());
				p2 = p2.getProx();	
			} else if(p2 == null){
				l3.insere(p1.getInfo());	
				p1 = p1.getProx();
			} else {
				l3.insere(p1.getInfo());
				l3.insere(p2.getInfo());
				p1 = p1.getProx();
				p2 = p2.getProx();	
			}
		}
		l3.inverte();
		return l3;
	}
	
	public ListaDupla separa(int n) {
        ListaDupla l2 = new ListaDupla();
        for (NoListaDupla p = this.prim; p!=null; p = p.getProx()) {
            if (p.getInfo() == n) {
                for (NoListaDupla novoNo = p.getProx(); novoNo!=null; novoNo = novoNo.getProx()) {
                	l2.insere(novoNo.getInfo());
                }
                p.setProx(null);
                return l2;
            }
        }
        return null;
    }
}
