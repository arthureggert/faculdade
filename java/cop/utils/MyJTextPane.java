package br.com.ahe.cop.utils;

import javax.swing.InputMap;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

public class MyJTextPane extends JTextPane{

	private static final long serialVersionUID = 1L;

	public void removeAtalho(String keyChar) {
		KeyStroke remove = KeyStroke.getKeyStroke(keyChar);
		InputMap im = this.getInputMap();
		im.put(remove, "none");	
	}

	public int getLineOfOffset(int offset) {
		Element map = getDocument().getDefaultRootElement();
		return map.getElementIndex(offset)+1;
	}

	@Override
	public String getText(int offs, int len) {
		try {
			return super.getText(offs, len);		
		} catch (BadLocationException e) {
			return "";
		}
		
	}
}