package br.com.ahe.aed.rodacki.filas;

/**
 * @author Arthur Henrique Eggert
 **/
public class NoFila {

    private int info;
    private NoFila prox;

    public NoFila(){
    }
    
    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public NoFila getProx() {
        return this.prox;
    }

    public void setProx(NoFila prox) {
        this.prox = prox;
    }

	@Override
	public String toString() {
		return "NoLista [info=" + this.info + ", prox=" + this.prox + "]";
	}
}
