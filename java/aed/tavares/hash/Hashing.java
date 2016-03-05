package br.com.ahe.aed.tavares.hash;

public class Hashing {
	
    private Entrada[] tabela;
    private int tamanho;
    
    public Hashing() {
        this.tamanho = 1200;               // Tamanho da Tabela
        this.tabela = new Entrada[this.tamanho];
    }
    
    private int calculaEndereco(int chave){     // Calcula o endereco utilizando a fun��o m�dulo
        int endereco = chave % 997;   
        return endereco;
    }
    
    public int pesquisaChave(int chave){        // Pesquisa a tabela em busca de uma chave
    	
       int endereco = calculaEndereco(chave);
       
       if ( this.tabela[endereco] == null ) {  
          return -1;
       } else {
          while (this.tabela[endereco] != null ) {
             if(this.tabela[endereco].getSituacao() == 2 ) {
                if(this.tabela[endereco].getChave() == chave ) {
                   return endereco; 
                }
             endereco = (endereco + 1) % 997; 
             }
          }
          return -1;
       }
    }
       
    public boolean insere(int chave, int info) {   // Insere um elemento na tabela utilizando endere�amento aberto
    	
       if( pesquisaChave(chave) < 0 ) {            // pesquisa para verificar se n�o existe 
           int endereco = calculaEndereco(chave);
           while(( this.tabela[endereco] != null ) && (this.tabela[endereco].getSituacao() == 2 )) {
              endereco = (endereco + 1)% 1000;
           }
           if( this.tabela[endereco] == null ) {  // entrada nova
             this.tabela [endereco] = new Entrada(chave, info);
             this.tabela[endereco].setSituacao((char)2);
             return true; 
           } else  {    // entrada j� utilizada
             this.tabela[endereco].setChave(chave);
             this.tabela[endereco].setInfo(info);
             this.tabela[endereco].setSituacao((char)2);
             return true;
          }
       } else {
            return false;    // chave j� existe
       }
     }
     
     public boolean excluiChave(int chave) {                // Exclui um elemento da tabela
 
         int endereco;
         if( (endereco = pesquisaChave(chave)) < 0 ) {       // Pesquisa a chave na tabela, se n�o achou
            return false;
         } else {
        	 this.tabela[endereco].setSituacao((char)3);       // se achou ent�o exclui
             return true;
         }
      }
      
      public int getInfo(int chave){
    	  int endereco = pesquisaChave(chave);
          
    	  if( endereco < 0 ) {
              return -1;
          } else {
              return(this.tabela[endereco].getInfo());
          }
      }
}

