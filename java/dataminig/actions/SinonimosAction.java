package br.com.ahe.dataminig.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import br.com.ahe.dataminig.telas.SinonimosFrame;

public class SinonimosAction  extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		SinonimosFrame frame = new SinonimosFrame();
		frame.setFocusable(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

}
