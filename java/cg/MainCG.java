package br.com.ahe.cg;

import br.com.ahe.cg.exercicios.N2Exercicio1;
import br.com.ahe.cg.utils.Janela;


public class MainCG {
	
	public static void main(String args[]) {
		
		Janela janela = new Janela("Exercicio 2 - N2[CG]" , new N2Exercicio1());
		janela.setVisible(true);
		janela.setBounds(300,250,422,422);
		janela.display();
	}

}
