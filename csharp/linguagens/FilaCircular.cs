using System;

namespace L1211B05
{
	public class FilaCircular<Type>
	{
		private int tamanho;
		private int inicio;
		private int fim;
		private int qtdEmelento;
		private Type[]  armazem;
		
		public FilaCircular(int tamanho)
		{
			this.inicio = 0;
			this.fim = 0;
			this.tamanho = tamanho;
			this.qtdEmelento = 0;
			this.armazem = new Type[tamanho];
		}

		
		public void insere(Type obj)
		{
			armazem[fim] = obj;
			fim = (fim + 1) % tamanho;
			qtdEmelento++;
		}
	
    	public void retira()
		{
    		Console.WriteLine("Excluído: " +armazem[inicio] );
	        inicio = (inicio+1)%tamanho;
    	    qtdEmelento--;
    	}
    
    	public String toString()
		{    
        	String str = "";                    
        	str+= armazem[inicio];
        	return str;
    	}
		
    	public void imprime()
		{
    		Console.WriteLine(toString());
    	}
    
		public int getQtdEmelento()
		{
			return qtdEmelento;
		}
	
		public int getTamanho() 
		{
			return tamanho;
		}
	}
}
