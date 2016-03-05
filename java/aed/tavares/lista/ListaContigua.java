package br.com.ahe.aed.tavares.lista;

public class ListaContigua {

	private int[] lista;
	private int tamanho;
	private int nElementos;
	
	public ListaContigua(int tamanho){
		this.tamanho = tamanho;
		this.lista = new int[tamanho];
		this.nElementos = 0;
	}
		
	public int getTamanho() {
		return this.tamanho;
	}

	public boolean insere(int elemento){
		if(this.nElementos < this.tamanho){
			this.lista[this.nElementos] = elemento;
			this.nElementos ++;
			return true;
		}
		return false;
	}
	
	public int pesquisa(int elemento){
		for (int i = 0; i < this.nElementos; i++) {
			if(this.lista[i] == elemento){
				return i;
			}
		}
		return -1;
	}
	
	public void imprime(){
		String strRet = "";
		for (int i = 0; i < this.nElementos; i++) {
			
			strRet += String.valueOf(this.lista[i]) +" " ;
		}
		System.out.println(strRet);
	}
	
	public boolean retira(int elemento){
		if(pesquisa(elemento) == -1){
			return false;	
		}
		int retira = pesquisa(elemento);
		
		if (retira == this.nElementos){
			this.nElementos--;
		} else {
			for (int i = retira; i < this.nElementos; i++) {
				this.lista[i]=this.lista[i+1];
			}
			this.nElementos--;
		}		
		return true;		
	}
	
	public void insereOrdem(int elemento){
		if(this.nElementos < this.tamanho){
			for (int i = 0; i < this.tamanho; i++) {
				if(elemento > this.lista[i]){
					int temp = this.lista[i];
					this.lista[i] = elemento;
					elemento = temp;
				} 
			}
			this.nElementos++;
		}
	}

	public void inverteLista(){
		for (int i = 0, j = this.nElementos-1; i < this.nElementos; i++, j--) {
			if(this.lista[i] > this.lista[j]){
				int temp = this.lista[i];
				this.lista[i] = this.lista[j];
				this.lista[j] = temp;
			}
		}
	}
	
	public void excluiDuplicados(){
		for (int i = 0; i < this.nElementos; i++) {
			for (int j = i+1; j < this.nElementos; j++) {
				if(this.lista[i] == this.lista[j]){
					this.retira(this.lista[j]);
				}
			}
		}
	}
	public void ordenaLista(){
		int fim = this.nElementos-1;
		for (int i = 0; i < this.nElementos; i++) {
			if(this.lista[i] > this.lista[fim]){
				int temp = this.lista[i];
				this.lista[i] = this.lista[fim];
				this.lista[fim] = temp;
			} 
		}
	}
	
	public ListaContigua clonaLista(){
		ListaContigua listaClonada = new ListaContigua(this.tamanho);
		for (int i = 0; i < this.nElementos; i++) {
			listaClonada.insere(this.lista[i]);
		}
		return listaClonada;
	}
	
	public int pesquisaIndice(int indice){
		for (int i = 0; i < this.nElementos; i++) {
			if(indice == i){
				return this.lista[i];
			} 
		}
		return 0;
	}
}
