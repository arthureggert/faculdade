package br.com.ahe.aed.tavares.pesquisa;

public class Tabela2
{
    private char tab[];
	private int numElementos;

	public Tabela2(int tamanho, String cadeia)
	{
	   this.numElementos = cadeia.length();
       this.tab = new char[tamanho];
       for (int i = 0; i < tamanho; i++)
          this.tab[i] = cadeia.charAt(i);
 	}

    public void exibeTabela()
    {
       System.out.print("Tabela = ");
       for (int i = 0; i < this.numElementos ; i++)
          System.out.print(" " + this.tab[i]);
       System.out.println();
    }
    
    public void bolha()
    {
       int fim = this.numElementos;
       char temp;
       boolean trocou;
       do {
          trocou = false;
          for( int i = 0; i < this.numElementos -1 ; i++)
             if(this.tab[i] > this.tab[i+1]) {
                temp = this.tab[i];
                this.tab[i] = this.tab[i+1];
                this.tab[i+1] = temp;
                trocou = true;
             };
           fim = fim - 1;
       } while (trocou );
     }
     
     public void insercao()
     {
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
              }
              else
                 achou = true;
           } while ( !achou );
           this.tab[j+1] = ch;
        }
     }
     
    public static void main(String args[])
    {
       Tabela2 t = new Tabela2(10, "abcdefghij");
       
       t.exibeTabela();
    //       t.bolha();
       t.insercao();
       t.exibeTabela();
       if( t.pesquisaBinaria('a') >= 0 )
           System.out.print("achou");
       else
           System.out.print("nao achou");
    }
    
    public int pesquisaBinaria(char chave)
    {
       int lI, lS, m;
       lI = 0;
       lS = this.numElementos -1;
       while ( lI <= lS ) {
          m = (int) (lI + lS)/2;
          if(this.tab[m] == chave)
             return m;
          else {
             if( chave < this.tab[m] )
                lS = m - 1;
             else
                lI = m + 1;
             }
         }
         return -1;
      }
      
      public int pesquisaSequencial(char chave)
      {
      int i = 0;
      boolean achou = false;
      while (( i < this.numElementos) && ( !achou)) 
      {
      	if(this.tab[i] == chave)
      	   achou = true;
      	else
      	   i++;
      }
      if ( achou ) 
         return i;
      else
         return -1;   	
      }
    
      public int seqOrdenado(char chave)
      {
      	int i = 0;
      	while ( i < this.numElementos )
      	{
      		if(this.tab[i] < chave)
      		   i++;
      		else
      		   if(this.tab[i] == chave)
      		      return i;
      		   else
      		      return -1;
         }
         
         return -1;
      }  
}
