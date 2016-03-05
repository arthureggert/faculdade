package br.com.ahe.aed.rodacki.arvores;

/**
 * @author Arthur Henrique Eggert
 **/

public class NoArvoreBinaria {

    private int info;
    private NoArvoreBinaria dir;
    private NoArvoreBinaria esq;

    public NoArvoreBinaria(int info){
	this.info = info;
	this.esq = null;
	this.dir = null;
    }

    public NoArvoreBinaria(int info, NoArvoreBinaria esq, NoArvoreBinaria dir){
	this.info = info;
        this.esq = esq;
        this.dir = dir;
    }

    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public NoArvoreBinaria getDir() {
        return this.dir;
    }

   public void setDir(NoArvoreBinaria dir) {
        this.dir = dir;
    }

    public NoArvoreBinaria getEsq() {
        return this.esq;
    }

    public void setEsq(NoArvoreBinaria esq) {
        this.esq = esq;
    }    
}
