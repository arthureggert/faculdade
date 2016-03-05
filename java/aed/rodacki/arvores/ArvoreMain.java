/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ahe.aed.rodacki.arvores;

/**
 *
 * @author Marcelo
 */
public class ArvoreMain {

    public static void main(String[] args) {
        Arvore a = new Arvore();
        NoArvore n1 = a.criaNo(1);
        NoArvore n2 = a.criaNo(2);
        NoArvore n3 = a.criaNo(3);
        NoArvore n4 = a.criaNo(4);
        NoArvore n5 = a.criaNo(5);
        NoArvore n6 = a.criaNo(6);
        NoArvore n7 = a.criaNo(7);
        NoArvore n8 = a.criaNo(8);
        NoArvore n9 = a.criaNo(9);
        NoArvore n10 = a.criaNo(10);
        a.insereFilho(n3, n4);
        a.insereFilho(n2, n5);
        a.insereFilho(n2, n3);
        a.insereFilho(n9, n10);
        a.insereFilho(n7, n9);
        a.insereFilho(n7, n8);
        a.insereFilho(n1, n7);
        a.insereFilho(n1, n6);
        a.insereFilho(n1, n2);

        System.out.println(a.somaInfoInternos());

    }
}
