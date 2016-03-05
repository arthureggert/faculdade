package br.com.ahe.aed.outros;


public class ArvoreBinaria {
	
	private NoArvoreBinaria raiz;
	
	public ArvoreBinaria() {
		this.raiz = null;
	}
	
	public NoArvoreBinaria insere(int v ) {
		return insere(v, null, null);
	}
	
	public NoArvoreBinaria insere(int v, NoArvoreBinaria esq, NoArvoreBinaria dir ) {
		NoArvoreBinaria no = new NoArvoreBinaria(v, esq, dir);
		this.raiz = no;
		return no;
	}
	
	public boolean vazia() {
		return this.raiz==null;
	}
	
	@Override
	public String toString() {
		return imprimePre(this.raiz);
	}
	
	private String imprimePre(NoArvoreBinaria no) {
		String str = new String();
		str += "<";
		if (no!=null) {
			str += no.getInfo();
			str += imprimePre(no.getEsq());
			str += imprimePre(no.getDir());
		}
		
		str += ">";
		return str;
	}
	
	public boolean pertence(int info) {
		return pertence(this.raiz, info);
	}

	private boolean pertence(NoArvoreBinaria no, int info) {
		if (no==null) {
			return false;
		} else {
			return ((no.getInfo()==info) || pertence(no.getEsq(), info) || pertence(no.getDir(), info));
		}
	}
		
	public int pares(){
		return pares(this.raiz);
	}

	private int pares(NoArvoreBinaria no) {
		int nPares = 0;
		if (no!=null && no.getInfo()%2==0) {
			nPares++;
		}
		if (no!=null) {
			nPares += pares(no.getEsq());
			nPares += pares(no.getDir());
		}	
		return nPares;
	}
	
	public int folhas() {
		return folhas(this.raiz);
	}

	private int folhas(NoArvoreBinaria no) {
		int nFls = 0;
		if ((no!=null) ) {
			if ( (no!=this.raiz) &&  (no.getEsq()==null && no.getDir()==null)) {
				nFls++;				
			}		
			nFls += folhas(no.getEsq());
			nFls += folhas(no.getDir());
		}
		return nFls;
	}
	
	public boolean igual(ArvoreBinaria ab) {
		return igual(this.raiz,ab.raiz);
	}

	private boolean igual(NoArvoreBinaria interno,NoArvoreBinaria externo){
		if(interno==null && externo==null){
			return true;
		}
		if(interno==null || externo==null){
			return false;
		}
		if(interno.getInfo()!=externo.getInfo()){
			return false;
		}
		return (igual(interno.getEsq(), externo.getEsq()) && (igual(interno.getDir(), externo.getDir())));
	}
	
	public NoArvoreBinaria copia(NoArvoreBinaria a){
		if(a==null){
			return null;
		}
		return new NoArvoreBinaria(a.getInfo(), copia(a.getEsq()), copia(a.getDir()));		
	}
	
	public ArvoreBinaria copia(){
		ArvoreBinaria ab = new ArvoreBinaria();		
		ab.raiz = copia(this.raiz);		
		return ab;
	}

	public char[] somaInfoFolhas() {
		return null;
	}
	
}
