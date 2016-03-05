package br.com.ahe.cop.copilador.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextPane;

import br.com.ahe.cop.utils.MyJTextPane;
import br.com.ahe.cop.utils.StatusBar;

public class ActionBtnSalvar extends MyAbstractAction {

	private static final long serialVersionUID = 1L;

	private StatusBar status;
	
	private MyJTextPane editor;

	private JTextPane mensagem;
	
	public ActionBtnSalvar(StatusBar statusBar, MyJTextPane editorTextPane, JTextPane mensagem) {
		this.status = statusBar;
		this.editor = editorTextPane;
		this.mensagem = mensagem;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File f = null;
		JFileChooser fileChooser = new JFileChooser();

		if(this.status.getCaminhoArquivo().isEmpty()){
			
			int state = fileChooser.showSaveDialog(null);	
			if (state == JFileChooser.APPROVE_OPTION) { 
				f = fileChooser.getSelectedFile();
			}
		} else {
			f = new File(this.status.getCaminhoArquivo());
		}
		
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(this.editor.getText());
			fw.close();
			this.status.setMsg("Não Modificado");
			this.status.setCaminhoArquivo(f.getAbsolutePath());
			this.mensagem.setText("");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

}
