package br.com.ahe.aed.rodacki.pilhas;


/**
 * @author Arthur Henrique Eggert
 **/

public class PilhaVetor implements Pilha {

    int qtdElementosNaPilha;
    private int tamanhoDaPilha;
    private int vetorPilha[];

    public PilhaVetor(int t) {
    	this.qtdElementosNaPilha = 0;
        this.tamanhoDaPilha = t;
        this.vetorPilha = new int[this.tamanhoDaPilha];
    }
    
    public void push(int valorNoPilha) throws Exception {
    	if(cheia()){
    		throw new Exception("ERRO: Tamanho da pilha foi ultrapassado");
    	} else {
    		this.vetorPilha[this.qtdElementosNaPilha] = valorNoPilha;
    		this.qtdElementosNaPilha++;
    	}
    }
    
    public int pop() throws Exception {
        int valorRemovidoPilha = 0;
        
        if(vazia()){
            throw new Exception("ERRO: Pilha esta vazia");  
        } else {
            valorRemovidoPilha =  this.vetorPilha[this.qtdElementosNaPilha-1];
            this.qtdElementosNaPilha--;
        }
        return valorRemovidoPilha;
    }

    public boolean vazia() {
        if (this.qtdElementosNaPilha == 0) {
            return true;
        }
        return false;
    }

    public boolean cheia() {
        if (this.qtdElementosNaPilha == this.tamanhoDaPilha) {
            return true;
        }   
        return false;
    }

    public void libera() {
        this.vetorPilha = new int[this.tamanhoDaPilha];
    }
    

    @Override
    public String toString() {
    	String strDeMsg = "";
    	if (this.vazia()){
    		strDeMsg += "Nada p/ imprimir, pilha vazia";
    	} else {
    		for (int i = this.qtdElementosNaPilha-1; i >=0; i--) {
    			strDeMsg += this.vetorPilha[i] + " ";
    		}
    	}
    	return strDeMsg;
    }

    public int top() throws Exception {
    	if(this.vazia()){
    		throw new Exception("ERRO: Pilha esta Vazia");   
    	} else {
    		return this.vetorPilha[this.tamanhoDaPilha-1];
	    }
    }
    
}
