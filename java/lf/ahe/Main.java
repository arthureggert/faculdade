package br.com.ahe.lf.ahe;

public class Main {
	public static void main(String[] args) {
		AutomatoFinito afd = new AutomatoFinito();
		String analise = "aabbb";
		try {
			System.out.println(afd.iniciaAnalise(analise));
			System.out.println(afd.getTransicoes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
