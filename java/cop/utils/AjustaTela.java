package br.com.ahe.cop.utils;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class AjustaTela {
	
	public ComponentListener compAjustaTelaAlturaLargura(final JPanel panel, final JScrollPane scrollPane, final JTextPane textPane) {
		return new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent eventoAlteracaoLarguraAltura) {
				int height = panel.getHeight() - 15;
				int width = panel.getWidth() - 15;
				scrollPane.setSize(new Dimension(width, height));
				textPane.setSize(new Dimension(width, panel.getHeight()));
			}
		};
	}
	
	public ComponentListener compAjustaTelaLargura(final JPanel panel, final JScrollPane scrollPane, final JTextPane textPane) {
		return new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent eventoAlteracaoLargura) {
				int width = panel.getWidth() - 15;
				int height = scrollPane.getHeight();
				scrollPane.setSize(width, height);
				textPane.setSize(width, height);
			}
		};
	}

}
