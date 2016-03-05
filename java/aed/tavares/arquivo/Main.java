/**
  * @author arthur
  *
 **/

package br.com.ahe.aed.tavares.arquivo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	private static final int BYTES_NOME = 35;
	private static final int BYTES_ENDERECO = 50;
	
	public static void main(String[] args) {
		
		int vinculo = 1;
		LimitString nome = new LimitString("Arthur Henrique Eggert", BYTES_NOME);
		LimitString endereco = new LimitString("Rua Presidente Costa e Silva, 718", BYTES_ENDERECO);
		Byte curso = new Byte("123");
		
		Aluno a1 = new Aluno(vinculo, nome, curso, endereco);
		
		vinculo = 2;
		nome = new LimitString("Samira da Rocha", BYTES_NOME);
		endereco = new LimitString("Rua da Gloria, 613",BYTES_ENDERECO);
		curso = new Byte("2");
		
		Aluno a2 = new Aluno(vinculo, nome, curso, endereco);
				
		Arquivo arq = new Arquivo("//home//arthur//", "roa.txt", "rw");
		
		
		try {
			arq.criaRandomAcessFile();
			arq.gravaAluno(a1);
			arq.gravaAluno(a2);
			
			Aluno meuAluno = arq.recuperaAluno(1);
			System.out.println(meuAluno.toString());
			meuAluno = arq.recuperaAluno(2);
			System.out.println(meuAluno.toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
