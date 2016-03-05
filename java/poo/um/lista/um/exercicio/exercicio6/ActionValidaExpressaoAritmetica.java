package br.com.ahe.poo.um.lista.um.exercicio.exercicio6;
/**
 * Class to analyzing and validate a arithmetic expression 
 * @author Arthur Henrique Eggert
 */

public class ActionValidaExpressaoAritmetica {
	
	private ExpressaoAritmetica expression;
	
	/**
	 * Method to validated the expression;
	 */
	public void run(){
		
		int qtdDiv = 0;
		int qtdMul = 0;
		int qtdPar = 0;
		int counter = 0;
		char firstOper = 0 ;
		boolean first = true;
		int primOper = 0;
		
		for (char tmp : getExpression().toCharArray()) {
			counter++;
			if( (first) && (tmp == '\\' || tmp == '+' || tmp == '-' || tmp == '*') ){
				primOper = counter;
				first= false;
				firstOper = tmp;
			}
			
			
			switch (tmp) {
			
			case '*':
				qtdMul++;
				break;
			
			case '\\':
				qtdDiv++;
				break;	
			
			case '(':
				qtdPar++;
				break;
			
			case ')':
				qtdPar++;

			}
		}
		
		String ret = "Quantidade incorreta de parênteses";
		
		if ( qtdPar % 2 == 0 ) {
			ret = "Qtd correta de parênteses\n";
		}
		ret += qtdMul + " de Multiplicações" + qtdDiv + "de divisões\n" + "Primeiro operador" +"("+ firstOper + ")" + "na possição " + primOper ;
		
		System.out.println(ret);
		
	}
	
	/**
	 * Method to set a expression to be validated
	 * @param the expression to be validated
	 */
	public void setExpression(ExpressaoAritmetica expression) {
		this.expression = expression;
	}
	
	
	/**
	 * Method to get the expression
	 * @return the arithmetic expression
	 */
	public ExpressaoAritmetica getExpression() {
		return this.expression;
	}

}

