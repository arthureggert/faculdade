package br.com.ahe.poo.dois.adapter;


public class Main {
	public static void main(String[] args) {
		
		System.out.println("Classe Adapter");
		ClienteClasse c = new ClienteClasse();
		c.inicializaAlvos();
		c.executaAlvos();
		
		System.out.println("Objeto Adapter Adapter");
		ClienteObejto co = new ClienteObejto();
		co.inicializaAlvos();
		co.executaAlvos();
	}
}
