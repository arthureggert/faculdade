package br.com.ahe.aed.rodacki.pilhas;


/**
 * @author Arthur Henrique Eggert
 **/

public class PilhaMain {
   
    public static void main(String []args){
	
	try {
	    PilhaVetor pl = new PilhaVetor(6);
	    pl.push(2);
	    pl.push(5);
	    pl.push(4);
	    pl.push(9);
	    pl.push(16);
	    pl.push(67);
//	    pl.pop();
	    pl.pop();
	    pl.pop();
	    pl.pop();
	    pl.pop();
	    pl.pop();
	    pl.pop();
//            System.out.println(pl.toString());
            System.out.println(pl.top());
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}
