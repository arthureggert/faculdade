package br.com.ahe.ldp.produtor.L1311H04;

import java.util.Scanner;

import javax.swing.UIManager;


public class TelaInicial {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		System.out.println("L1311H04 - Arthur Henrique Eggert");

		int qtdProdutores = getNumeroMaiorZero("Digite o n�mero de produtores: ");

		int tamArmazem = getNumeroMaiorZero("Digite o tamanho do armaz�m dos produtores: ");

		int qtdConsumidores = getNumeroMaiorZero("Digite o n�mero de consumidores: ");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new TelaPrincipal(qtdProdutores, qtdConsumidores, tamArmazem);
		} catch (Exception e) {
			
		}
	}
	

	private static int getNumeroMaiorZero(String pergunta) {
		String numeroLido;
		int numeroRetorno = 0;
		do {
			System.out.println(pergunta);
			numeroLido = scanner.next();
			
			try {
				numeroRetorno = Integer.parseInt(numeroLido);				
			} catch (NumberFormatException e) {
				System.out.println("Informe apenas numeros");
				continue;
			}
			
			if (numeroRetorno > 0) {
				return numeroRetorno;
			} else {
				System.out.println("Maior que 0");
				continue;
			}
		} while (true);
	}
}
