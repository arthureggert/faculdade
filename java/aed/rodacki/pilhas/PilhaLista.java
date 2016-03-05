package br.com.ahe.aed.rodacki.pilhas;


/**
 * @author Arthur Henrique Eggert
 **/

public class PilhaLista implements Pilha {

    private NoPilha topo;
    
    public PilhaLista() {
    	this.topo = null;
    }
    
    public void push(int valorNoPilha) throws Exception {
    	NoPilha noPilha = new NoPilha();
    	noPilha.setInfo(valorNoPilha);
	
    	if (this.vazia()) {
    		this.topo = noPilha;
    	} else {
    		noPilha.setProx(this.topo);
    		this.topo = noPilha;
    	}
    }

    public int pop() throws Exception {
    	int valor = 0;
    	if (vazia()) {
            throw new Exception("ERRO: Pilha esta Vazia");
        } else {
        	valor = this.topo.getInfo();
            this.topo = this.topo.getProx();
            return valor;
        }	
    }

    public int top() throws Exception {
    	NoPilha p = this.topo;
    	if(this.vazia()){
    		throw new Exception("ERRO: Pilha esta Vazia");   
    	} else {
    		while(p.getProx()!=null){
    			p=p.getProx();
    		}
    		return p.getInfo();
    	}
    }

    public boolean vazia() {
        if (this.topo == null) {
            return true;
        }
        return false;
    }
    
    public void libera() {
        if (!vazia()) {
            NoPilha p = this.topo;
            while (p.getProx() != null) {
                this.topo = this.topo.getProx();
                p.setProx(null);
                p = this.topo;
            }
            this.topo = null;
        }
    }
    
    @Override
    public String toString() {
    	NoPilha p = this.topo; 
    	String strDeMsg = "";
    	if (this.vazia()){
    		strDeMsg += "Nada p/ imprimir, pilha vazia";
    	} else {
    		while (p != null) {
    			strDeMsg += p.getInfo()+" ";
    			p = p.getProx();
    		}
    	}
        return strDeMsg;
    }
}
