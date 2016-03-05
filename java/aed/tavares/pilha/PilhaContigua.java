package br.com.ahe.aed.tavares.pilha;

public class PilhaContigua {
	
	private int[] pilha;
	private int tamanho;
	private int topo;
	
	public PilhaContigua(int tamanho){
		this.tamanho = tamanho;
		this.topo = -1;
		this.pilha = new int[tamanho];
	}
	
	public boolean empilha(int elemento){
		if (this.topo < this.tamanho -1){
			this.topo++;
			this.pilha[this.topo] = elemento;
			return true;
		} else {
			return false;
		}
	}
	
	public int desempilha() throws Exception{
		if (this.topo > -1){
			int v = this.pilha[this.topo];
			this.topo--;
			return v;
		} else {
			throw new Exception("Pilha não pode ser vazia");
		}
	}
	
	

}
