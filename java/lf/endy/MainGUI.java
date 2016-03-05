package br.com.ahe.lf.endy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.InvalidAttributeValueException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.text.BadLocationException;



public class MainGUI {

	private JFrame frmAutomatoFinito;
	final JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmAutomatoFinito.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frmAutomatoFinito = new JFrame();
		this.frmAutomatoFinito.setAlwaysOnTop(true);
		this.frmAutomatoFinito.setTitle("Automato Finito");
		this.frmAutomatoFinito.setSize(513, 334);
		this.frmAutomatoFinito.setResizable(false);
		this.frmAutomatoFinito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frmAutomatoFinito.getContentPane().setLayout(null);
		
		final JTextArea textAreaPrincipal = new JTextArea();
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		textAreaPrincipal.setBorder(border);
		JScrollPane scrollBar = new JScrollPane(textAreaPrincipal);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setBounds(10, 11, 487, 159);
		this.frmAutomatoFinito.getContentPane().add(scrollBar);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int quant = textAreaPrincipal.getLineCount();
				for (int i = 0; i < quant; i++) {
					try {
						int inicio = textAreaPrincipal.getLineStartOffset(i);
						int fim = textAreaPrincipal.getLineEndOffset(i);
						
						String linha = textAreaPrincipal.getText(inicio,fim-inicio);
						MainGUI.this.textArea.setText(MainGUI.this.textArea.getText()+Leitura(linha, i));
						
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
				
				
			}
		});
		btnAnalizar.setBounds(10, 181, 100, 23);
		this.frmAutomatoFinito.getContentPane().add(btnAnalizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaPrincipal.setText("");
				MainGUI.this.textArea.setText("");
			}
		});
		btnLimpar.setBounds(120, 181, 100, 23);
		this.frmAutomatoFinito.getContentPane().add(btnLimpar);
		
		JButton btnEquipe = new JButton("Equipe");
		btnEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Arthur Henrique Eggert/Endy Michel Boebel");
				
			}
		});
		btnEquipe.setBounds(228, 181, 100, 23);
		this.frmAutomatoFinito.getContentPane().add(btnEquipe);
		
		

		Border border2 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		this.textArea.setBorder(border2);
		JScrollPane scrollBar2 = new JScrollPane(this.textArea);
		scrollBar2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollBar2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar2.setBounds(10, 210, 487, 86);
		this.frmAutomatoFinito.getContentPane().add(scrollBar2);
		
	}
	
	private static String Leitura(String valor,int linha) {
		AutomatoFinito teste = new AutomatoFinito();
		String [] palavras = valor.split(" ");
		String temp = "";
		linha +=1;
		for (String string : palavras) {
			String aux = "";
			aux = string.replaceAll("\\n", "");
			
			if(aux != ""){
				try {
					if (teste.leituraSimbolos(aux.toUpperCase())){
						temp += aux + " Palavra aceita" + " Linha "+ linha + " Reconhecimento " + teste.getSequencia() + "\n";
					} else {
						temp += aux + " Palavra n�o aceita" + " Linha "+ linha + teste.getSequencia() + "\n";
					}
				} catch (InvalidAttributeValueException e) {
					temp += aux + " Caracter Invalido" + " Linha " + linha+teste.getSequencia() + "\n";
				}
			}
		}
		return temp;
		
	}
}
