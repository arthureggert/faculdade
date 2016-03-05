package br.com.ahe.aed.tavares.hash;

import java.util.Scanner;

public class Main {
	
	public Main() {

	}
	
	public static void main(String[] args) {
		
		Hashing tab = new Hashing();
        //String linha = new String();
        Scanner sc = new Scanner(System.in);    
        
        int info;
        System.out.println("Entre com o valor de chave a ser inserido: ");   
        @SuppressWarnings("unused")
		int endereco;
        int chave = sc.nextInt();            
        
        while (chave != 0) {
        	System.out.println(chave);
            System.out.println("Digite a informacao:");
            info = sc.nextInt();
             
            if (tab.insere(chave, info) ){
            	System.out.println("\ninseriu");            	
            } else {
            	System.out.println("\nn�o inseriu");            	
            }
            
            System.out.println("\n Chave que deseja pesquisar:");
              
            chave = sc.nextInt();
            
            if( chave > 0 ){
            	
            	if((endereco = tab.pesquisaChave(chave)) < 0 ) {
                      System.out.println("\nN�o existe.");
            	} else {
            		System.out.println("\n Info = " + chave + tab.getInfo(chave));            		
            	}
            	
               System.out.println("deseja inserir chave :");
               
               chave = sc.nextInt();
           }  
        }
        
        sc.close();
	}
}