package br.com.ahe.aed.rodacki.filas;

/**
 * @author Arthur Henrique Eggert
 **/

public interface Fila {
    
    public void insere(int v) throws Exception;
    public int retira() throws Exception;
    public boolean vazia() throws Exception;
    public void libera();

}

