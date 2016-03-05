package br.com.ahe.aed.rodacki.filas;



/**
 * @author Arthur Henrique Eggert
 */
public class FilaLista implements Fila{

    private NoFila ini;
    private NoFila fim;
    
    public FilaLista(){
        this.ini = null;
        this.fim = null;
    }
    
    public FilaLista merge(FilaLista f2){
        FilaLista nova = new FilaLista();
        
        NoFila n1 = this.ini;
        NoFila n2 = f2.ini;
            
        try{
            while(n1 != null || n2 != null){
                if(n1 != null){
                    nova.insere(n1.getInfo());
                    n1 = n1.getProx();
                }
                if(n2 != null){
                    nova.insere(n2.getInfo());
                    n2 = n2.getProx();
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nova;
    }
    
    public FilaLista concatena(FilaLista f2){
        FilaLista nova = new FilaLista();
        
        NoFila n1 = this.ini;
        NoFila n2 = f2.ini;
            
        try{
            while(n1 != null) {
                nova.insere(n1.getInfo());
                n1 = n1.getProx();
            }
            while (n2 != null) {
                nova.insere(n2.getInfo());
                n2 = n2.getProx();
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nova;
    }
    
    @Override
    public String toString(){
        String str = "";
        NoFila p = this.ini;
        
        while( p != null ){
            str += p.getInfo() + " ";
            p = p.getProx();
        }        
        return str;
    }
    
    @Override
    public void insere(int v) throws Exception {
        NoFila novo = new NoFila();
        novo.setInfo(v);
        novo.setProx(null);
        
        //Se fila n�o est� vazia
        if(this.fim != null){
            this.fim.setProx(novo);
        }else{
            this.ini = novo;
        }
        this.fim = novo;
    }
    
    
    @Override
    public int retira() throws Exception {
        int v;
        if(vazia()){
            throw new Exception("ERRO? fila vazia!");
        }else{
            v = this.ini.getInfo();
            this.ini = this.ini.getProx();
            if(this.ini == null){
                this.fim = null;
            }
            return v;
        }            
    }
    
    
    @Override
    public boolean vazia() {
        return this.fim==null;
    }
    
    
    @Override
    public void libera() {
        this.ini = null;
        this.fim = null;
    }    
}
