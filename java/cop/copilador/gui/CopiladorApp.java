package br.com.ahe.cop.copilador.gui;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.com.ahe.cop.utils.AjustaTela;
import br.com.ahe.cop.utils.CriaBotao;
import br.com.ahe.cop.utils.MyJTextPane;
import br.com.ahe.cop.utils.NumeredBorder;
import br.com.ahe.cop.utils.StatusBar;

public class CopiladorApp {

	private JFrame frmCopiladorArthur;
	private JPanel barraFerramentas;
	private JPanel mensagens;
	private JPanel editor;
	private CriaBotao data;
	private MyJTextPane editorTextPane;
	private JTextPane mensagensTextPane;
	private JScrollPane editorScrollPane;
	private JScrollPane mensagensScrollPane;
	private JPanel status;
	private StatusBar statusBar;
	private AjustaTela ajustaTela;
	
	public CopiladorApp() {
		inicializa();
	}
	
	private void inicializa() {
		this.data = new CriaBotao();
		this.ajustaTela = new AjustaTela();
		this.frmCopiladorArthur = new JFrame();
		this.frmCopiladorArthur.setTitle("Copilador");
		this.frmCopiladorArthur.setBounds(100, 100, 784, 641);
		this.frmCopiladorArthur.setVisible(true);
		this.frmCopiladorArthur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		this.editor = new JPanel();
		this.editor.setLayout(null);
		this.editor.setBorder(null);
		
		
		this.editorTextPane = new MyJTextPane();
		this.editorTextPane.setBorder(new NumeredBorder());
		this.editorTextPane.removeAtalho("control A");
		this.editorTextPane.removeAtalho("control C");
		this.editorTextPane.removeAtalho("control V");
		this.editorTextPane.removeAtalho("control X");
		this.editorScrollPane = new JScrollPane(this.editorTextPane);
		this.editorScrollPane.setBounds(12, 12, 726, 400);
		this.editorScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.editorScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.editor.add(this.editorScrollPane);
		this.editor.addComponentListener(this.ajustaTela.compAjustaTelaAlturaLargura(this.editor, this.editorScrollPane, this.editorTextPane));
		this.editorTextPane.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				CopiladorApp.this.statusBar.setMsg("Modificado");
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				CopiladorApp.this.statusBar.setMsg("Modificado");
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {

			}
		});
		
		this.mensagens = new JPanel();
		this.mensagens.setBorder(null);
		this.mensagens.setLayout(null);
		
		this.mensagensTextPane = new JTextPane();
		this.mensagensTextPane.setEditable(Boolean.FALSE);
		this.mensagensScrollPane = new JScrollPane(this.mensagensTextPane);
		this.mensagensScrollPane.setBounds(12, 12, 726, 100);
		this.mensagensScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.mensagensScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.mensagens.add(this.mensagensScrollPane);
		this.mensagens.addComponentListener(this.ajustaTela.compAjustaTelaLargura(this.mensagens,this.mensagensScrollPane,this.mensagensTextPane));
	
		this.status = new JPanel();
		this.status.setLayout(new BorderLayout(0, 0));
		this.statusBar = new StatusBar();
		this.status.add(this.statusBar);
		
		this.barraFerramentas = new JPanel();
		this.barraFerramentas.setBorder(null);
		this.barraFerramentas.setLayout(null);
		this.barraFerramentas.add(this.data.btnNovo(this.statusBar,this.mensagensTextPane,this.editorTextPane));
		this.barraFerramentas.add(this.data.btnAbrir(this.editorTextPane,this.mensagensTextPane,this.statusBar));
		this.barraFerramentas.add(this.data.btnSalvar(this.statusBar,this.editorTextPane,this.mensagensTextPane));
		this.barraFerramentas.add(this.data.btnCopiar(this.editorTextPane));
		this.barraFerramentas.add(this.data.btnRecortar(this.editorTextPane));
		this.barraFerramentas.add(this.data.btnColar(this.editorTextPane));
		this.barraFerramentas.add(this.data.btnCopilar(this.mensagensTextPane, this.editorTextPane, this.statusBar));
		this.barraFerramentas.add(this.data.btnGerar(this.mensagensTextPane, this.editorTextPane, this.statusBar));
		this.barraFerramentas.add(this.data.btnEquipe(this.mensagensTextPane));

		criaPanels();
	}

	private void  criaPanels() {

		GroupLayout groupLayout = new GroupLayout(this.frmCopiladorArthur.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(this.status, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
						.addComponent(this.mensagens, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.editor, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.barraFerramentas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.barraFerramentas, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.editor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.mensagens, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.status, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		this.frmCopiladorArthur.getContentPane().setLayout(groupLayout);
		
	}
}
