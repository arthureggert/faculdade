package br.com.ahe.ldp.exemplos;

public class Teste {
	
	public Teste(String xpto){
		this(xpto,1);
	}
	
	public Teste(String xpto, int i) {
	}
	
	public Teste(){
		
	}

	public void exemplo1(String ... objs){
		System.out.println("Exemplo1 com ...");
	}
	
	public void exemplo1(String obj){
		System.out.println("Exemplo1 com um objeto");
	}
}
