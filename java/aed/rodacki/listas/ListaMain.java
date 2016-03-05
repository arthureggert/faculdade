package br.com.ahe.aed.rodacki.listas;

public class ListaMain {
	
	public static void main(String []args){
		ListaDupla l = new ListaDupla();
		ListaDupla ll = new ListaDupla();
		l.insere(1);
		l.insere(2);
		l.insere(3);
		l.insere(4);
		ll = l.separa(2);
		ll.imprime();
		
	}
}
