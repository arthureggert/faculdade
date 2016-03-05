package br.com.ahe.cop.copilador.gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CopiladorMain {
	public static void main(String[] args) {
		 try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());			
			new CopiladorApp();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}  
	}
}
