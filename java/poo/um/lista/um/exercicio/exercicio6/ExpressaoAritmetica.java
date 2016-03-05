package br.com.ahe.poo.um.lista.um.exercicio.exercicio6;

public class ExpressaoAritmetica {

	private String expressao;
		
	/**
	 * Method to get the expression 
	 * @return the expression
	 **/
	public String getExpressao() {
		return this.expressao;
	}

	/**
	 * The set method for the object ExpressaoAritmetica
	 * @param expressao
	 **/
	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	/**
	 * Constructor of the object ExpressaoAritmetica
	 * @param a String who contains the expression
	 **/
	public ExpressaoAritmetica(String exp) {
		setExpressao(exp);
	}
	
	public char[] toCharArray(){
		return this.expressao.toCharArray();
	}
	
}
