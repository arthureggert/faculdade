package br.com.ahe.cop.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel msg;
	private JLabel caminhoArquivo;
	
	public StatusBar() {
		
	    setLayout(new BorderLayout());
	    setPreferredSize(new Dimension(10, 23));

	    add(this.msg = new JLabel("N�o Modificado"), BorderLayout.WEST);
	    add(this.caminhoArquivo = new JLabel(), BorderLayout.EAST);
	    setBackground(SystemColor.control);
	  }
	
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo.setText(caminhoArquivo);
	}
	
	public String getCaminhoArquivo() {
		return this.caminhoArquivo.getText();
	}
	
	public void setMsg(String msg) {
		this.msg.setText(msg);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	    int y = 0;
	    g.setColor(new Color(156, 154, 140));
	    g.drawLine(0, y, getWidth(), y);
	    y++;
	    g.setColor(new Color(196, 194, 183));
	    g.drawLine(0, y, getWidth(), y);
	    y++;
	    g.setColor(new Color(218, 215, 201));
	    g.drawLine(0, y, getWidth(), y);
	    y++;
	    g.setColor(new Color(233, 231, 217));
	    g.drawLine(0, y, getWidth(), y);

	    y = getHeight() - 3;
	    g.setColor(new Color(233, 232, 218));
	    g.drawLine(0, y, getWidth(), y);
	    y++;
	    g.setColor(new Color(233, 231, 216));
	    g.drawLine(0, y, getWidth(), y);
	    y = getHeight() - 1;
	    g.setColor(new Color(221, 221, 220));
	    g.drawLine(0, y, getWidth(), y);

	  }
}