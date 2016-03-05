package br.com.ahe.aed.rodacki.arvores;

public class NoArvoreBusca {

	private int info;
	private NoArvoreBusca esq;
	private NoArvoreBusca dir;
	
	public NoArvoreBusca(int info){
		this.setInfo(info);
	}
	
	public NoArvoreBusca(int info, NoArvoreBusca esq, NoArvoreBusca dir){
		this.setInfo(info);
		this.setEsq(esq);
		this.setDir(dir);
	}
	

	public NoArvoreBusca() {
	}

	public int getInfo() {
		return this.info;
	}

	public NoArvoreBusca getEsq() {
		return this.esq;
	}

	public NoArvoreBusca getDir() {
		return this.dir;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public void setEsq(NoArvoreBusca esq) {
		this.esq = esq;
	}

	public void setDir(NoArvoreBusca dir) {
		this.dir = dir;
	}


	@Override
	public String toString() {
		return "[RAIZ = " + this.info +"\nSAE = " + this.esq + "\nSAD = " + this.dir + "]";
	}

	public String toString2() {
		return ""+this.info;
	}
	

	
	
}
