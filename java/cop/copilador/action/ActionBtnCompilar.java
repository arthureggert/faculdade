package br.com.ahe.cop.copilador.action;

import java.awt.event.ActionEvent;
import java.io.StringReader;

import javax.swing.JTextPane;

import br.com.ahe.cop.copilador.gals2.LexicalError;
import br.com.ahe.cop.copilador.gals2.Lexico;
import br.com.ahe.cop.copilador.gals2.SemanticError;
import br.com.ahe.cop.copilador.gals2.Semantico;
import br.com.ahe.cop.copilador.gals2.Sintatico;
import br.com.ahe.cop.copilador.gals2.SyntaticError;
import br.com.ahe.cop.copilador.gals3.acao.SemanticRegister;
import br.com.ahe.cop.utils.MyJTextPane;
import br.com.ahe.cop.utils.StatusBar;
import br.com.ahe.cop.utils.Utils;

public class ActionBtnCompilar extends MyAbstractAction {

	private static final long serialVersionUID = 1L;

	private JTextPane mensagens;
	private MyJTextPane editor;
	private StatusBar statusBar;

	public ActionBtnCompilar( JTextPane mensagens, MyJTextPane editorTextPane, StatusBar fileName ) {
		this.mensagens = mensagens;
		this.editor = editorTextPane;
		this.statusBar = fileName;
		Utils.getInstance().setEditor(this.editor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.editor.getText().isEmpty()){
			this.mensagens.setText("nenhum programa para compilar");
		} else {
			String retorno = new String("");

			Lexico lexico = null;
			Sintatico sintatico = null;
			Semantico semantico = null; 
			SemanticRegister semanticRegister = null;

			try {
				lexico = new Lexico(new StringReader(this.editor.getText()));
				sintatico = new Sintatico();
				semanticRegister = new SemanticRegister(Utils.getInstance().getFileName(this.statusBar.getCaminhoArquivo()));
				semantico = new Semantico(semanticRegister);
				sintatico.parse(lexico, semantico);

				retorno = "Programa Copilado com sucesso!";
			} catch (LexicalError erroLexico) {
				retorno = new String(erroLexico.getMessage());
			} catch (SyntaticError erroSintatico) {
				retorno = new String(erroSintatico.getMessage());
			} catch (SemanticError erroSemantico) {
				retorno = new String(erroSemantico.getMessage());
			}

			this.mensagens.setText(retorno);
		}
	}

}
