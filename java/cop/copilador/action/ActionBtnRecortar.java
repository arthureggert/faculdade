package br.com.ahe.cop.copilador.action;

import java.awt.event.ActionEvent;

import br.com.ahe.cop.utils.MyJTextPane;

public class ActionBtnRecortar extends MyAbstractAction {

	private static final long serialVersionUID = 1L;
	
	private MyJTextPane editor;

	public ActionBtnRecortar(MyJTextPane editorTextPane) {
		this.editor = editorTextPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.editor.cut();
	}

}
