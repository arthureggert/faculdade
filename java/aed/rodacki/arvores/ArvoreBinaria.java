package br.com.ahe.aed.rodacki.arvores;



/**
 * @author Arthur Henrique Eggert
 **/

public class ArvoreBinaria {

    private NoArvoreBinaria raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }
    
    public NoArvoreBinaria insere(int v, NoArvoreBinaria esq, NoArvoreBinaria dir) {
		NoArvoreBinaria novo = new NoArvoreBinaria(v, esq, dir);
		this.raiz = novo;
		return novo;
    }

    public void insere(int info) {
        NoArvoreBinaria novo = new NoArvoreBinaria(info);
        if (vazia()) {
            this.raiz = novo;
            System.out.println("Inserindo " + info + " na raiz");
        } else {
            NoArvoreBinaria anterior = this.raiz;
            insere(anterior, info);

        }
    }
    
    public void insere(NoArvoreBinaria node, int valor) {
        if (valor < node.getInfo()) {
            if (node.getEsq() != null) {
            	insere(node.getEsq(), valor);
            } else {
                System.out.println("Inserindo " + valor + " a esquerda de " + node.getInfo());
                node.setEsq(new NoArvoreBinaria(valor));
            }
        } else {
            if (valor > node.getInfo()) {
                if (node.getDir() != null) {
                	insere(node.getDir(), valor);
                } else {
                    System.out.println("Inserindo " + valor + " a direita de " + node.getInfo());
                    node.setDir(new NoArvoreBinaria(valor));
                }
            }
        }
    }
    
    public boolean vazia() {
        return (this.raiz == null);
    }

    public boolean pertence(int info) {
        return pertence(this.raiz, info);
    }

    private boolean pertence(NoArvoreBinaria no, int info) {
        if (no == null) {
            return false;
        } else {
            return ((no.getInfo() == info) || pertence(no.getEsq(), info) || pertence(no.getDir(), info));
        }
    }

    public String toString(int v) {
        switch (v) {
            case 1:
                return imprimePos(this.raiz);
            case 2:
                return imprimeSim(this.raiz);
            default:
                return imprimePre(this.raiz);
        }
    }

    private String imprimeSim(NoArvoreBinaria no) {
        String s = new String("");
        s += "<";
        if (no != null) {
            s += imprimeSim(no.getEsq());
            s += no.getInfo();
            s += imprimeSim(no.getDir());
        }
        s += ">";

        return s;
    }

    private String imprimePre(NoArvoreBinaria no) {
        String s = new String("");
        s += "<";
        if (no != null) {
            s = s + no.getInfo();
            s = s + imprimePre(no.getEsq());
            s = s + imprimePre(no.getDir());
        }
        s += ">";

        return s;
    }

    private String imprimePos(NoArvoreBinaria no) {
        String s = new String("");
        s += "<";
        if (no != null) {
            s = s + imprimePos(no.getEsq());
            s = s + imprimePos(no.getDir());
            s = s + no.getInfo();
        }
        s += ">";

        return s;
    }

    public int pares() {
        return pares(this.raiz);
    }

    private int pares(NoArvoreBinaria no) {
        int v = 0;
        if (no != null) {
            v = v + pares(no.getEsq());
            v = v + pares(no.getDir());
            if (no.getInfo() % 2 == 0) {
                v++;
            }
        }
        return v;
    }

    public int folhas() {
        return folhas(this.raiz);
    }

    private int folhas(NoArvoreBinaria no) {
        int v = 0;
        if (no != null) {
            v = v + folhas(no.getEsq());
            v = v + folhas(no.getDir());
            if (no.getEsq() == null && no.getDir() == null) {
                v++;
            }
        }
        return v;
    }

    public boolean igual(ArvoreBinaria no) {
        int a = igual(this.raiz, no.raiz);
        if (a == 0) {
            return true;
        }
        return false;
    }

    private int igual(NoArvoreBinaria raiz, NoArvoreBinaria no) {
        int v = 0;
        if (raiz != null) {
            if (no != null) {
                if (raiz.getInfo() != no.getInfo()) {
                    return 1;
                }
                v += igual(raiz.getDir(), no.getDir());
                v += igual(raiz.getEsq(), raiz.getEsq());
            } else {
                return 1;
            }

        } else {
            if (no != null) {
                return 1;
            }
        }
        return v;
    }

    public ArvoreBinaria copia() {
        ArvoreBinaria a = new ArvoreBinaria();
        NoArvoreBinaria temp = a.raiz;
        copiaNo(temp, this.raiz);
        return a;
    }

    private void copiaNo(NoArvoreBinaria a, NoArvoreBinaria b) {

        if (b != null) {
            a = new NoArvoreBinaria(b.getInfo());
            copiaNo(a.getEsq(), b.getEsq());
            copiaNo(a.getDir(), b.getDir());
        }
    }
    
    public int maxV(){
    	return maxV(this.raiz);
    }
    
    private int maxV(NoArvoreBinaria raiz){
    	int maior = raiz.getInfo();
    	NoArvoreBinaria dir = raiz.getDir();
    	NoArvoreBinaria esq = raiz.getEsq();
    	
    	if(raiz.getDir() == null && raiz.getEsq() == null){
    		return maior;
    	}
    	
    	if(raiz.getDir() != null && raiz.getEsq() != null){
    		
    		int maxDir = maxV(dir);
        	int maxEsq = maxV(esq);
        	
        	if(maxDir > maior){
        		maior = maxDir;
        	}
        	if(maxEsq > maior){
        		maior = maxEsq;
        	}
    	} 
    	
    	if (raiz.getDir() == null){
        	int maxEsq = maxV(esq);
        	
        	if(maxEsq > maior){
        		maior = maxEsq;
        	}
    	}
    	
    	if (raiz.getEsq() == null){
        	int maxDir = maxV(dir);
        	
        	if(maxDir > maior){
        		maior = maxDir;
        	}
    	}
    	
    	return maior;
    }
}
