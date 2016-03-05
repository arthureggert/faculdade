package br.com.ahe.ldp.exemplos;

public class ExemploChar {

	private static char a;
	
	public static void main(String[] args) {
		System.out.println(a);
	}

	public static char getA() {
		return a;
	}

	public static void setA(char a) {
		ExemploChar.a = a;
	}
}
