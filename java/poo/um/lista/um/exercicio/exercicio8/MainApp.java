package br.com.ahe.poo.um.lista.um.exercicio.exercicio8;

public class MainApp {
	
	public static void main(String[] args) {
		
		VetorDeReais v = new VetorDeReais(7);
		VetorDeReais v2 = new VetorDeReais(2);
		
		v.adicionaNumero(1.5d);
		v.adicionaNumero(1.0d);
		v.adicionaNumero(2.5d);
		v.adicionaNumero(3.9d);
		v.adicionaNumero(25.0d);
		v.adicionaNumero(4.8d);
		v.adicionaNumero(9.7d);
		
		v2.adicionaNumero(1.5d);
		v2.adicionaNumero(2.1d);
		
		
//		System.out.println(v.multiplicaVetor(v2));
//		System.out.println(v.criaVetorMultiplicacao(v2).toString());
//		System.out.println(v2.qtdPares());
		System.out.println(v.toString());
//		v.inverteElementos();
//		System.out.println(v.toString());
		System.out.println(v.mairDiferencaEntreValores());
	}

}
