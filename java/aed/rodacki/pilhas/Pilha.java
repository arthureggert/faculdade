package br.com.ahe.aed.rodacki.pilhas;


/**
 * @author Arthur Henrique Eggert
 */
public interface Pilha {

    public void push(int v) throws Exception;
    public int pop() throws Exception;
    public int top() throws Exception;
    public boolean vazia();
    public void libera();
    
}
