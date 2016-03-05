package br.com.ahe.aed.provas.prova1;

public class  NodoLista 
{
     private int info;
     private NodoLista proximo;
     
     public NodoLista(int info)
     {
        this.info = info;
        this.proximo = null;
     }
     
     public NodoLista getProximo()
     {
        return this.proximo;
     }
     
     public void setProximo(NodoLista proximo)
     {
        this.proximo = proximo;
     }
     
     public int getInfo()
     {
        return this.info;
     }
     
}


