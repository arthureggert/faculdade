package br.com.ahe.poo.um.lista.um.exercicio.exercicio8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUIApp {

	private JFrame frmVetordeReais;
	private JTextField txtFieldValorAddVetor;
	private JTextArea textAreaResultados;
	private ActionExecutaVetorDeReais action; 

	public static void main(String[] args) {
		new GUIApp();
	}

	public GUIApp() {
		this.action = new ActionExecutaVetorDeReais();
		initialize();
	}

	private void initialize() {
		
		createJFrame();
		
		JButton btnCriaVetor = new JButton("Cria Vetor");
		btnCriaVetor.addActionListener(alBtnCriaVetor());
		
		JButton btnArmazenavetor = new JButton("Armazena");
		btnArmazenavetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnMultiplica = new JButton("Multiplica");
		
		JButton btnDivide = new JButton("Divide");
		
		JLabel lbNumero = new JLabel("Numero:");
		
		this.txtFieldValorAddVetor = new JTextField();
		this.txtFieldValorAddVetor.setColumns(10);
		
		this.textAreaResultados = new JTextArea();
		
		JButton btnAdicionaNoVetor = new JButton("Adiciona no Vetor");
		GroupLayout groupLayout = new GroupLayout(this.frmVetordeReais.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCriaVetor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnArmazenavetor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMultiplica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDivide))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbNumero)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(this.txtFieldValorAddVetor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionaNoVetor))
						.addComponent(this.textAreaResultados, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNumero)
						.addComponent(this.txtFieldValorAddVetor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdicionaNoVetor))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.textAreaResultados, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCriaVetor)
						.addComponent(btnArmazenavetor)
						.addComponent(btnMultiplica)
						.addComponent(btnDivide))
					.addContainerGap())
		);
		this.frmVetordeReais.getContentPane().setLayout(groupLayout);
	}

	private void createJFrame() {
		this.frmVetordeReais = new JFrame();
		this.frmVetordeReais.setVisible(true);
		this.frmVetordeReais.setResizable(false);
		this.frmVetordeReais.setTitle("Vetor De Reais - AHE");
		this.frmVetordeReais.setBounds(100, 100, 440, 301);
		this.frmVetordeReais.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setTextAreaResultado(String msg) {
		this.textAreaResultados.setText(this.textAreaResultados.getText() + "\n" + msg);
		
	}
	
	private ActionListener alBtnCriaVetor(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JOptionPane();
				int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do Vetor!"));
				GUIApp.this.action.criaVetor(tamanho);
				setTextAreaResultado("Vetor Criado com o tamanho de: " + tamanho);
			}
		};
	}
	
}
