package br.com.ahe.aed.outros;

public interface Fila {

	public void insere(int v) throws Exception;
	
	public int retira() throws Exception;
    
	public boolean vazia();
	
	public void libera();
	
}
