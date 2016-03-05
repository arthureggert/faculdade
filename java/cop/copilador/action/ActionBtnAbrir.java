package br.com.ahe.cop.copilador.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextPane;

import br.com.ahe.cop.utils.MyJTextPane;
import br.com.ahe.cop.utils.StatusBar;


public class ActionBtnAbrir extends MyAbstractAction {

	private static final long serialVersionUID = 1L;
	
	private MyJTextPane editor;
	private JTextPane mensagens;
	private StatusBar status;
	
	public ActionBtnAbrir(MyJTextPane editor, JTextPane mensagens, StatusBar status) {
		this.editor = editor;
		this.mensagens = mensagens;
		this.status = status;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		int state = fileChooser.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION ) {
			File f = fileChooser.getSelectedFile();	
			String temp = "";

			try (FileReader fr = new FileReader(f)){
				int i = fr.read(); 
				while (i!=-1) {
					temp+=((char)i); 
					i = fr.read();
				} 
				fr.close();
			} catch (FileNotFoundException e1) {		
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			this.editor.setText(temp);
			this.mensagens.setText("");
			this.status.setMsg("Não Modificado");
			this.status.setCaminhoArquivo(fileChooser.getSelectedFile().getAbsolutePath());
			
		}

	}

}
