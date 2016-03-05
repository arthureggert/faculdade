package br.com.ahe.aed.provas.prova3;

public class TabelaTotal{
	
     private Aluno[] tab;
     private int numElementos;
     
     
     public TabelaTotal(int tamanho){
        this.tab = new Aluno[tamanho];
        this.numElementos = 0;
     }
     
     public void adiciona(Aluno a){
    	 this.tab[this.numElementos] = a;
    	 this.numElementos++;
     }
     
     public void imprime(){
    	 for (int i = 0; i < this.numElementos; i++){
    		 System.out.println(this.tab[i].getNome());
    	 }
     }
     public void insercao(){
     // implementar aqui o m�todo de classifica��o por inser��o
     // considere que a tabela j� existe e o atributo    numElementos j� contem o numero de elementos.
    	 int i,j;
    	 Aluno temp;
    	 @SuppressWarnings("unused")
		boolean possicao;
    	 for (i=1; i < this.numElementos; i++){
    		 j = i;
    		 temp = this.tab[j];
    		 possicao = false;
    		 do{
    			 if(temp.getNome().compareTo(this.tab[j-1].getNome()) > 0){
    				 this.tab[j] = this.tab[j-1];
    				 j = j-1;
    				 if(j == 0){
    					 possicao = true;
    				 }
    			 } else {
    				 possicao = true;
    			 }
    		 } while(possicao = false);
    		 this.tab[j] = temp;
    	 }
    	 

     }   
     
     
}
