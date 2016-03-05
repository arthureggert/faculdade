/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ahe.so.concorencia;


/**
 *
 * @author humberto.brandao
 */
public class Nucleo {
    
    public synchronized void down( Semaforo num ){
        try{

            //enquanto nao tem acesso ao semaforo... a thread aguarda...
            while( num.contador == 0 ){
               this.wait();
            }
            //quando a thread tem acesso, o semaforo eh decrementado em uma unidade...
            num.contador--;
        }
        catch( Exception e ){
            e.printStackTrace();
        }
    }
    
    public synchronized void up( Semaforo num ){
    //garante a atomicidade da execucao do método...        

        //quando a thread libera o semaforo, ele eh incrementado em uma unidade...
        //isso possibilita que outra thread (que estah dormindo) possa acessar 
        //a regiao critica controlada pelo semaforo.
        num.contador++;
        //acorda todas as outras threads que estao dormindo...
        //uma delas vai obter acesso a região crítica...
        this.notifyAll();
    }

}
