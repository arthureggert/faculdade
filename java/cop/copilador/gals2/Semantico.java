package br.com.ahe.cop.copilador.gals2;

import br.com.ahe.cop.copilador.gals3.acao.SemanticAction;
import br.com.ahe.cop.copilador.gals3.acao.SemanticRegister;

@SuppressWarnings( "deprecation" )
public class Semantico implements Constants {

	private SemanticRegister semanticRegister;
	private SemanticAction semanticAction;

	public Semantico(SemanticRegister semanticRegister) {
		this.semanticRegister = semanticRegister;
		this.semanticAction = new SemanticAction();
	}

	public void executeAction(int action, Token token)	throws SemanticError {
		System.out.println("ACTION = "+action+", Token = "+token);
		this.semanticAction.getAction(action, this.semanticRegister, token);
	}

}
