package br.com.ahe.poo.dois.prova.automovel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SistemaDetranGUI {

	private JFrame frmDetranCadastro;
	private AutomovelModel autoModel = new AutomovelModel();
	private JTable tableListaAutos = new JTable();
	JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter filtroSerializado = new FileNameExtensionFilter("Arquivos Serializados (.ser)", "ser");
    private FileNameExtensionFilter filtroTexto = new FileNameExtensionFilter("Arquivos Texto (.txt)", "txt");
    private JTable tableListaImoveisPesquisa = new JTable();
    private JTextField texxtRenavan;
    private JTextField textPlaca;
    private JTextField textAnoDe;
    private JTextField textAnoAte;
    private JTextField textMarcaModelo;
    private JTextField textEstado;
    private JTextField textCombustivel;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaDetranGUI window = new SistemaDetranGUI();
					window.frmDetranCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SistemaDetranGUI() {
		initialize();
        this.fileChooser.addChoosableFileFilter(this.filtroSerializado);
        this.fileChooser.addChoosableFileFilter(this.filtroTexto);
        this.fileChooser.setAcceptAllFileFilterUsed(false);
        this.fileChooser.setDialogTitle("Selecione Arquivo");
	}

	private void initialize() {
		this.frmDetranCadastro = new JFrame();
		this.frmDetranCadastro.setTitle("Detran - Cadastro de Autom\u00F3veis");
		this.frmDetranCadastro.setBounds(100, 100, 1100, 540);
		this.frmDetranCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAbrirArquivo = new JButton("Abrir Arquivo");
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtAbrir) {
		        
				int opcao = SistemaDetranGUI.this.fileChooser.showOpenDialog(SistemaDetranGUI.this.frmDetranCadastro);
		        if (opcao == JFileChooser.APPROVE_OPTION) {
		            
		        	File arquivo = SistemaDetranGUI.this.fileChooser.getSelectedFile();

		            AutomovelDAO automovelDAO;
		            if (arquivo.getName().lastIndexOf(".ser")>0){
		                automovelDAO = new AutomovelDAOSerializado(arquivo);
		            }else{
		                automovelDAO = new AutomovelDAOTexto(arquivo);
		            }
		            
		            ArrayList<Automovel> automoveisLidos = null;
		            
		            try {
		            	automoveisLidos = automovelDAO.ler();
		                SistemaDetranGUI.this.autoModel.setImoveis(automoveisLidos);
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(SistemaDetranGUI.this.frmDetranCadastro, "Erro ao Ler o Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		            } catch (ClassNotFoundException ex) {
		                JOptionPane.showMessageDialog(SistemaDetranGUI.this.frmDetranCadastro, "Erro ao Instanciar Filme", "Erro", JOptionPane.ERROR_MESSAGE);
		            }
		        }
			}
		});
		
		JButton btnGravarArquivo = new JButton("Gravar Arquivo");
		btnGravarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtGravar) {
				
				int opcao = SistemaDetranGUI.this.fileChooser.showSaveDialog(SistemaDetranGUI.this.frmDetranCadastro);
		        
		        if (opcao == JFileChooser.APPROVE_OPTION) {
		        
		        	File arquivo = SistemaDetranGUI.this.fileChooser.getSelectedFile();

		            AutomovelDAO automovelDAO;
		            
		            if (arquivo.getName().lastIndexOf(".ser") > 0) {
		            	automovelDAO = new AutomovelDAOSerializado(arquivo);
		            } else {
		            	automovelDAO = new AutomovelDAOTexto(arquivo);
		            }

		            try {
		                automovelDAO.gravar(SistemaDetranGUI.this.autoModel.getAutomoveis());
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(SistemaDetranGUI.this.frmDetranCadastro, "Erro ao Gravar no Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		                ex.printStackTrace();
		            }
		        }

			}
		});
		
		JButton btnIncluirImovel = new JButton("Incluir Autom\u00F3vel");
		btnIncluirImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoAddImovel) {
				SistemaDetranGUI.this.autoModel.addAutomovel(new Automovel());
			}
		});
		
		JButton btnExcluirImvel = new JButton("Excluir Autom\u00F3vel");
		btnExcluirImvel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtDelImovel) {
				SistemaDetranGUI.this.autoModel.removeAutomovel(SistemaDetranGUI.this.tableListaAutos.getSelectedRow());
			}
		});
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setToolTipText("Teste");
		layeredPane.setBorder(UIManager.getBorder("TitledBorder.border"));
		
		JLabel lblPesquisaAutomoveis = new JLabel("Pesquisa de Autom\u00F3veis");
		
		
		this.tableListaAutos.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.tableListaAutos.setFillsViewportHeight(true);
		this.tableListaAutos.setColumnSelectionAllowed(true);
		this.tableListaAutos.setCellSelectionEnabled(true);
		this.tableListaAutos.setPreferredScrollableViewportSize(new Dimension(0,100));  
		this.tableListaAutos.setModel(this.autoModel);
	
		
		JScrollPane scrollPanePrincipal = new JScrollPane(this.tableListaAutos);

		GroupLayout groupLayout = new GroupLayout(this.frmDetranCadastro.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPanePrincipal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnAbrirArquivo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGravarArquivo)
							.addPreferredGap(ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
							.addComponent(btnIncluirImovel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluirImvel))
						.addComponent(lblPesquisaAutomoveis, Alignment.TRAILING)
						.addComponent(layeredPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbrirArquivo)
						.addComponent(btnGravarArquivo)
						.addComponent(btnExcluirImvel)
						.addComponent(btnIncluirImovel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPanePrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPesquisaAutomoveis)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnGravarResultadosEm = new JButton("Gravar Resultados em Arquivo");
		btnGravarResultadosEm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = SistemaDetranGUI.this.fileChooser.showSaveDialog(SistemaDetranGUI.this.frmDetranCadastro);
		        
		        if (opcao == JFileChooser.APPROVE_OPTION) {
		        
		        	File arquivo = SistemaDetranGUI.this.fileChooser.getSelectedFile();

		            AutomovelDAO automovelDAO;
		            
		            if (arquivo.getName().lastIndexOf(".ser") > 0) {
		            	automovelDAO = new AutomovelDAOSerializado(arquivo);
		            } else {
		            	automovelDAO = new AutomovelDAOTexto(arquivo);
		            }

		            try {
		            	automovelDAO.gravar(SistemaDetranGUI.this.autoModel.getAutomoveis());
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(SistemaDetranGUI.this.frmDetranCadastro, "Erro ao Gravar no Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		                ex.printStackTrace();
		            }
		        }
			}
		});
		
		JScrollPane scrollPanePesquisa = new JScrollPane();
		
		JLabel lblRenavan = new JLabel("Renavan");
		
		JLabel lblPlaca = new JLabel("Placa");
		
		this.texxtRenavan = new JTextField();
		this.texxtRenavan.setColumns(10);
		
		this.textPlaca = new JTextField();
		this.textPlaca.setColumns(10);
		
		JButton buttonRenavan = new JButton("Pesquisar");
		buttonRenavan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtPesquisaRenavan) {
				ArrayList<Automovel> pesquisa = SistemaDetranGUI.this.autoModel.getAutomoveis();
				
				if(!SistemaDetranGUI.this.texxtRenavan.getText().isEmpty()){
					for(Automovel auto : pesquisa){
						SistemaDetranGUI.this.autoModel.limpaTabela();
						if(Integer.parseInt(SistemaDetranGUI.this.texxtRenavan.getText()) == auto.getRenavan()){
							SistemaDetranGUI.this.autoModel.addAutomovelPesquisa(auto);
						}
						
					}
				}
			}
		});
		
		JButton buttonPlaca = new JButton("Pesquisar");
		buttonPlaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Automovel> pesquisa = SistemaDetranGUI.this.autoModel.getAutomoveis();
				
				if(!SistemaDetranGUI.this.textPlaca.getText().isEmpty()){
					for(Automovel auto : pesquisa){
						SistemaDetranGUI.this.autoModel.limpaTabela();
						if(SistemaDetranGUI.this.textPlaca.getText().equalsIgnoreCase(auto.getPlaca())){
							SistemaDetranGUI.this.autoModel.addAutomovelPesquisa(auto);
						}
						
					}
				}
			}
		});
		
		JLabel lblMarcaOuModelo = new JLabel("Marca ou Modelo");
		
		JLabel lblAno = new JLabel("Ano");
		
		this.textAnoDe = new JTextField();
		this.textAnoDe.setColumns(10);
		
		JLabel lblAt = new JLabel("At\u00E9");
		
		this.textAnoAte = new JTextField();
		this.textAnoAte.setColumns(10);
		
		this.textMarcaModelo = new JTextField();
		this.textMarcaModelo.setColumns(10);
		
		JButton buttonMarcaModelo = new JButton("Pesquisar");
		buttonMarcaModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Automovel> pesquisa = SistemaDetranGUI.this.autoModel.getAutomoveis();
				
				if(!SistemaDetranGUI.this.textMarcaModelo.getText().isEmpty()){
					for(Automovel auto : pesquisa){
						SistemaDetranGUI.this.autoModel.limpaTabela();
						if(SistemaDetranGUI.this.textMarcaModelo.getText().equalsIgnoreCase(auto.getModelo()) || SistemaDetranGUI.this.textMarcaModelo.getText().equalsIgnoreCase(auto.getMarca())){
							SistemaDetranGUI.this.autoModel.addAutomovelPesquisa(auto);
						}
						
					}
				}
			}
		});
		
		JButton buttonAno = new JButton("Pesquisar");
		
		JLabel lblEstado = new JLabel("Estado");
		
		JLabel lblCombustivel = new JLabel("Combustivel");
		
		this.textEstado = new JTextField();
		this.textEstado.setColumns(10);
		
		this.textCombustivel = new JTextField();
		this.textCombustivel.setColumns(10);
		
		JButton buttonEstado = new JButton("Pesquisar");
		buttonEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Automovel> pesquisa = SistemaDetranGUI.this.autoModel.getAutomoveis();
				
				if(!SistemaDetranGUI.this.textEstado.getText().isEmpty()){
					for(Automovel auto : pesquisa){
						SistemaDetranGUI.this.autoModel.limpaTabela();
						if(SistemaDetranGUI.this.textEstado.getText().equalsIgnoreCase(auto.getEstado())){
							SistemaDetranGUI.this.autoModel.addAutomovelPesquisa(auto);
						}
						
					}
				}
				
			}
		});
		
		JButton buttonCombustivel = new JButton("Pesquisar");
		buttonCombustivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Automovel> pesquisa = SistemaDetranGUI.this.autoModel.getAutomoveis();
				
				if(!SistemaDetranGUI.this.textPlaca.getText().isEmpty()){
					for(Automovel auto : pesquisa){
						SistemaDetranGUI.this.autoModel.limpaTabela();
						if(SistemaDetranGUI.this.textPlaca.getText().equalsIgnoreCase(auto.getPlaca())){
							SistemaDetranGUI.this.autoModel.addAutomovelPesquisa(auto);
						}
						
					}
				}
			}
		});
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(scrollPanePesquisa, GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPlaca)
										.addComponent(lblRenavan))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_layeredPane.createSequentialGroup()
											.addComponent(this.textPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(buttonPlaca)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblAno)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(this.textAnoDe, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblAt)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(this.textAnoAte, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(buttonAno))
										.addGroup(gl_layeredPane.createSequentialGroup()
											.addComponent(this.texxtRenavan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(buttonRenavan)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblMarcaOuModelo)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(this.textMarcaModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(buttonMarcaModelo)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEstado, Alignment.TRAILING)
										.addComponent(lblCombustivel))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(this.textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(this.textCombustivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(buttonEstado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(buttonCombustivel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
								.addComponent(btnGravarResultadosEm))
							.addGap(321))))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado)
								.addComponent(this.textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonEstado))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCombustivel)
								.addComponent(this.textCombustivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonAno)
								.addComponent(this.textAnoAte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAt)
								.addComponent(this.textAnoDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAno)
								.addComponent(buttonCombustivel)))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRenavan)
								.addComponent(this.texxtRenavan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonRenavan)
								.addComponent(lblMarcaOuModelo)
								.addComponent(this.textMarcaModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonMarcaModelo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPlaca)
								.addComponent(this.textPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonPlaca))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGravarResultadosEm)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPanePesquisa, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		scrollPanePesquisa.setViewportView(this.tableListaImoveisPesquisa);
		this.tableListaImoveisPesquisa.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.tableListaImoveisPesquisa.setFillsViewportHeight(true);
		this.tableListaImoveisPesquisa.setColumnSelectionAllowed(true);
		this.tableListaImoveisPesquisa.setCellSelectionEnabled(true);
		this.tableListaImoveisPesquisa.setPreferredScrollableViewportSize(new Dimension(0,100));
		this.tableListaImoveisPesquisa.setModel(this.autoModel);
		layeredPane.setLayout(gl_layeredPane);
		//layeredPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnGravarResultadosEm}));
		this.frmDetranCadastro.getContentPane().setLayout(groupLayout);
	}
}
