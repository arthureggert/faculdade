package br.com.ahe.cop.copilador.action;

import java.awt.event.ActionEvent;

import javax.swing.JTextPane;


public class ActionBtnEquipe extends MyAbstractAction {

	private static final long serialVersionUID = 1L;
	
	private JTextPane mensagens; 

	public ActionBtnEquipe(JTextPane mensagensTextPane) {
		this.mensagens = mensagensTextPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msgAtual = this.mensagens.getText();
		this.mensagens.setText( (msgAtual.isEmpty() ? "" : msgAtual + "\n") + "Copilador Desenvolvido Por: Arthur Henrique Eggert");

	}
}
