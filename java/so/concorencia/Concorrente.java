/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ahe.so.concorencia;

/**
 *
 * @author humberto.brandao
 */
public class Concorrente extends Thread{

    String nome;
    
    public Concorrente (String nome){
        this.nome = nome;
    }
    
    @Override
    public void run(){
        for( int i = 0; i < 10000; i++ ){
            System.out.println(this.nome + "\t"+  i);
        }
    }
}
