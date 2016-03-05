package br.com.ahe.cop.copilador.gals2;

import java.util.Stack;

import br.com.ahe.cop.utils.Utils;

@SuppressWarnings( "deprecation" )
public class Sintatico implements Constants
{
	private Stack<Integer> stack = new Stack<Integer>();
	private Token currentToken;
	private Token previousToken;
	private Lexico scanner;
	private Semantico semanticAnalyser;

	private static final boolean isTerminal(int x)
	{
		return x < FIRST_NON_TERMINAL;
	}

	private static final boolean isNonTerminal(int x)
	{
		return x >= FIRST_NON_TERMINAL && x < FIRST_SEMANTIC_ACTION;
	}

	private static final boolean isSemanticAction(int x)
    {
        return x >= FIRST_SEMANTIC_ACTION;
    }

	private boolean step() throws LexicalError, SyntaticError, SemanticError  {
		if (this.currentToken == null) {
			int pos = 0;
			if (this.previousToken != null){
				pos = this.previousToken.getPosition()+this.previousToken.getLexeme().length();
			}
			this.currentToken = new Token(DOLLAR, "$", pos);
		}

		int x = this.stack.pop().intValue();
		int a = this.currentToken.getId();

		if (x == EPSILON){
			return false;
		} else if (isTerminal(x)) {
			if (x == a) {
				if (this.stack.empty()){
					return true;
				} else {
					this.previousToken = this.currentToken;
					this.currentToken = this.scanner.nextToken();
					return false;
				}
			} else {
				verificaErro(x);
			}
		}
		else if (isNonTerminal(x)) {
			if (pushProduction(x, a)){
				return false;
			} else {
				verificaErro(x);
			}
		} else { 
			isSemanticAction(x);
			this.semanticAnalyser.executeAction(x-FIRST_SEMANTIC_ACTION, this.previousToken);
			return false;
		}
		return false;
	}

	private void verificaErro(int x) throws LexicalError, SyntaticError {
    	if(!Utils.getInstance().verificaPalavaraReservada(this.currentToken)){
    		throw new LexicalError(Constants.SCANNER_ERROR[32], this.currentToken.getPosition(), Utils.getInstance().getLinha(this.currentToken.getPosition()), "");
    	} else {
    		String lexema = this.currentToken.getLexeme();
    		String classe = Utils.getInstance().getClasse(this.currentToken);
    		String nome = classe.equalsIgnoreCase("identificador") ? classe + "( " + lexema + " )" : lexema;
			throw new SyntaticError(PARSER_ERROR[x], this.currentToken.getPosition(), Utils.getInstance().getLinha(this.currentToken.getPosition()), nome );
    	}

	}

	private boolean pushProduction(int topStack, int tokenInput)
	{
		int p = PARSER_TABLE[topStack-FIRST_NON_TERMINAL][tokenInput-1];
		if (p >= 0)
		{
			int[] production = PRODUCTIONS[p];
			//empilha a produ��o em ordem reversa
			for (int i=production.length-1; i>=0; i--)
			{
				this.stack.push(new Integer(production[i]));
			}
			return true;
		}
		else
			return false;
	}

	public void parse(Lexico scanner, Semantico semanticAnalyser) throws LexicalError, SyntaticError, SemanticError
	{
		this.scanner = scanner;
		this.semanticAnalyser = semanticAnalyser;

		this.stack.clear();
		this.stack.push(new Integer(DOLLAR));
		this.stack.push(new Integer(START_SYMBOL));

		this.currentToken = scanner.nextToken();

		while ( ! step() )
			;
	}
}
