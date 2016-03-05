package br.com.ahe.ldp.exemplos;

public class Fatorial {

	public int fatorial(int nro){
		if (nro == 0) {
			return 1;
		} else {
			return nro * fatorial(nro -1);
		}
	}
	
	public static class Main{
		public static void main(String[] args) {
			Fatorial fat = new Fatorial();
			System.out.println(fat.fatorial(10));
		}
	}
}
