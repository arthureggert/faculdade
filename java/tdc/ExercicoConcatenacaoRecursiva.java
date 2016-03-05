package br.com.ahe.tdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExercicoConcatenacaoRecursiva {

	public static String concatenacao(String str, int qtd){
		if (qtd == 0){
			return "";
		} else {
			return str + concatenacao(str, qtd-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("T1121B09 - Arthur Henrique Eggert");
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Digite uma palavra");
		String str = tec.readLine();
		
		while(!str.equalsIgnoreCase("fim")){
			
			System.out.println("Digite um inteiro");
			int qtdVezes = Integer.parseInt(tec.readLine());
			
			System.out.println(concatenacao(str, qtdVezes));
			
			System.out.println("Digite uma palavra");
			str = tec.readLine();

		}
	}
}
