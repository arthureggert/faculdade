/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ahe.so.concorencia;


/**
 *
 * @author humberto.brandao
 */
public class MainProdutorConsumidor {
    
    int tamanhoDoBuffer = 5;
    
    Semaforo full  = new Semaforo(0, "full");
    Semaforo empty = new Semaforo(this.tamanhoDoBuffer, "empty");
    Semaforo mutex = new Semaforo(1, "mutex");
    
    //Semaforo itensNoBuffer = new Semaforo(0, "itens");
    Semaforo itensNoBuffer = new Semaforo(0, "itens");
    
    int[] buffer = new int[this.tamanhoDoBuffer];
    Nucleo nucleo = new Nucleo();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MainProdutorConsumidor();
    }
    
    public MainProdutorConsumidor(){
        
        //100 produtores
        Thread[] produtores = new Thread[1];
        
        //200 consumidores
        Thread[] consumidores = new Thread[2];
        
        for( int i = 0; i < produtores.length; i++ ){
            produtores[i] = new Produtor(this.empty, this.full, this.mutex, 
                                         this.buffer, this.itensNoBuffer, this.nucleo);
            produtores[i].start();
        }
        
        for( int i = 0; i < consumidores.length; i++ ){
            consumidores[i] = new Consumidor(this.empty, this.full, this.mutex, 
                                             this.buffer, this.itensNoBuffer, this.nucleo);
            consumidores[i].start();
        }
        
    }

}
