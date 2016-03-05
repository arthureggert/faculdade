package br.com.ahe.aed.tavares.lista;

public class Main {
	
	public static void main(String[] args) throws Exception {
		ListaEncadeada l1 = new ListaEncadeada();
				
		l1.insere(2);
		l1.insere(1);
		l1.insere(3);
		l1.insere(4);
		l1.insere(5);
		l1.insere(7);
		l1.insere(6);
		l1.insere(8);
		l1.insere(9);
		
		l1.imprime();
		l1.inverteLista();
		l1.imprime();
	}
}

