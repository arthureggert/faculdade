package br.com.ahe.aed.rodacki.arvores;

public class ArvoreBinariaBuscaMain {

    static ArvoreBinariaBusca ar = new ArvoreBinariaBusca();

    public static void main(String[] args) {
    	ar.insere(6);
        ar.insere(2);
        ar.insere(1);
        ar.insere(4);
        ar.insere(3);
        ar.insere(8);
        System.out.println(ar.toString());
        System.out.println(ar.toStringDecrescente());
        System.out.println(ar.somaFolhas());
        System.out.println(ar.maioresX(2));
//        ar.imprimeRaiz();
//        System.out.println("-----------------------------------------");
//        ar.retira(6);
//        ar.imprimeRaiz();
//        System.out.println("-----------------------------------------");
//        ar.imprimeRaiz();
    }
}
