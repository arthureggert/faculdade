package br.com.ahe.aed.provas.prova3;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Aluno a1 = new Aluno(1, new String("Beanca").toCharArray(), 22);
		Aluno a2 = new Aluno(1, new String("Samira").toCharArray(), 22);
		Aluno a3 = new Aluno(1, new String("Raquel").toCharArray(), 22);
		Aluno a4 = new Aluno(1, new String("Arthur").toCharArray(), 22);
		
		TabelaTotal t1 = new TabelaTotal(4);
		t1.adiciona(a1);
		t1.adiciona(a2);
		t1.adiciona(a3);
		t1.adiciona(a4);
		//t1.imprime();
		t1.insercao();
		t1.imprime();
	}

}
