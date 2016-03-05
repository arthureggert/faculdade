package br.com.ahe.ldp.produtor.exem1;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class pnlArmazemLocal extends JPanel{

	private static final long serialVersionUID = 1L;
	JTextArea txt;
	
	public pnlArmazemLocal(){
		this.txt = new JTextArea(""+0);
		this.add(this.txt);
		
		this.setBorder(new LineBorder(Color.black));
		
	}

	public JTextArea getTxt() {
		return this.txt;
	}

	public void setTxt(JTextArea txt) {
		this.txt = txt;
	}
	public void setTxtTexto(String texto){
		this.txt.setText(texto);
		this.repaint();
	}
}
