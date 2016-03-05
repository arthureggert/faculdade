package br.com.ahe.aed.tavares.arvore;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		arvore.setRaiz(arvore.criaArvore());
		
		String xpto = arvore.preFixadoRecusivo();
		System.out.println(xpto);
		
	}

}
