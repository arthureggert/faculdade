package br.com.ahe.aed.outros;



public class Arvore {

	private NoArvore raiz;

	public Arvore() {
		this.raiz = null;
	}

	public NoArvore criaNo(int info) {
		NoArvore no = new NoArvore(info);
		this.raiz = no;
		return no;
	}

	public void insereFilho(NoArvore no, NoArvore sa) {
		sa.setProx(no.getPrim());
		no.setPrim(sa);
		this.raiz = no;
	}

	@Override
	public String toString() {
		return imprime(this.raiz);
	}

	private String imprime(NoArvore no) {
		String str = "";
		str += "<";
		str += no.getInfo();
		NoArvore p = no.getPrim();
		while (p != null) {
			str += imprime(p);
			p = p.getProx();
		}
		str += ">";
		return str;
	}

	public boolean pertence(int v) {
		return pertence(this.raiz, v);
	}

	private boolean pertence(NoArvore no, int v) {
		if (no.getInfo() == v) {
			return true;
		}
		NoArvore p = no.getPrim();
		while (p != null) {
			if (pertence(p, v)) {
				return true;
			}
			p = p.getProx();
		}
		return false;
	}

	public int altura() {
		return altura(this.raiz);
	}

	private int altura(NoArvore no) {
		int hMax = -1;
		NoArvore p = no.getPrim();
		if (p == null) {
			return 1;
		}
		while (p != null) {
			int h = altura(p);
			if (h > hMax) {
				hMax = h;
			}
			p = p.getProx();
		}
		return hMax + 1;
	}

	public int maximo() {
		return maximo(this.raiz);
	}

	private int maximo(NoArvore no) {
		int maior = no.getInfo();

		NoArvore p = no.getPrim();
		while (p != null) {
			int x = maximo(p);
			if (x > maior) {
				maior = x;
			}
			p = p.getProx();
		}
		return maior;
	}

	public int pares() {
		return pares(this.raiz);
	}

	private int pares(NoArvore no) {
		int nPares = 0;
		if (no.getInfo() % 2 == 0) {
			nPares++;
		}
		NoArvore p = no.getPrim();
		while (p != null) {
			nPares += pares(p);
			p = p.getProx();
		}
		return nPares;
	}

	public int folhas() {
		return folhas(this.raiz);
	}

	private int folhas(NoArvore no) {
		int nFls = 0;
		if (no == null) {
			return 1;
		}
		NoArvore p = no.getPrim();
		while (p != null) {
			nFls += pares(p);
			p = p.getProx();
		}
		return nFls;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.raiz == null) ? 0 : this.raiz.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arvore other = (Arvore) obj;
		if (this.raiz == null) {
			if (other.raiz != null)
				return false;
		} else if (!this.raiz.equals(other.raiz))
			return false;
		return true;
	}

	public boolean igual(Arvore a) {
		return igual(this.raiz, a.raiz);
	}

	private boolean igual(NoArvore noInterno, NoArvore noExterno) {
		if (!noInterno.equals(noExterno)) {
			return false;
		}
		NoArvore pInt = noInterno.getPrim();
		NoArvore pExt = noExterno.getPrim();
		while (pInt != null && pExt != null) {
			if (igual(pInt, pExt)) {
				pInt = pInt.getProx();
				pExt = pExt.getProx();
			} else {
				return false;
			}
		}
		if (pInt != null || pExt != null) {
			return false;
		}
		return true;
	}

	public Arvore copia() {
		Arvore novaArvore = new Arvore();
		novaArvore.raiz = copia(this.raiz, novaArvore);
		return novaArvore;
	}

	private NoArvore copia(NoArvore no, Arvore a) {
		NoArvore novo = a.criaNo(no.getInfo());
		NoArvore p = no.getPrim();
		while (p != null) {
			a.insereFilhoFim(novo, copia(p, a));
			p = p.getProx();
		}
		return novo;
	}
	
	private void insereFilhoFim(NoArvore pai,NoArvore filho){				
		this.raiz = pai;		
		if(pai.getPrim() != null){		
			NoArvore p = pai.getPrim();
			while(p.getProx() != null){
				p = p.getProx();
			}
			p.setProx(filho);			
		}else{
			filho.setProx( pai.getPrim() );
			pai.setPrim(filho);
		}		
	}

	public String minV() {
		return null;
	}

}
