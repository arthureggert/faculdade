package br.com.ahe.aed.rodacki.hash;

public class TabelaHashMain {
	
	public static void main(String[] args) {
		TabelaHash tab = new TabelaHash(50);

		tab.setAluno(1, "arthur", 2.5f);
		tab.setAluno(1, "Roa", 3.9f);
		tab.setAluno(4, "Samira", 10.0f);
		tab.setAluno(3, "Xunior", 9.5f);
//		System.out.println(tab.toString());
//		tab.remove(1);
//		tab.remove(1);
//		System.out.println(tab.toString());
//		System.out.println(tab.mediaGeral());
//		tab.reAloca(25);
		
		tab.ordena();
		System.out.println(tab.toString());
	}
	

}
