package br.com.ahe.cop.copilador.action;

import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import br.com.ahe.cop.utils.StatusBar;

public class ActionBtnNovo extends MyAbstractAction {

	private static final long serialVersionUID = 1L;

	private StatusBar bar;
	
	private JTextPane editor;
	
	private JTextPane mensagens;
	
	public ActionBtnNovo(StatusBar statusBar, JTextPane editorTextPane,	JTextPane mensagensTextPane) {
		this.bar = statusBar;
		this.editor = editorTextPane;
		this.mensagens = mensagensTextPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.editor.setText("");
		this.mensagens.setText("");
		this.bar.setCaminhoArquivo("");
		this.bar.setMsg("Não Modificado");
	}

}
