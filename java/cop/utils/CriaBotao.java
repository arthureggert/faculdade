package br.com.ahe.cop.utils;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import br.com.ahe.cop.copilador.action.ActionBtnAbrir;
import br.com.ahe.cop.copilador.action.ActionBtnColar;
import br.com.ahe.cop.copilador.action.ActionBtnCompilar;
import br.com.ahe.cop.copilador.action.ActionBtnCopiar;
import br.com.ahe.cop.copilador.action.ActionBtnEquipe;
import br.com.ahe.cop.copilador.action.ActionBtnGerarCodigo;
import br.com.ahe.cop.copilador.action.ActionBtnNovo;
import br.com.ahe.cop.copilador.action.ActionBtnRecortar;
import br.com.ahe.cop.copilador.action.ActionBtnSalvar;
import br.com.ahe.cop.copilador.action.MyAbstractAction;

public class CriaBotao {
	
	private MyAbstractAction action;
	
	public JButton btnNovo(StatusBar statusBar, JTextPane mensagensTextPane, JTextPane editorTextPane) {
		JButton btnNovo;
		btnNovo = new JButton("<html><center>Novo<br>[CTRL+N]</center></html>");
		btnNovo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK), "novo");
		this.action = new ActionBtnNovo(statusBar,editorTextPane,mensagensTextPane);
		btnNovo.getActionMap().put("novo", this.action);
		btnNovo.addActionListener(this.action);
		btnNovo.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnNovo2.png"));
		btnNovo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnNovo.setBounds(12, 0, 69, 65);
		return btnNovo;
	}
	
	public JButton btnAbrir(MyJTextPane editor, JTextPane mensagensTextPane, StatusBar status){
		JButton btnAbrir = new JButton("<html><center>Abrir<br>[CTRL+A]</center></html>");
		btnAbrir.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK), "abrir");
		this.action = new ActionBtnAbrir(editor,mensagensTextPane,status);
		btnAbrir.getActionMap().put("abrir", this.action);
		btnAbrir.addActionListener(this.action);
		btnAbrir.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnOpen.png" ));
		btnAbrir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAbrir.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnAbrir.setBounds(93, 0, 69, 65);
		return btnAbrir;
	}
		
	public JButton btnSalvar(StatusBar statusBar, MyJTextPane editorTextPane, JTextPane mensagensTextPane) {
		JButton btnSalvar = new JButton("<html><center>Salvar<br>[CTRL+S]</center></html>");
		btnSalvar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "salvar");
		this.action = new ActionBtnSalvar(statusBar,editorTextPane,mensagensTextPane);
		btnSalvar.getActionMap().put("salvar", this.action);
		btnSalvar.addActionListener(this.action);
		btnSalvar.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnSave.png"));
		btnSalvar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnSalvar.setBounds(174, 0, 69, 65);
		return btnSalvar;
	}
	
	public JButton btnCopiar(MyJTextPane editorTextPane) {
		JButton btnCopiar = new JButton("<html><center>Copiar<br>[CTRL+C]</center></html>");
		btnCopiar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK), "copiar");
		this.action = new ActionBtnCopiar(editorTextPane);
		btnCopiar.getActionMap().put("copiar", this.action);
		btnCopiar.addActionListener(this.action);
		btnCopiar.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnCopy.png"));
		btnCopiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCopiar.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnCopiar.setBounds(255, 0, 69, 65);
		return btnCopiar;
	}
	
	public JButton btnColar(MyJTextPane editorTextPane){
		JButton btnColar = new JButton("<html><center>Colar<br>[CTRL+V]</center></html>");
		btnColar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK), "colar");
		this.action = new ActionBtnColar(editorTextPane);
		btnColar.getActionMap().put("colar", this.action);
		btnColar.addActionListener(this.action);
		btnColar.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnPaste.png"));
		btnColar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnColar.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnColar.setBounds(336, 1, 69, 65);
		return btnColar;
	}
	
	public JButton btnRecortar(MyJTextPane editorTextPane){
		JButton btnRecortar = new JButton("<html><center>Recortar<br>[CTRL+X]</center></html>");
		btnRecortar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK), "recortar");
		this.action = new ActionBtnRecortar(editorTextPane);
		btnRecortar.getActionMap().put("recortar", this.action);
		btnRecortar.addActionListener(this.action);
		btnRecortar.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnCut.png"));
		btnRecortar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRecortar.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnRecortar.setBounds(417, 0, 69, 65);
		return btnRecortar;
	}
	
	public JButton btnCopilar( JTextPane mensagensTextPane, MyJTextPane editorTextPane, StatusBar fileName ) {
		JButton btnCopilar = new JButton("<html><center>Copilar<br>[F8]</center></html>");
		this.action = new ActionBtnCompilar(mensagensTextPane,editorTextPane, fileName);
		btnCopilar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "compilar");
		btnCopilar.getActionMap().put("compilar", this.action);
		btnCopilar.addActionListener(this.action);
		btnCopilar.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnCopile.png"));
		btnCopilar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCopilar.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnCopilar.setBounds(498, 0, 69, 65);
		return btnCopilar;
	}
	
	public JButton btnGerar(JTextPane mensagensTextPane, MyJTextPane editorTextPane, StatusBar fileName) {
		JButton btnGerar = new JButton("<html><center>GerarCód.<br>[F9]</center></html>");
		this.action = new ActionBtnGerarCodigo(mensagensTextPane,editorTextPane, fileName);
		btnGerar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "gerar");
		btnGerar.getActionMap().put("gerar", this.action);
		btnGerar.addActionListener(this.action);
		btnGerar.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnBuildCode.png"));
		btnGerar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGerar.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnGerar.setBounds(579, 0, 69, 65);
		return btnGerar;
	}
	
	public JButton btnEquipe( JTextPane mensagensTextPane ) {
		JButton btnEquipe = new JButton("<html><center>Equipe<br>[F1]</center></html>");
		this.action = new ActionBtnEquipe(mensagensTextPane);
		btnEquipe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "equipe");
		btnEquipe.getActionMap().put("equipe", this.action);
		btnEquipe.addActionListener(this.action);
		btnEquipe.setVerticalAlignment(SwingConstants.TOP);
		btnEquipe.setIcon(new ImageIcon("/br/com/ahe/cop/copilador/btnTeam.png"));
		btnEquipe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEquipe.setHorizontalTextPosition(SwingConstants.CENTER);	
		btnEquipe.setBounds(660, 0, 69, 65);
		return btnEquipe;
	}
	
}