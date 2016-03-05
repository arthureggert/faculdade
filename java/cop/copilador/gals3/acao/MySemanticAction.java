package br.com.ahe.cop.copilador.gals3.acao;

import br.com.ahe.cop.copilador.gals2.SemanticError;


public interface MySemanticAction {

	void executeSemanticAction(Object... objects) throws SemanticError ;
}
