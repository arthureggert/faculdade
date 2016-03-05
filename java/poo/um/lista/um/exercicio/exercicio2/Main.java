package br.com.ahe.poo.um.lista.um.exercicio.exercicio2;

public class Main {

	public static void main(String[] args) {
		try {
			InteiroPositivo xpto = new InteiroPositivo(5);
			System.out.println(xpto.getQtdDivisores(12));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
