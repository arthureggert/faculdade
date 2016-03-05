package br.com.ahe.dataminig.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import constants.AConstants;

public class CancelarAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private int opcao;

	private JFrame parrent;
	
	public CancelarAction(int opcao, Object ... values ) {
		this.opcao = opcao;
		this.parrent  = (JFrame) values[0];
	}
	
	public CancelarAction() {
		this.opcao = AConstants.EXIT;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(this.opcao == AConstants.HIDE){
			this.parrent.setVisible(false);
		} else{
			System.exit(AConstants.EXIT);			
		}
	}
	
}
