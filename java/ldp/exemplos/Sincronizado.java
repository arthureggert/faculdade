package br.com.ahe.ldp.exemplos;

public class Sincronizado {       
	public static void main(String [] args) throws InterruptedException {     
		Valor v = new Valor();   
		MThread t1 = new MThread(v);   
		MThread t2 = new MThread(v);   
		MThread t3 = new MThread(v);      

		t1.start();   
		t2.start();   
		t3.start();      

		t1.join();   
		t2.join();   
		t3.join();      

		System.out.println(v.get()); // o que ser� impresso? (e sem o synchronized)                     }   }  
	}
}
