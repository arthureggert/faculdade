package br.com.ahe.dataminig.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import br.com.ahe.dataminig.telas.RadicalFrame;

public class RadicaisAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		RadicalFrame frame = new RadicalFrame();
		frame.setFocusable(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

}
