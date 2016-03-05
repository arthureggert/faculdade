package br.com.ahe.ldp.exemplos;

public class GenericoJava<T> {
			
	@SuppressWarnings( "unchecked" )
    public T getT() {
		return (T) "a";
	}
	
}

