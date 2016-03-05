package br.com.ahe.aed.rodacki.arvores;



public class ArvoreBinariaBusca {

	private NoArvoreBusca raiz;
	
	public ArvoreBinariaBusca(){
		this.raiz = null;
	}
	
	public NoArvoreBusca busca(int info){
		return busca(this.raiz, info);
	}

	private NoArvoreBusca busca(NoArvoreBusca noRaiz, int info) {
        if (noRaiz == null) {
            return null;
        } else {
        	if (info < noRaiz.getInfo()) {
        		return busca(noRaiz.getEsq(), info);
        	} else {
        		if (info > noRaiz.getInfo()) {
                    return busca(noRaiz.getDir(), info);
                } else {
                	return noRaiz;
                }
        	}
        }
	}
	
    public void insere(int info) {
    	this.raiz = insere(this.raiz, info); 
    }
    
    private NoArvoreBusca insere(NoArvoreBusca noRaiz, int info){
    	if(noRaiz == null){
    		noRaiz = new NoArvoreBusca();
    		noRaiz.setInfo(info);
    		noRaiz.setDir(null);
    		noRaiz.setEsq(null);
    	} else {
    		if(info < noRaiz.getInfo()){
    			noRaiz.setEsq(insere(noRaiz.getEsq(),info));
    		} else {
    			noRaiz.setDir(insere(noRaiz.getDir(), info));
    		}
    	}
    	return noRaiz;
    }
    
    
    public NoArvoreBusca retira(int v) {
        return retira(this.raiz, v);
    }

    private NoArvoreBusca retira(NoArvoreBusca noRaiz, int info) {
        if (noRaiz == null) {
            return null;
        } else {
        	if(info < noRaiz.getInfo()){
        		noRaiz.setEsq(retira(noRaiz.getEsq(),info));
        	} else {
        		if (info > noRaiz.getInfo()){
        			noRaiz.setDir(retira(noRaiz.getDir(),info));
        		} else {
        			if(noRaiz.getEsq() == null && noRaiz.getDir() == null){
        				noRaiz = null;
        			} else {
        				if(noRaiz.getEsq() == null){
        					noRaiz = noRaiz.getDir();
        				} else {
        					if(noRaiz.getDir() == null){
        						noRaiz = noRaiz.getEsq();
        					} else {
        						NoArvoreBusca p = noRaiz.getEsq();
        						while(p.getDir() != null){
        							p = p.getDir();
        						}
        						noRaiz.setInfo(p.getInfo());
        						p.setInfo(info);
        						noRaiz.setEsq(retira(noRaiz.getEsq(),info));
        					}
        				}
        			}
        		}
        	}
        }
        return noRaiz;
    }	
    
    public String toStringDecrescente() {
        return toStringDecrescente(this.raiz);
    }

    private String toStringDecrescente(NoArvoreBusca no) {
        String s = new String("");
        if (no != null) {
            s += toStringDecrescente(no.getDir());
            s += no.getInfo() + " ";
            s += toStringDecrescente(no.getEsq());
        }
        return s;
    }    
    
    @Override
    public String toString() {
        return toString(this.raiz);
    }

    private String toString(NoArvoreBusca no) {
        String s = new String("");
        
        if (no != null) {
            s += toString(no.getEsq());
            s += no.getInfo() + " ";
            s += toString(no.getDir());
        }
        
        return s;
    }

    public int somaFolhas() {
        return somaFolhas(this.raiz);
    }

    private int somaFolhas(NoArvoreBusca no) {
        int v = 0;
        if (no != null) {
            v = v + somaFolhas(no.getEsq());
            v = v + somaFolhas(no.getDir());
            if (no.getEsq() == null && no.getDir() == null) {
                v += no.getInfo();
            }
        }
        return v;
    }

    public int maioresX(int x) {
        return maioresX(this.raiz, x);
    }

    private int maioresX(NoArvoreBusca no, int x) {
        int v = 0;
        
        if(no.getInfo() > x){
        	v += no.getInfo();
        }
        
       	if(no.getDir() != null){
       		v += maioresX(no.getDir(),x);
         
       	}
       	if(no.getEsq() != null){
       		v+= maioresX(no.getEsq(),x);
       	}

        return v;
    }
    
    public void imprimeRaiz(){
    	System.out.println(this.raiz);
    }
}
