package br.com.ahe.poo.um.lista.um.exercicio.exercicio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class TelaGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame framePrincipal;
	
	private JLabel lblNome;
	private JLabel lblRenda; 
	private JLabel lblCpf;
	
	private JTextField txtNome;
	private JTextField txtRenda;
	private JTextField txtCPF;

	private JButton btnOk;
	private JButton btnHelp;
	
	private JTextArea txtAreaResultado;
	
	public TelaGUI() {
		criaFrame();
	}

	private void criaFrame() {
		criaComponentes();
		this.framePrincipal = new JFrame("Exercicio 1 - POO 1 - AHE");
		this.framePrincipal.setVisible(true);
		this.framePrincipal.setBounds(100, 100, 258, 234);
		this.framePrincipal.getContentPane().setLayout(null);
		this.framePrincipal.getContentPane().add(this.lblNome);
		this.framePrincipal.getContentPane().add(this.lblRenda);
		this.framePrincipal.getContentPane().add(this.txtNome);
		this.framePrincipal.getContentPane().add(this.txtRenda);
		this.framePrincipal.getContentPane().add(this.btnOk);
		this.framePrincipal.getContentPane().add(this.btnHelp);
		this.framePrincipal.getContentPane().add(this.txtAreaResultado);
		this.framePrincipal.getContentPane().add(this.lblCpf);
		this.framePrincipal.getContentPane().add(this.txtCPF);
		this.framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	private void criaComponentes() {
		this.lblNome = new JLabel("Nome: ");
		this.lblNome.setBounds(12, 12, 50, 15);

		this.lblCpf = new JLabel("CPF:");
		this.lblCpf.setBounds(12, 39, 70, 15);
		
		this.lblRenda = new JLabel("Renda: ");
		this.lblRenda.setBounds(12, 66, 60, 15);
		
		this.txtNome = new JTextField();
		this.txtNome.setBounds(65, 12, 180, 15);

		this.txtCPF = new JTextField();
		this.txtCPF.setBounds(65, 39, 180, 15);
		
		this.txtRenda = new JTextField();
		this.txtRenda.setBounds(65, 66, 180, 15);

		this.btnOk = new JButton("CALCULAR");
		this.btnOk.setBounds(12, 88, 117, 25);
		this.btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImpostoRenda IR = new ImpostoRenda();
				Pessoa pesTmp = null;
				try {
					pesTmp = new Pessoa(TelaGUI.this.txtNome.getText(), TelaGUI.this.txtCPF.getText(), new BigDecimal(TelaGUI.this.txtRenda.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				TelaGUI.this.txtAreaResultado.setText(IR.calculaImposto(pesTmp).toString());
			}
		});

		this.btnHelp = new JButton("AJUDA");
		this.btnHelp.setBounds(127, 88, 117, 25);
		this.btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exercicio 1 - POO 1\nArthur Henrique Eggert");
			}
		});

		this.txtAreaResultado = new JTextArea();
		this.txtAreaResultado.setBounds(12, 125, 231, 74);
		this.txtAreaResultado.setBorder(UIManager.getBorder("InternalFrame.paletteBorder"));

	}
}
