package br.com.ahe.dataminig.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import br.com.ahe.dataminig.telas.StopwordFrame;

public class StopwordAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		StopwordFrame frame = new StopwordFrame();
		frame.setFocusable(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

}
