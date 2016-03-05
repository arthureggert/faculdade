/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ahe.so.concorencia;


/**
 *
 * @author humberto.brandao
 */
public class MainExemploConcorrencia {

    public MainExemploConcorrencia(){
        
        Thread t1 = new Concorrente("Thread 01");
        Thread t2 = new Concorrente("Thread 02");
        
        t1.start();
        t2.start();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MainExemploConcorrencia();
    }

}
