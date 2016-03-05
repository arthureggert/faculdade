package br.com.ahe.aed.rodacki.filas;

public class FilaMain {

    public static void main(String [] args){
	FilaVetor f = new FilaVetor(10);
//	FilaVetor f2 = new FilaVetor(6);
//	FilaVetor f3;
		try {
		    f.insere(1);
		    f.insere(3);
		    f.insere(8);
		    f.insere(2);
		    f.insere(98);
		    System.out.println(f.imprimePares());
//		    f2.insere(6);
//		    f2.insere(87);
//		    f2.insere(56);
//		    f2.insere(93);
//		    f2.insere(20);
//		    System.out.println("f1 " + f.toString());
//		    f.retira();
//		    System.out.println("f1 " + f.toString());
//		    f3 = f.merge(f2);
//		    
//		    
//		    System.out.println("f3 " + f3.toString());
		} catch (Exception e) {
		     e.printStackTrace();
		}
    }
}
