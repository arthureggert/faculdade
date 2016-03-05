/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ahe.so.concorencia;



/**
 *
 * @author humberto
 */
public class ExemploRegiaoCritica extends Thread{
    
    public static int rc = 0;

    Semaforo s;
    
    String nome;
    
    public ExemploRegiaoCritica(String nome, Semaforo s){
        this.nome = nome;
        this.s = s;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaforo s = new Semaforo(1, "RC");
        
        Thread t1 = new ExemploRegiaoCritica("T1", s);
        Thread t2 = new ExemploRegiaoCritica("T2", s);
        t1.start();
        t2.start();
    }
    
    @Override
    public void run(){
                
        while(true){
            this.s.down();
            System.out.println( "Entrando na regiao critica: "+ this.nome);
            for(int i = 0; i < 10; i++){
                ExemploRegiaoCritica.rc++;
                System.out.println( "\t"+ this.nome + ": "+ i );    
            }
            System.out.println( "Saindo da regiao critica: "+ this.nome);
            this.s.up();
            Thread.yield();
        }
    }

}
