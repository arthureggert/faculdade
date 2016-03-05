package br.com.ahe.ldp.java;

public class FilaCircular<T>{

	private int tamanho;
	private int inicio;
	private int fim;
	private int qtdEmelento;
	private T[]  armazem;

	@SuppressWarnings("unchecked")
	public FilaCircular( int tamanho) {
		this.inicio = 0;
		this.fim = 0;
		this.tamanho = tamanho;
		this.qtdEmelento = 0;
		this.armazem = (T[])new Object[tamanho]; 

	}

	@SuppressWarnings("unchecked")
	public void insere(Object obj){
		this.armazem[this.fim] = (T) obj;
		this.fim =( this.fim+1)%this.tamanho;
		this.qtdEmelento++;
	}

	public void retira() {
		System.out.println("Excluído: " +this.armazem[this.inicio] );
		this.inicio = (this.inicio+1)%this.tamanho;
		this.qtdEmelento--;
	}

	public boolean possui(T Elem){
		for(int x = 0; x < this.qtdEmelento; x++){
			if(this.armazem[x].equals(Elem)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString(){    
		String str = "";                    
		str+= this.armazem[this.inicio];
		return str;
	}	
	
	public void imprime(){
		System.out.println(toString());
	}

	public boolean isVazia(){
		return this.qtdEmelento == 0;
	}

	public boolean isCheia(){
		return this.qtdEmelento == this.tamanho; 
	}

	public int getQtdEmelento() {
		return this.qtdEmelento;
	}

	public int getTamanho() {
		return this.tamanho;
	}

}
