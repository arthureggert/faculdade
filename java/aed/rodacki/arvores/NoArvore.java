package br.com.ahe.aed.rodacki.arvores;

/**
 * @author Arthur Henrique Eggert
 **/

public class NoArvore {

   private int info;
   private NoArvore prim;
   private NoArvore prox;

   public NoArvore(int v){
       this.info = v;
   }

   public NoArvore(int v, NoArvore no){
       this.info = v;
       this.prox = no.prim;
       this.prim = no;
   }

    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public NoArvore getPrim() {
        return this.prim;
    }

    public void setPrim(NoArvore prim) {
        this.prim = prim;
    }

    public NoArvore getProx() {
        return this.prox;
    }
    
    public void setProx(NoArvore prox) {
        this.prox = prox;
    }

    public String toString(){
        return ""+this.info;
    }
}
