package br.com.ahe.aed.tavares.lista;

public class NodoListaDupla
{
    private Object info;
    private NodoListaDupla anterior, sucessor;

    public NodoListaDupla(Object info) {
        this.info = info;
        this.anterior = null;
        this.sucessor = null;
    }
    
    public void setAnterior(NodoListaDupla anterior)
    {
        this.anterior = anterior;
    }
    
    public void setSucessor(NodoListaDupla sucessor)
    {
        this.sucessor = sucessor;
    }
    
    public NodoListaDupla getAnterior()
    {
        return this.anterior;
    }
    
    public NodoListaDupla getSucessor()
    {
        return this.sucessor;
    }
    
    public Object getInfo()
    {
        return this.info;
    }
    
}
