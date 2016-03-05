package br.com.ahe.ldp.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	static BufferedReader tec  = new BufferedReader(new InputStreamReader(System.in));
	static FilaCircular<String> fcNomes;
	static boolean fcNomesExist = false;
	static FilaCircular<Montadoras> fcMontadoras;
	static boolean fcMontadorasExist = false;
	static FilaCircular<Integer> fcInteger;
	static boolean fcIntegerExist = false;
			
	public static void main(String[] args) throws NegativeArraySizeException, ClassNotFoundException, IOException {
				System.out.println("L1211A05 - Arthur Henrique Eggert");
				imprimeMenu1();
	}
	
	private static String tiposListas() {
		String filas = "";
			if(!fcNomesExist && !fcIntegerExist && !fcMontadorasExist){
				filas += "Nenhuma";
			} else {
				if (fcNomesExist){
					filas+="Nomes ";
				}
				if (fcIntegerExist){
					filas+="Inteiros ";
				}
				if (fcMontadorasExist){
					filas+="Montadoras ";
				}
			}
		return filas;
	}

	private static void imprimeMenu1() throws IOException, NumberFormatException, NegativeArraySizeException, ClassNotFoundException {
		String menu1 = "" +  "1 - fila de nomes \n" +  "2 - fila de inteiros \n" +  "3 - fila de montadoras \n" +  "9 - finaliza\n" +  "Filas existentes:  " + totalListas() +"\n" +	  "Tipos de filas existentes: " + tiposListas() ;
		System.out.println(menu1);
		String str = tec.readLine();
		int opcao = Integer.parseInt(str);
		switch (opcao) {
			case 1:
				imprimeMenu2("String");
				break;
			case 2:
				imprimeMenu2("Integer");
				break;
			case 3:
				imprimeMenu2("Montadoras");
				break;
			case 9:
				finaliza();
				break;
		
			default:
				System.out.println("Valor Invalido");
				imprimeMenu1();
				break;
		}		
	}
	
	private static void imprimeMenu2(String tipo) throws IOException, NumberFormatException, NegativeArraySizeException, ClassNotFoundException{
		String menu2 = "" + "Tipo da fila: " +tipo + "\n" + "Total de Elemento: " + quantidadeElementosFila(tipo) + "\n" + "Tamanho da fila: " + tamanhoFila(tipo) + "\n" +	"1 - criar fila\n" + "2 - destruir fila\n" + "3 - inserir\n" + "4 - mostrar\n" + "5 - excluir\n" + "9 - retorna ao menu 1";
		System.out.println(menu2);
		String str = tec.readLine();
		int opcao = Integer.parseInt(str);
		switch (opcao) {
			case 1:
				criafila(tipo);
				imprimeMenu2(tipo);
				break;
			case 2:
				destroiFila(tipo);
				imprimeMenu2(tipo);
				break;
			case 3:
				inserir(tipo);
				imprimeMenu2(tipo);
				break;
			case 4:
				imprime(tipo);
				imprimeMenu2(tipo);
				break;
			case 5:
				excluir(tipo);
				imprimeMenu2(tipo);
				break;
			case 9:
				imprimeMenu1();
				break;
				
			default:
				System.out.println("Valor Invalido");
				imprimeMenu2(tipo);
				break;
		}
	}
		

	private static String tamanhoFila(String tipo) {
		String tamanhoFila = "";
		if(!fcNomesExist && !fcIntegerExist && !fcMontadorasExist){
			tamanhoFila = "Não Criada";
		} else {
			if (fcNomesExist){
				tamanhoFila = String.valueOf(fcNomes.getTamanho()); 
			}
			if (fcIntegerExist){
				tamanhoFila = String.valueOf(fcInteger.getTamanho());
			}
			if (fcMontadorasExist){
				tamanhoFila = String.valueOf(fcMontadoras.getTamanho());
			}
		}
		return tamanhoFila;
	}

	private static String quantidadeElementosFila(String tipo) {
		String qtdElementos = "";
		if(!fcNomesExist && !fcIntegerExist && !fcMontadorasExist){
			qtdElementos = "Não Criada";
		} else {
			if (fcNomesExist){
				qtdElementos = String.valueOf(fcNomes.getQtdEmelento()); 
			}
			if (fcIntegerExist){
				qtdElementos = String.valueOf(fcInteger.getQtdEmelento());
			}
			if (fcMontadorasExist){
				qtdElementos = String.valueOf(fcMontadoras.getQtdEmelento());
			}
		}
		return qtdElementos;
	}

	private static void excluir(String tipo) {
		if(tipo == "String"){
			if(fcNomesExist){
				fcNomes.retira();
				return;
			}
		}
		if(tipo == "Integer"){
			if(fcIntegerExist){
				fcInteger.retira();
				return;
			}
		}		
		if(tipo == "Montadoras"){
			if(fcMontadorasExist){
				fcMontadoras.retira();
				return;
			}
		}
		System.out.println("fila não existe");
	}

	private static void imprime(String tipo) throws IOException {

		if(tipo == "String"){
			if(fcNomesExist){
				if(fcNomes.getQtdEmelento() > 0){
					fcNomes.imprime();
					return;		
				} else {
					System.out.println(" Fila Vazia");
					return;
				}
			}
		}
		if(tipo == "Integer"){
			if(fcIntegerExist){
				if(fcInteger.getQtdEmelento() > 0){
						fcInteger.imprime();
						return;		
				} else {
					System.out.println(" Fila Vazia");
					return;
				}
			}
		}		
		if(tipo == "Montadoras"){
			if(fcMontadorasExist){
				if(fcMontadoras.getQtdEmelento() > 0){
						fcMontadoras.imprime();
						return;	
				} else {
					System.out.println(" Fila Vazia");
					return;
				}
			}
		}
		System.out.println("fila não existe");
	}

	private static void inserir(String tipo) throws IOException {
		System.out.println("Informe o valor a ser inserido");
		String obj = tec.readLine();
		if(tipo == "String"){
			if(fcNomesExist){
				if(fcNomes.getQtdEmelento() < fcNomes.getTamanho()){
					fcNomes.insere(obj);
					return;	
				} else{
					System.out.println("Fila esta cheia");
					return;
				}
			}
		}
		if(tipo == "Integer"){
			if(fcIntegerExist){
				if(fcInteger.getQtdEmelento() < fcInteger.getTamanho()){
					fcInteger.insere(obj);
					return;
				} else {
					System.out.println("Fila esta cheia");
					return;
				}
			}
		}		
		if(tipo == "Montadoras"){
			if(fcMontadorasExist){
				if(fcMontadoras.getQtdEmelento() < fcMontadoras.getTamanho()){
					Montadoras[] mon = Montadoras.values();
					for (Montadoras montadoras : mon) {
						if(montadoras.name().equalsIgnoreCase(obj)){
							fcMontadoras.insere(obj);							
						}
					}
					return;			
				}
			}
		}
		System.out.println("fila não existe");		
	}

	private static void destroiFila(String tipo) {
		if(tipo == "String"){
			if(fcNomesExist ){
				if(fcNomes.getQtdEmelento() == 0){
					fcNomes = null;
					fcNomesExist =false;
					return;
				} else {
					System.out.println("fila não esta vazia");
					return;
				}
			}
		}
		if(tipo == "Integer"){
			if(fcIntegerExist){
				if(fcInteger.getQtdEmelento() == 0){
					fcInteger =null;
					fcIntegerExist =false;
					return;	
				}
				else {
					
				}
			}
		}		
		if(tipo == "Montadoras"){
			if(fcMontadorasExist){
				if(fcMontadoras.getQtdEmelento() == 0){
					fcMontadoras= null;
					fcMontadorasExist = false;
					return;	
				} else {
					System.out.println("Fila não esta vazia");
					return;
				}
			}
		}
		System.out.println("fila não existe");
	}

	private static void criafila(String tipo) throws NegativeArraySizeException, ClassNotFoundException, IOException {
		System.out.println("Informe o tamanho");
		String tam = tec.readLine();
		if(tipo == "String"){
			if(!fcNomesExist){
				fcNomesExist = true;
				fcNomes = new FilaCircular<String>(Integer.parseInt(tam));
				return;
			}
		}
		if(tipo == "Integer"){
			if(!fcIntegerExist){
				fcIntegerExist = true;
				fcInteger = new FilaCircular<Integer>(Integer.parseInt(tam));
				return;
			}
		}		
		if(tipo == "Montadoras"){
			if(!fcMontadorasExist){
				fcMontadorasExist = true;
				fcMontadoras= new FilaCircular<Montadoras>(Integer.parseInt(tam));
				return;
			}
		}
		System.out.println("Fila ja existe não pode ser criada novamente");
	}

	private static void finaliza() {
		if(semListas()){
			System.exit(0);
		}
	}
	
	private static boolean semListas() {
		if (fcIntegerExist || fcNomesExist  || fcMontadorasExist){
			return true;
		}
		return false;
	}

	private static int totalListas() {	
		int totalListas = 0;
		if (fcIntegerExist){
			totalListas+=1;
		}
		if (fcMontadorasExist){
			totalListas+=1;
		}
		if (fcNomesExist){
			totalListas+=1;
		}
		return totalListas;
	}
}
