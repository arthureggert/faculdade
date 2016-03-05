package br.com.ahe.aed.rodacki.listas;


public class Lista {
	
	private NoLista prim;

	public NoLista getPrim() {
		return this.prim;
	}

	public void setPrim(NoLista prim) {
		this.prim = prim;
	} 
	
	public Lista(){}
	
	public void insere(int info){
		NoLista v = new NoLista();
		v.setInfo(info);
		v.setProx(this.prim);
		this.setPrim(v);
	}
	
	public void imprime(){
		NoLista p = this.prim; 
		while (p != null) {
			System.out.println(p.getInfo()+" ");
			p = p.getProx();
		}
	}
	
	public NoLista maximo(){
		NoLista p = new NoLista();
		p = this.prim;
		NoLista maiorNo = new NoLista();
		maiorNo = this.prim;
		
		if (maiorNo == null){
			return null;
		}
		
		while(p!= null){
			if (p.getInfo() > maiorNo.getInfo() ){
				maiorNo = p;
				p = p.getProx();
			} else {
				p = p.getProx();
			}
		}
		return maiorNo;
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
		NoLista p = this.prim;
		while(p != null){
			p = p.getProx();
			auxCont++;
		}
		return auxCont;
	}
	
	public NoLista busca(int v){
		NoLista p = this.prim;
		while (p != null){
			if (p.getInfo() == v){
				System.out.println(p);
				return p;
			} else {
				p = p.getProx();
			}
		}
		return null;
	}
		
	public void retira(int v){
		NoLista ant = null;
		NoLista p = this.prim;
		while (p != null && p.getInfo() != v ){
			ant = p;
			p = p.getProx();
		}
		try {
			if (ant == null){
				this.prim = p.getProx();		
			} else {
				ant.setProx(p.getProx());
			}			
		} catch (NullPointerException NFE) {
			System.out.println("Elemento n�o encontrado");
		}
	}
	
	public void libera(){
		setPrim(null);
	}
	
	public void insereOrdenado(int v){
		NoLista ant = null;
		NoLista p = this.prim;
		NoLista novo = new NoLista();
		novo.setInfo(v);

		while (p != null && p.getInfo() > v ){
			ant = p;
			p = p.getProx();
		}			
		if (ant == null){
			novo.setProx(this.prim);
			this.prim = novo;
		} else {
			novo.setProx(ant.getProx());
			ant.setProx(novo);
		}
	}
	
	@Override
	public String toString() {
		return "Lista:"+this;
	}
	
	public boolean igual(Lista l){
		if (this == l){
			return true;
		}
		if (l == null){
			return false;
		}
		if (getClass() != l.getClass()){
			return false;
		}		
		Lista outra = l;
		if (this.prim == null) {
			if (outra.prim != null){
				return false;
			}		
		} else if (!this.prim.equals(outra.prim)){
			return false;
		}
		return true;
	}
	
	public void imprimeRecursivo(){
		imprimeRecursivoAux(this.prim);
	}

	private void imprimeRecursivoAux(NoLista l) {
		if(l != null){
			System.out.println(l.getInfo());
			imprimeRecursivoAux(l.getProx());
		}
	}
	
	public void retiraRecursivo(int v){
		this.prim = retiraRecursivoAux(this.prim,v);
	}

	private NoLista retiraRecursivoAux(NoLista l, int v) {
		if(l != null){
			if(l.getInfo() == v){
				l = l.getProx();
			} else {
				l = l.getProx();
				retiraRecursivoAux(l,v);
			}
		} else {
			return null;
		}
		return l;
	}
	
	public NoLista maximRecursivo(){
		return maximoRecursivoAux(this.prim);
	}
	
	private NoLista maximoRecursivoAux(NoLista l){
		NoLista maiorNo = l;
		
		
		if(l.getProx() != null){
			if(l.getInfo() > maiorNo.getInfo() ){
				maiorNo = l;
			}
			maximoRecursivoAux(l.getProx());
		}		
		
		return l;
		
	}
	
	public boolean igualRecursivo(Lista l){
		return igualRecursivoAux(this.prim, l.prim);
	}

	private boolean igualRecursivoAux(NoLista l1, NoLista l2) {
		if(l1 == null && l2 == null){
			return true;
		} else {
			if(l1 == null || l2 == null){
				return false;
			} else {
				return (l1.getInfo() == l2.getInfo()) && igualRecursivoAux(l1.getProx(), l2.getProx());
			}
		}
	}


	
}
