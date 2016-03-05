package br.com.ahe.aed.tavares.pesquisa;
public class Tabela1
{
    private char tab[];
    private int numElementos;

    public Tabela1(int tamanho, String cadeia) {
       this.numElementos = cadeia.length();
       this.tab = new char[tamanho];
       for (int i = 0; i < tamanho; i++) {
          this.tab[i] = cadeia.charAt(i);
       }
    }

    public void exibeTabela() {
       System.out.print("Tabela = ");
       for (int i = 0; i < this.numElementos ; i++) {
          System.out.print(" " + this.tab[i]);
       }
    }
    
    public void bolha(){
       int fim = this.numElementos;
       char temp;
       boolean trocou;
       do {
          trocou = false;
          for( int i = 0; i < this.numElementos -1 ; i++){
             if(this.tab[i] > this.tab[i+1]) {
                temp = this.tab[i];
                this.tab[i] = this.tab[i+1];
                this.tab[i+1] = temp;
                trocou = true;
             }
           fim = fim - 1;
          }
       } while (trocou );
     }
     
     public void insercao(){
        int i, j;
        boolean achou;
        char ch;
        for (i = 1; i < this.numElementos ; i++) {
           j = i - 1;
           achou = false;
           ch = this.tab[i];
           do {
              if( ch < this.tab[j] ) {
                 this.tab[j+1] = this.tab[j];
                 j = j - 1;
                 if( j < 0 )
                    achou = true;
              } else {
            	  achou = true;            	  
              }
           } while ( !achou );
           
           this.tab[j+1] = ch;
        }
     }
     
    public void quickSort() {
        sort(0, this.numElementos - 1);        
    }
    
    private void sort(int esquerda, int direita) {
        int i, j;
        char pivo;
        j = esquerda;
        pivo = this.tab[j];
        i = direita;
        do {
            while ((this.tab[i] > pivo) && (i > j)) {                
                i--;
            }
            if (i != j) {
                this.tab[j] = this.tab[i];
                this.tab[i] = pivo;
            }
            while ((this.tab[j] <= pivo) && (j < i)) {
                j++;
            }
            if (i != j) {
                this.tab[i] = this.tab[j];
                this.tab[j] = pivo;
            }            
        } while (i > j);
        if (esquerda < (i - 1)) {
            sort(esquerda, i-1);
        }
        if (direita > (i + 1)) {
            sort(i+1, direita);
        }
    }
         
    public static void main(String args[])  {
       Tabela1 t = new Tabela1(10, "axbcldemfp");
       
     t.exibeTabela();
     t.quickSort();
     t.exibeTabela();
       if( t.pesquisaBinaria('x') >= 0 )
           System.out.print("achou");
       else
           System.out.print("nao achou");
       
    }    
    
    public int pesquisaBinaria(char chave) {
       int lI, lS, m;
       lI = 0;
       lS = this.numElementos -1;
       while ( lI <= lS ) {
          m = (lI + lS)/2;
          if(this.tab[m] == chave)
             return m;
		if( chave < this.tab[m] )
		    lS = m - 1;
		 else
		    lI = m + 1;
         }
         return -1;
      }      
}
