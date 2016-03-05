/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ahe.aed.rodacki.arvores;

/**
 *
 * @author Marcelo
 */
public class ArvoreBinariaMain {
//    private static ArvoreBinaria b= new ArvoreBinaria();
    private static ArvoreBinaria a= new ArvoreBinaria();

    public static void main(String [] args){
        a.insere(10);
        a.insere(8);
        a.insere(6);
        a.insere(9);
        a.insere(12);
        a.insere(11);
        a.insere(13);
        a.insere(34);

        System.out.println(a.toString(3));
       



    }
}
