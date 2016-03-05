package br.com.ahe.ldp.exemplos;

public class StackOverFlow {

	public static void main(String[] args) {
		int i = 0;
		stack(i);
	}
	
	public static void stack(int i){
		while (true) {
//			System.out.println(i++);
			stack(i);
		}
	}
}
