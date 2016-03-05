package br.com.ahe.ldp.produtor.testes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.com.ahe.ldp.produtor.L1311H04.TelaPrincipal;


public class TelaInicial extends JFrame{

	private static final long serialVersionUID = 1L;

	private JTextField textFieldProdutores;
	
	private JTextField textFieldArmazem;
	
	private JTextField textFieldConsumidores;
	
	private JLabel lblLArthur;
	
	private JButton buttomOk;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new TelaInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public TelaInicial() {
		initialize();
	}
	
	private void initialize() {

		setTitle("L1311H04 - AHE");
		setResizable(false);
		setBounds(100, 100, 271, 152);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JLabel labelProdutores = new JLabel("Informe a qtd de produtores");
		labelProdutores.setBounds(10, 11, 137, 14);
		add(labelProdutores);

		JLabel labelArmazem = new JLabel("Informe o tamanho do armazem");
		labelArmazem.setBounds(10, 36, 153, 14);
		add(labelArmazem);

		JLabel labelConsumidores = new JLabel("Informe a qtd de consumidores");
		labelConsumidores.setBounds(10, 61, 149, 14);
		add(labelConsumidores);

		this.textFieldProdutores = new JTextField();
		this.textFieldProdutores.setBounds(171, 8, 86, 20);
		add(this.textFieldProdutores);
		this.textFieldProdutores.setColumns(10);

		this.textFieldArmazem = new JTextField();
		this.textFieldArmazem.setBounds(171, 33, 86, 20);
		add(this.textFieldArmazem);
		this.textFieldArmazem.setColumns(10);

		this.textFieldConsumidores = new JTextField();
		this.textFieldConsumidores.setBounds(171, 58, 86, 20);
		add(this.textFieldConsumidores);
		this.textFieldConsumidores.setColumns(10);

		this.buttomOk = new JButton("OK");
		this.buttomOk.addActionListener(criaTelaProdutorConsumidor());
		this.buttomOk.setBounds(210, 84, 47, 23);
		add(this.buttomOk);

		this.lblLArthur = new JLabel("L131104 - Arthur Henrique Eggert");
		this.lblLArthur.setBounds(10, 93, 190, 14);
		add(this.lblLArthur);
		setVisible(true);
	}

	private ActionListener criaTelaProdutorConsumidor() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					int qtdProdutores = Integer.parseInt(TelaInicial.this.textFieldProdutores.getText().trim());
					int tamArmazem = Integer.parseInt(TelaInicial.this.textFieldArmazem.getText().trim());
					int qtdConsumidores = Integer.parseInt(TelaInicial.this.textFieldConsumidores.getText().trim());
					new TelaPrincipal(qtdProdutores,qtdConsumidores,tamArmazem);
					setVisible(false);
				} catch (Throwable e){
					e.printStackTrace();
				}
			}
		};
	}
}
