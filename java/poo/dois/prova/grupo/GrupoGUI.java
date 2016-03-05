package br.com.ahe.poo.dois.prova.grupo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GrupoGUI {

	private JFrame frmEntrada;
	private JTextField textField;
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrupoGUI window = new GrupoGUI();
					window.frmEntrada.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GrupoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frmEntrada = new JFrame();
		this.frmEntrada.setTitle("Entrada");
		this.frmEntrada.setBounds(100, 100, 266, 438);
		this.frmEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.textField = new JTextField();
		this.textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				GrupoGUI.this.textField.setText("");
			}
		});
		this.textField.setToolTipText("Informe uma op\u00E7\u00E3o");
		this.textField.setColumns(10);
		
		JLabel lblEscolhaOpo = new JLabel("Escolha Op\u00E7\u00E3o");
		
		JLabel lblSair = new JLabel("0 - Sair");
		
		JLabel lblIncluirGrupo = new JLabel("1 - Incluir Grupo");
		
		JLabel lblExcluirGrupo = new JLabel("2 - Excluir Grupo");
		
		JLabel lblIncluirIntegrante = new JLabel("4 - Incluir Integrante");
		
		JLabel lblRemoverIntegrante = new JLabel("5 - Remover Integrante");
		
		JLabel lblImprimirIntegrantesGrupo = new JLabel("6 - Imprimir Integrantes (Ordem Albabetica)");
		
		JLabel lblImprimirIntegrantesGruposIdade = new JLabel("7 - Imprimir Integrantes(Ordem de Idade)");
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (Integer.parseInt(GrupoGUI.this.textField.getText())) {
				case 0:
					System.exit(0);
					break;
				
				case 1:
					String nomeGrupo = JOptionPane.showInputDialog(GrupoGUI.this.frmEntrada, "Digite o nome do grupo a ser inserido");
					incluirGrupo(nomeGrupo);
					break;
				
				case 2:
					String nomeGrupoExcluir = JOptionPane.showInputDialog(GrupoGUI.this.frmEntrada, "Digite o nome do grupo a se removido");
					excluirGrupo(nomeGrupoExcluir);
					break;
				
				case 3:
					imprimeGrupos();
					break;
					
				case 4:
					incluirIntegrante();
					break;
				
				case 5:
					excluirIntegrante();
					break;
					
				case 6:
					imprimirGruposAlfabetica();
					break;
				
				case 7:
					imprimirGruposOrdemIdade();
					break;
					
				case 8:
					imprimiGruposComIntegrantes();
				
				default:
					break;
				}

			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblImprimirGrupos = new JLabel("3 - Imprimir Grupos");
		
		JLabel lblImprimirGruposIntegrantes = new JLabel("8 - Imprimir Grupos c/ Integrantes");
		
		JLabel lblVerifica = new JLabel("9 - Verifica Integrantes Equivalentes");
		GroupLayout groupLayout = new GroupLayout(this.frmEntrada.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVerifica)
						.addComponent(lblImprimirGruposIntegrantes)
						.addComponent(lblImprimirGrupos)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblImprimirIntegrantesGruposIdade)
							.addComponent(lblImprimirIntegrantesGrupo)
							.addComponent(lblRemoverIntegrante)
							.addComponent(lblIncluirIntegrante, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnOk)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCancelar))
							.addComponent(this.textField))
						.addComponent(lblExcluirGrupo)
						.addComponent(lblIncluirGrupo)
						.addComponent(lblSair)
						.addComponent(lblEscolhaOpo))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEscolhaOpo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSair)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIncluirGrupo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExcluirGrupo)
					.addGap(7)
					.addComponent(lblImprimirGrupos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIncluirIntegrante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRemoverIntegrante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblImprimirIntegrantesGrupo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblImprimirIntegrantesGruposIdade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblImprimirGruposIntegrantes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblVerifica)
					.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
					.addComponent(this.textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		this.frmEntrada.getContentPane().setLayout(groupLayout);
	}
	
	
	private void incluirGrupo(String nomeGrupo) {
		for (Grupo grup : this.grupos){
			if(grup.getNomeGrupo().equalsIgnoreCase(nomeGrupo)){
				JOptionPane.showMessageDialog(null, "Grupo Ja Inserido");
			}
		}
		Grupo grupo = new Grupo(nomeGrupo);
		this.grupos.add(grupo);
		
	}
	
	private void excluirGrupo(String nomeGrupo){
		Grupo g = null;
		for (Grupo grup : this.grupos){
			if(grup.getNomeGrupo().equalsIgnoreCase(nomeGrupo)){
				g = grup;
			}
		}
		this.grupos.remove(g);
	}
	
	public void imprimeGrupos(){
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(Grupo g : this.grupos){
			sb.append(g.toString());
		}
		
		JOptionPane.showMessageDialog(this.frmEntrada, sb);
	}
	
	public void incluirIntegrante(){
		String grupoIncluir = JOptionPane.showInputDialog("Digite o nome do Grupo");
		String nome = JOptionPane.showInputDialog("Digite o nome do integrante");
		String idade = JOptionPane.showInputDialog("Digite a idade do integrante");
		String sexo = JOptionPane.showInputDialog("Digite o sexo do integrante");
		
		Integrante novoIntegrante = new Integrante(nome, Integer.parseInt(idade), sexo);
		Grupo grupo = null;
		for(Grupo g : this.grupos){
			if(g.getNomeGrupo().equalsIgnoreCase(grupoIncluir)){
				grupo = g;
				break;
			}
		}
		grupo.addIntegrante(novoIntegrante);
	}
	
	public void excluirIntegrante(){
		String grupoIncluir = JOptionPane.showInputDialog("Digite o nome do Grupo");
		String nome = JOptionPane.showInputDialog("Digite o nome do integrante");
		String idade = JOptionPane.showInputDialog("Digite a idade do integrante");
		String sexo = JOptionPane.showInputDialog("Digite o sexo do integrante");
		
		Integrante novoIntegrante = new Integrante(nome, Integer.parseInt(idade), sexo);
		Grupo grupo = null;
		for(Grupo g : this.grupos){
			if(g.getNomeGrupo().equalsIgnoreCase(grupoIncluir)){
				grupo = g;
				break;
			}
		}
		grupo.removeIntegrante(novoIntegrante);
	}
	
	public void imprimiGruposComIntegrantes(){
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(Grupo g : this.grupos){
			sb.append(g.toString()+"/n");
		}
		
		JOptionPane.showMessageDialog(this.frmEntrada, sb);
	}
	
	public void imprimirGruposAlfabetica(){
		StringBuilder sb = new  StringBuilder();
		sb.append("");
		for (Grupo g : this.grupos) {
			g.imprimeIntegrantesOrdemAlfabetica();
		}
	}
	
	private void imprimirGruposOrdemIdade() {
		for (Grupo g : this.grupos) {
			g.imprimeIntegrantesIdade();
		}
	}
	
	
	
}

