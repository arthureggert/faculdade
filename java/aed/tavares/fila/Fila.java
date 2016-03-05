package br.com.ahe.aed.tavares.fila;

public class Fila {

	private int[] lista;
	private int tamanho;
	private int inicio;
	private int fim;
	private int limInferior;
	private int limSuperior;
	
	public Fila(int tam){
		this.tamanho = tam;
		this.lista = new int[this.tamanho];
		this.inicio = -1;
		this.fim = -1;
		this.limSuperior = 0;
		this.limInferior = 0;
	}
	
	public boolean insereFila(int elemento){
		if(isVazia()){
			this.inicio = 0;
			this.fim = 0;
			this.lista[this.inicio] = elemento;
			return true;
		}
		if(isCheia()){
			return false;
		} else {
			if (this.fim == this.limSuperior){
				this.fim = this.limInferior;
			} else {
				this.fim++;
			}
			this.lista[this.fim] = elemento;
			return true;
		}
	}
	
	private boolean isCheia() {
		if(this.inicio == this.limSuperior && this.fim == this.limSuperior || this.fim == this.inicio-1){
			return true;
		}
		return false;
	}

	public boolean isVazia(){
		if (this.inicio == -1){
			return true;
		}
		return false;
	}
}
