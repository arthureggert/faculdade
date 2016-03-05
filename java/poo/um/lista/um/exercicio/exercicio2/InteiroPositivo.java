package br.com.ahe.poo.um.lista.um.exercicio.exercicio2;

public class InteiroPositivo {

	private int intX;
	
	public InteiroPositivo(int numero) throws Exception{
		setValor(numero);
	}

	public void setValor(int numero) throws Exception{
		if(numero > 0){
			this.intX = numero;
		} else {
			throw new Exception("O Numero informando não é possitivo");
		}
	}
	
	public int getValor(){
		return this.intX;
	}
	
	public int multiplica(InteiroPositivo outro){
		int retorno = 0;
		for(int x = 1; x <= outro.getValor();x++ ){
		 retorno += getValor();
		}
		return retorno;
	}
	
	public int fatorial(){
		int retorno = 1;
		for(int x = 2 ; x <= getValor() ; x++){
			retorno *= x;
		}
		return retorno;
	}
		
	/**
	 * M�todo para calculo da s�rie de Fibonacci, que � definido pela soma dos 2 ultimos
	 * n�meros
	 **/
	public String imprimeFibonacci(int numElementos){
		String retorno = new String("");
		int ant = 0;
		int ini = 1;
		int prox = 0;
		for(int i = 1; i <= numElementos; i++){
			if (i != numElementos){
				retorno += ini + " , ";
			} else {
				retorno += ini;
			}
			prox = ant+ini;
			ant = ini;
			ini = prox;
		}
		return retorno;
	}
	
	
	/**
	 * M�todo para calculo da quantidade e quais os divisores de um numero
	 **/
	public String getQtdDivisores(int numero){
		String retorno = new String("Os divisores s�o: ");
		int numDivisores = 0;
		for (int i = 1; i <= numero; i++) {
			if(numero % i == 0){
				if(i == numero){
					retorno += i;
				} else {
					retorno += i + " , ";
				}
				numDivisores++;
			}
		}
		retorno += "\nNumero de Divisores �: " + numDivisores;
		return retorno;
	}
	
}
