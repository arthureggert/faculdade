package br.com.ahe.lf.endy;

import javax.management.InvalidAttributeValueException;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Teste para verificar o automato finito");
		System.out.println(" numero teste | palavra | resultado ");
		System.out.println("------------------------------------");
		System.out.println("       1      |  teste  | " + Leitura("teste"));
		System.out.println("       2      |  aaaaa  | " + Leitura("aaaaa"));
		System.out.println("       3      |  aabbb  | " + Leitura("aabbb"));
		System.out.println("       4      |  abbba  | " + Leitura("abbba"));
		System.out.println("       5      |  abbbb  | " + Leitura("abbbb"));
		System.out.println("       6      |  abbbc  | " + Leitura("abbbc"));
		System.out.println("       7      |  acbba  | " + Leitura("acbba"));
		System.out.println("       8      |  aabbc  | " + Leitura("aabbc"));
		System.out.println("       9      |  aabcb  | " + Leitura("aabcb"));
		System.out.println("       10     |  ababa  | " + Leitura("ababa"));
		System.out.println("       11     |  abaab  | " + Leitura("abaab"));
	}

	private static String Leitura(String valor) {
		AutomatoFinito teste = new AutomatoFinito();
		try {
			if (teste.leituraSimbolos(valor.toUpperCase()))
				return "Palavra aceita";
			else {
				return "Palavra n�o aceita";
			}
		} catch (InvalidAttributeValueException e) {
			return "Caracter incorreto";
		}
	}
}