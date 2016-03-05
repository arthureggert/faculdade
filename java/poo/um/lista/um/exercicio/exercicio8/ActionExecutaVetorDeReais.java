package br.com.ahe.poo.um.lista.um.exercicio.exercicio8;


public class ActionExecutaVetorDeReais {

	private VetorDeReais vetorAtual;
	
	public void criaVetor(int tamanho) {
		this.setVetorAtual(new VetorDeReais(tamanho));
	}

	public VetorDeReais getVetorAtual() {
		return this.vetorAtual;
	}

	public void setVetorAtual(VetorDeReais vetorAtual) {
		this.vetorAtual = vetorAtual;
	}
	
	
	

	
	
}
