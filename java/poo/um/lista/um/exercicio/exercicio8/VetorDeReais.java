package br.com.ahe.poo.um.lista.um.exercicio.exercicio8;

public class VetorDeReais {

	private double[] vetor;
	
	private int totItens;
	
	public VetorDeReais(int tamanho){
		this.vetor = new double[tamanho];
		this.totItens = 0;
	}
	
	
	
	@Override
	public String toString() {
		String tmp = "";
		for (int i = 0; i < this.length(); i++) {
			if ( i != this.length()-1 ){
				tmp += this.getNumero(i) + " , "; 
			} else {
				tmp += this.getNumero(i); 
			}
		}
		
		return "VetorDeReais [ " + tmp  + " ]";
	}



	public int length() {
		return this.vetor.length;
	}
	
	public double getNumero(int possicao) {
		return this.vetor[possicao];
	}
	
	
	public void adicionaNumero(double numero){
		
		if ( this.totItens == this.vetor.length ) {
			throw new ArithmeticException("Vetor ja esta cheio!");
		}
		this.vetor[this.totItens] = numero;
		this.totItens++; 
		
	}
	
	public double multiplicaVetor(VetorDeReais outroVetor){

		double m = 0.0d;
		
		if (this.length() != outroVetor.length() ) {
			throw new ArithmeticException("Vetores de tamanhos diferentes");
		} else {
			for (int i = 0, j = this.vetor.length-1; i < this.vetor.length; i++, j--) {
				m += this.getNumero(i) * outroVetor.getNumero(j);
			}
		}
		
		return m;
		
	}
	
	public VetorDeReais criaVetorMultiplicacao(VetorDeReais outroVetor) {
		VetorDeReais novoVetor = new VetorDeReais(this.length());
		
		if (this.length() != outroVetor.length() ) {
			throw new ArithmeticException("Vetores de tamanhos diferentes");
		} else {
			for (int i = 0; i < this.length(); i++) {
				novoVetor.adicionaNumero(this.getNumero(i)/outroVetor.getNumero(i));
			}			
		}
		
		return novoVetor;
	}
	
	public int qtdPares() {
		
		int qtdPares = 0;
		
		for (int i = 0; i < this.length(); i++) {
			if( (int)this.getNumero(i) % 2  == 0 ){
				qtdPares++;
			}
		}
		return qtdPares;
	}
	
	public void inverteElementos() {
		for (int i = 0, j = this.vetor.length-1; i < this.vetor.length/2; i++, j--) {
			double tmp = this.vetor[i];
			this.vetor[i] = this.vetor[j];
			this.vetor[j] = tmp;
		}
	}
	
	public double mairDiferencaEntreValores() {
		double maiorDif = 0;
		for (int i = 0; i < this.length()-1; i++) {
			double subTmp = this.getNumero(i) - this.getNumero(i+1);
			
			if( subTmp < 0 ) {
				subTmp = subTmp * -1;
			}
			
			if ( subTmp > maiorDif ){
				maiorDif = subTmp; 
			}
		}
		return maiorDif;
	}
	
}
