package br.com.ahe.aed.rodacki.arvores;


/**
 * @author Arthur Henrique Eggert
 **/

public class Arvore {

    private NoArvore raiz;

    public NoArvore criaNo(int info) {
        NoArvore novo = new NoArvore(info);
        this.raiz = novo;
        return novo;
    }

    public void insereFilho(NoArvore pai, NoArvore filho) {
        filho.setProx(pai.getPrim());
        pai.setPrim(filho);
        this.raiz = pai;
    }

    public String toString() {
        return imprime(this.raiz);
    }

    private String imprime(NoArvore no) {
        String s = new String("");
        s = s + "<";
        s = s + no.getInfo();
        NoArvore p = no.getPrim();

        while (p != null) {
            s = s + imprime(p);
            p = p.getProx();
        }
        s = s + ">";
        return s;
    }

    public boolean pertence(int v) {
        return pertence(this.raiz, v);
    }

    private boolean pertence(NoArvore no, int v) {
        if (no.getInfo() == v) {
            return true;
        } else {
            NoArvore p = no.getPrim();
            while (p != null) {
                if (pertence(p, v)) {
                    return true;
                }
                p = p.getProx();
            }
        }
        return false;
    }

    public int altura() {
        return altura(this.raiz);
    }

    private int altura(NoArvore no) {
        int hmax = -1;
        NoArvore p = no.getPrim();
        while (p != null) {
            int h = altura(p);
            if (h > hmax) {
                hmax = h;
            }
            p = p.getProx();
        }
        return hmax + 1;
    }


    public int pares() {
        return pares(this.raiz);
    }

    private int pares(NoArvore no) {
        
	int v = 0;
        if(no.getInfo() % 2 == 0){
            v++;
        }
        
        NoArvore p = no.getPrim();
        
        while (p != null) {
           v += pares(p);
           p = p.getProx();
        }
        
        return v;
    }

     public int folhas() {
        return folhas(this.raiz);
    }

    private int folhas(NoArvore no) {
        
	int v = 0;
        if(no.getPrim() == null && no.getProx() == null) {
            v++;
        }
        NoArvore p = no.getPrim();
        while (p != null) {
           v += folhas(p);   
           p = p.getProx();
        }
        return v;
    }

    public boolean igual(Arvore a){
        if(a.raiz.equals(this.raiz)){
            return true;
        }
        return false;
    }

    public int maiorSomaCaminho() {
        return maiorSomaCaminho(this.raiz);
    }

    private int maiorSomaCaminho(NoArvore no) {
        int v=0;
        v+=no.getInfo();
        NoArvore p = no.getPrim();
        while (p != null) {
            v+= maiorSomaCaminho(p);
            p = p.getProx();
        }
        return v;
    }
    
    public int somaInfoInternos() {
        return somaInfoInternos(this.raiz);
    }

    private int somaInfoInternos(NoArvore no) {
        int v = 0;
        if(no.getProx() !=null){
            v += no.getInfo();
        }
        NoArvore p = no.getPrim();
        while (p != null) {
           v+=somaInfoInternos(p);
            p = p.getProx();
        }
        return v;
    }
      

}
