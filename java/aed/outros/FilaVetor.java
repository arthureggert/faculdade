package br.com.ahe.aed.outros;

public class FilaVetor implements Fila {

	private int n;
	
	private int ini;
	
	private int tam;
	
	private int[] vet;	
		
	public FilaVetor(int tam) {
		this.n = 0;
		this.ini = 0;
		this.tam = tam;
		this.vet = new int[tam];
	}

	private void concatenaAux(FilaVetor f1,FilaVetor f2) throws Exception{
		if(f2.n > 0){
			int p = f2.ini;
			int fim = (f2.ini+f2.n)%f2.tam;
			do{
				f1.insere(f2.vet[p]);			
				p = (p+1)%f2.tam;
			}while(p!=fim);
		}
	}
	
	public FilaVetor concatena(FilaVetor f2){			
		FilaVetor f = new FilaVetor(this.tam+f2.tam);						
		try{	
			concatenaAux(f, this);
			concatenaAux(f, f2);
		}catch (Exception e) {	
			System.err.println(e.getMessage());
		}		
		return f;
	}
	
	public FilaVetor merge(FilaVetor f2){		
		int tamanho = this.n+f2.n;
		FilaVetor f = new FilaVetor(tamanho);		
		if(tamanho > 0){			
			try{				
				int p1 = this.ini;												
				int p2 = f2.ini;							
				while(tamanho != f.n){
					if(this.n*2 > f.n){					
						f.insere(this.vet[p1]);			
						p1 = (p1+1)%this.tam;
					}
					if(f2.n*2 > f.n){
						f.insere(f2.vet[p2]);			
						p2 = (p2+1)%f2.tam;						
					}					
				}						
			}catch (Exception e) {				
				System.err.println(e.getMessage());
			}
		}						
		return f;
	}
	
	@Override
	public String toString(){
		String str = "";					
		if(this.n > 0){
			int p = this.ini;
			int fim = (this.ini + this.n)%this.tam;			
			do{
				str += this.vet[p]+" ";			
				p = (p+1)%this.tam;
			}while( p != fim);
		}		
		return str;
	}	
	
	@Override
	public void insere(int v) throws Exception {		
		int fim;
		if(this.n==this.tam){
			throw new Exception("ERRO: a capacidade da  fila estourou!");
		} else {
			fim = (this.ini + this.n)%this.tam;
			this.vet[fim] = v;
			this.n++;
		}
	}

	@Override
	public int retira() throws Exception {
		int v;		
		if(vazia()){
			throw new Exception("ERRO: fila vazia!");
		} else {
			v = this.vet[this.ini];
			this.ini = (this.ini+1)%this.tam;
			this.n--;
			return v;
		}
	}
	
	@Override
	public boolean vazia() {
		return this.n==0;
	}

	@Override
	public void libera() {
		this.n = 0;		
		this.ini = 0;
	}
	
	public void imprimeImpares() {
		String strImpares = "";
		int totalInpares = 0;
		if(this.n > 0){
			int p = this.ini;
			int fim = (this.ini + this.n)%this.tam;			
			do{
				int numero = this.vet[p];
				if (numero%2!=0) {
					strImpares += numero+" ";
					totalInpares += numero; 
				}
				p = (p+1)%this.tam;
			}while( p != fim);
		}		
		System.out.println(strImpares + "" + totalInpares);
	}
}
