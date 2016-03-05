package br.com.ahe.poo.um.lista.um.exercicio.exercicio6;

public class MainConsole {

	public static void main(String[] args) {
		ExpressaoAritmetica exp = new ExpressaoAritmetica("(a+10)\\(23*(10.5-b)-2.59\\(b*a))");
		ActionValidaExpressaoAritmetica action = new ActionValidaExpressaoAritmetica();
		action.setExpression(exp);
		action.run();
	}
}
