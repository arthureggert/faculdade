package br.com.ahe.aed.outros;

/**
 * @author Gustavo Rufino Feltrin
 */
public class ArvoreBinariaBusca {
	
	private NoArvoreBinaria raiz;
	
	public ArvoreBinariaBusca() {
		setRaiz(null);
	}
	
	public NoArvoreBinaria busca(int v){
		return busca(this.getRaiz(),v);
	}

	private NoArvoreBinaria busca(NoArvoreBinaria a, int v) {
		if (a==null) {
			return null;
		} else if (v < a.getInfo()) {
			return busca(a.getEsq(), v);
		} else if (v > a.getInfo()) {
			return busca(a.getDir(), v);
		} else {
			return a;
		}
	}
	
	public void insere(int v){
		 this.setRaiz(insere(this.getRaiz(),v));
	}

	private NoArvoreBinaria insere(NoArvoreBinaria a, int v) {
		if (a==null) {
			a = new NoArvoreBinaria(v);
			a.setEsq(null);
			a.setDir(null);
		} else if (v < a.getInfo()) {
			a.setEsq(insere(a.getEsq(), v));
		} else {
			a.setDir(insere(a.getDir(), v));
		}
		return a;
	}
	
	public void retira(int v){
		this.setRaiz(retira(this.getRaiz(),v));
	}

	private NoArvoreBinaria retira(NoArvoreBinaria a, int v) {
		if (a==null) {
			return null;
		} else if (v < a.getInfo()) {
			a.setEsq(retira(a.getEsq(), v));
		} else if (v > a.getInfo()) {
			a.setDir(retira(a.getDir(), v));
		} else if(a.getEsq()==null && a.getDir()==null) {
			a = null;
		} else if (a.getEsq()==null) {
			a = a.getDir();
		} else if (a.getDir()==null) {
			a = a.getEsq();
		} else {
			NoArvoreBinaria p = a.getEsq();
			while (p.getDir() != null) {
				p = p.getDir();
			}
			a.setInfo(p.getInfo());
			p.setInfo(v);
			a.setEsq(retira(a.getEsq(), v));
		}
		return a;
	}
	
	@Override
	public String toString() {
		return imprime(this.getRaiz());
	}
	
	private String imprime(NoArvoreBinaria no) {
		String str = "";
		if (no!=null) {
			str += imprime(no.getEsq());
			str += no.getInfo() + " ";
			str += imprime(no.getDir());
		}
		return str;
	}

	public String toStringDecrescente() {
		return imprimeDecrescente(this.getRaiz());
	}
	
	private String imprimeDecrescente(NoArvoreBinaria no) {
		String str = "";
		if (no!=null) {
			str += imprimeDecrescente(no.getDir());
			str += no.getInfo() + " ";
			str += imprimeDecrescente(no.getEsq());
		}
		return str;
	}
	
	public int somaFolhas() {
		return somaFolhas(this.getRaiz());
	}

	private int somaFolhas(NoArvoreBinaria no) {
		int somaFls = 0;
		if ((no!=null) ) {
			if ( (no.getEsq()==null && no.getDir()==null)) {
				somaFls += no.getInfo();				
			}		
			somaFls += somaFolhas(no.getEsq());
			somaFls += somaFolhas(no.getDir());
		}
		return somaFls;
	}
	
	public int maioresX(int x) {
		return maioresX(this.getRaiz(), x);
	}

	private int maioresX(NoArvoreBinaria no, int x) {
		int maiores = 0;
		if (no!=null) {
			if (no.getInfo() > x) {
				maiores++;
			}
			maiores += maioresX(no.getDir(), x);
			maiores += maioresX(no.getEsq(), x);
		}
		return maiores;
	}

	public NoArvoreBinaria getRaiz() {
		return this.raiz;
	}

	public void setRaiz(NoArvoreBinaria raiz) {
		this.raiz = raiz;
	}
	
}
