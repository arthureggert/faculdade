package br.com.ahe.poo.um.lista.um.exercicio.exercicio5;


public class ActionCalculaTamanhoFrase {

	private String[] tamanhoFrase(String frase) {
		return frase.split(" ");
		
	}
	
	public void run(String frase) {
		String[] imprimir = tamanhoFrase(frase);
		StringBuilder stringBuild = new StringBuilder();
		stringBuild.append("PALAVRA " + " TAMANHO\n");
		for (String imp : imprimir) {
			stringBuild.append(imp + " " + imp.length() + "\n" );
		}
		System.out.println(stringBuild.toString());			
	}
	
}
