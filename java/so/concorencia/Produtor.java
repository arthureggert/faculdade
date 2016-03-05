/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ahe.so.concorencia;


/**
 *
 * @author humberto.brandao
 */
public class Produtor extends Thread{
    
    Semaforo empty;
    Semaforo full;
    Semaforo mutex;
    Semaforo itensNoBuffer;
    int[] buffer;
    
    Nucleo n;
    
    public Produtor( Semaforo empty, Semaforo full, Semaforo mutex, int[] buffer, Semaforo itensNoBuffer, Nucleo n ) {
        this.empty = empty;
        this.full = full;
        this.mutex = mutex;
        this.buffer = buffer;
        this.itensNoBuffer = itensNoBuffer;
        this.n = n;
        //System.out.println("Produtor criado");
    }
    
    @Override
    public void run() {
        System.out.println("Inicio da producao do produtor");

        while(true){
            this.n.down(this.empty);
            this.n.down(this.mutex);
            this.buffer[this.full.contador] = 1;
            System.out.println("Item Produzido...: " + this.itensNoBuffer.contador++);
            this.n.up(this.mutex);
            this.n.up(this.full);
            //Thread.sleep(3000);
        }

    }
}
