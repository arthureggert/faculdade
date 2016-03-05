package br.com.ahe.poo.dois.prova.Imovel;

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

public class SistemaImobiliariaGUI {

	private JFrame frame;
	private JTextField textFieldTipo;
	private JTextField textFieldOperacao;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldValorDe;
	private JTextField textFieldValorAte;
	private ImovelModel iModel = new ImovelModel();
	private ImovelPesquisaModel iModelPesquisa = new ImovelPesquisaModel();
	private JTable tableListaImoveis = new JTable();
	private JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter filtroSerializado = new FileNameExtensionFilter("Arquivos Serializados (.ser)", "ser");
    private FileNameExtensionFilter filtroTexto = new FileNameExtensionFilter("Arquivos Texto (.txt)", "txt");
    private JTable tableListaImoveisPesquisa = new JTable();
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaImobiliariaGUI window = new SistemaImobiliariaGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SistemaImobiliariaGUI() {
		initialize();
        this.fileChooser.addChoosableFileFilter(this.filtroSerializado);
        this.fileChooser.addChoosableFileFilter(this.filtroTexto);
        this.fileChooser.setAcceptAllFileFilterUsed(false);
        this.fileChooser.setDialogTitle("Selecione Arquivo");
	}

	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 860, 443);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAbrirArquivo = new JButton("Abrir Arquivo");
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtAbrir) {
		        
				int opcao = SistemaImobiliariaGUI.this.fileChooser.showOpenDialog(SistemaImobiliariaGUI.this.frame);
		        if (opcao == JFileChooser.APPROVE_OPTION) {
		            
		        	File arquivo = SistemaImobiliariaGUI.this.fileChooser.getSelectedFile();

		            ImovelDAO imobiliariaDAO;
		            if (arquivo.getName().lastIndexOf(".ser")>0){
		                imobiliariaDAO = new ImovelDAOSerializado(arquivo);
		            }else{
		                imobiliariaDAO = new ImovelDAOTexto(arquivo);
		            }
		            
		            ArrayList<Imovel> imoveisLidos = null;
		            
		            try {
		                imoveisLidos = imobiliariaDAO.ler();
		                SistemaImobiliariaGUI.this.iModel.setImoveis(imoveisLidos);
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(SistemaImobiliariaGUI.this.frame, "Erro ao Ler o Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		            } catch (ClassNotFoundException ex) {
		                JOptionPane.showMessageDialog(SistemaImobiliariaGUI.this.frame, "Erro ao Instanciar Filme", "Erro", JOptionPane.ERROR_MESSAGE);
		            }
		        }
			}
		});
		
		JButton btnGravarArquivo = new JButton("Gravar Arquivo");
		btnGravarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtGravar) {
				
				int opcao = SistemaImobiliariaGUI.this.fileChooser.showSaveDialog(SistemaImobiliariaGUI.this.frame);
		        
		        if (opcao == JFileChooser.APPROVE_OPTION) {
		        
		        	File arquivo = SistemaImobiliariaGUI.this.fileChooser.getSelectedFile();

		            ImovelDAO imobiliariaDAO;
		            
		            if (arquivo.getName().lastIndexOf(".ser") > 0) {
		            	imobiliariaDAO = new ImovelDAOSerializado(arquivo);
		            } else {
		            	imobiliariaDAO = new ImovelDAOTexto(arquivo);
		            }

		            try {
		                imobiliariaDAO.gravar(SistemaImobiliariaGUI.this.iModel.getImoveis());
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(SistemaImobiliariaGUI.this.frame, "Erro ao Gravar no Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		                ex.printStackTrace();
		            }
		        }

			}
		});
		
		JButton btnIncluirImovel = new JButton("Incluir Im\u00F3vel");
		btnIncluirImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoAddImovel) {
				SistemaImobiliariaGUI.this.iModel.addImovel(new Imovel());
			}
		});
		
		JButton btnExcluirImvel = new JButton("Excluir Im\u00F3vel");
		btnExcluirImvel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtDelImovel) {
				SistemaImobiliariaGUI.this.iModel.removeImovel(SistemaImobiliariaGUI.this.tableListaImoveis.getSelectedRow());
			}
		});
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setToolTipText("Teste");
		layeredPane.setBorder(UIManager.getBorder("TitledBorder.border"));
		
		JLabel lblPesquisaImveis = new JLabel("Pesquisa de Im\u00F3veis");
		
		
		this.tableListaImoveis.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.tableListaImoveis.setFillsViewportHeight(true);
		this.tableListaImoveis.setColumnSelectionAllowed(true);
		this.tableListaImoveis.setCellSelectionEnabled(true);
		this.tableListaImoveis.setPreferredScrollableViewportSize(new Dimension(0,100));  
		this.tableListaImoveis.setModel(this.iModel);
	
		
		JScrollPane scrollPanePrincipal = new JScrollPane(this.tableListaImoveis);

		GroupLayout groupLayout = new GroupLayout(this.frame.getContentPane());
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
							.addPreferredGap(ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
							.addComponent(btnIncluirImovel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluirImvel))
						.addComponent(lblPesquisaImveis)
						.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPesquisaImveis)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		JLabel lblOperao = new JLabel("Opera\u00E7\u00E3o:");
		
		JButton btnOkTipoOperacao = new JButton("OK");
		btnOkTipoOperacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtPesquisaPorOperacaoTipo) {

				ArrayList<Imovel> lista = SistemaImobiliariaGUI.this.iModel.getImoveis();
								
				if(!SistemaImobiliariaGUI.this.textFieldOperacao.getText().isEmpty() && !SistemaImobiliariaGUI.this.textFieldTipo.getText().isEmpty()){
					SistemaImobiliariaGUI.this.iModelPesquisa.limpaTabela();
					for(Imovel i : lista){
						if(i.getOperacao() ==  SistemaImobiliariaGUI.this.textFieldOperacao.getText().charAt(0) && i.getTipo() ==  SistemaImobiliariaGUI.this.textFieldTipo.getText().charAt(0)){
							SistemaImobiliariaGUI.this.iModelPesquisa.addImovel(i);						
						}
					}
				}
				
				if(!SistemaImobiliariaGUI.this.textFieldOperacao.getText().isEmpty()){
					SistemaImobiliariaGUI.this.iModelPesquisa.limpaTabela();
					for(Imovel i : lista){
						if(i.getOperacao() ==  SistemaImobiliariaGUI.this.textFieldOperacao.getText().charAt(0)){
							SistemaImobiliariaGUI.this.iModelPesquisa.addImovel(i);						
						}
					}
				}
				
				if(!SistemaImobiliariaGUI.this.textFieldTipo.getText().isEmpty()){
					SistemaImobiliariaGUI.this.iModelPesquisa.limpaTabela();
					for(Imovel i : lista){
						if(i.getTipo() ==  SistemaImobiliariaGUI.this.textFieldTipo.getText().charAt(0)){
							SistemaImobiliariaGUI.this.iModelPesquisa.addImovel(i);						
						}
					}
				}		
			}
		});
		
		this.textFieldTipo = new JTextField();
		this.textFieldTipo.setColumns(10);
		
		this.textFieldOperacao = new JTextField();
		this.textFieldOperacao.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		
		this.textFieldBairro = new JTextField();
		this.textFieldBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		this.textFieldCidade = new JTextField();
		this.textFieldCidade.setColumns(10);
		
		JButton btnOkBairro = new JButton("OK");
		btnOkBairro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtPesquisaBairro) {
				
				ArrayList<Imovel> lista = SistemaImobiliariaGUI.this.iModel.getImoveis();
				SistemaImobiliariaGUI.this.iModelPesquisa.limpaTabela();
					for(Imovel i : lista){
						if(i.getBairro().equalsIgnoreCase(SistemaImobiliariaGUI.this.textFieldBairro.getText())){
							SistemaImobiliariaGUI.this.iModelPesquisa.addImovel(i);						
						}
					}
			}
		});
		
		JButton btnOkCidade = new JButton("OK");
		btnOkCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Imovel> lista = SistemaImobiliariaGUI.this.iModel.getImoveis();
				SistemaImobiliariaGUI.this.iModelPesquisa.limpaTabela();
					for(Imovel i : lista){
						if(i.getCidade().equalsIgnoreCase(SistemaImobiliariaGUI.this.textFieldCidade.getText())){
							SistemaImobiliariaGUI.this.iModelPesquisa.addImovel(i);						
						}
					}
			}
		});
		
		JLabel lblValor = new JLabel("Valor:");
		
		this.textFieldValorDe = new JTextField();
		this.textFieldValorDe.setText("0");
		this.textFieldValorDe.setColumns(10);
		
		JLabel lblValorAte = new JLabel("at\u00E9");
		
		this.textFieldValorAte = new JTextField();
		this.textFieldValorAte.setText("0");
		this.textFieldValorAte.setColumns(10);
		
		JButton btnOkValor = new JButton("OK");
		btnOkValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Imovel> lista = SistemaImobiliariaGUI.this.iModel.getImoveis();
				SistemaImobiliariaGUI.this.iModelPesquisa.limpaTabela();
					for(Imovel i : lista){
						if(i.getValor() > Integer.parseInt(SistemaImobiliariaGUI.this.textFieldValorDe.getText()) && i.getValor() < Integer.parseInt(SistemaImobiliariaGUI.this.textFieldValorAte.getText())){
							SistemaImobiliariaGUI.this.iModelPesquisa.addImovel(i);						
						}
					}
			}
		});
		
		JButton btnSuperPesquisa = new JButton("Super Pesquisa");
		btnSuperPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnGravarResultadosEm = new JButton("Gravar Resultados em Arquivo");
		btnGravarResultadosEm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = SistemaImobiliariaGUI.this.fileChooser.showSaveDialog(SistemaImobiliariaGUI.this.frame);
		        
		        if (opcao == JFileChooser.APPROVE_OPTION) {
		        
		        	File arquivo = SistemaImobiliariaGUI.this.fileChooser.getSelectedFile();

		            ImovelDAO imobiliariaDAO;
		            
		            if (arquivo.getName().lastIndexOf(".ser") > 0) {
		            	imobiliariaDAO = new ImovelDAOSerializado(arquivo);
		            } else {
		            	imobiliariaDAO = new ImovelDAOTexto(arquivo);
		            }

		            try {
		                imobiliariaDAO.gravar(SistemaImobiliariaGUI.this.iModelPesquisa.getImoveis());
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(SistemaImobiliariaGUI.this.frame, "Erro ao Gravar no Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		                ex.printStackTrace();
		            }
		        }
			}
		});
		
		JScrollPane scrollPanePesquisa = new JScrollPane();
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(89)
					.addComponent(btnSuperPesquisa)
					.addPreferredGap(ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
					.addComponent(btnGravarResultadosEm)
					.addGap(35))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblValor)
						.addComponent(lblCidade)
						.addComponent(lblBairro)
						.addComponent(lblTipo)
						.addComponent(lblOperao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(this.textFieldOperacao, 0, 0, Short.MAX_VALUE)
								.addComponent(this.textFieldTipo, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOkTipoOperacao))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(this.textFieldBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOkBairro))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(this.textFieldCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOkCidade))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(this.textFieldValorDe, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblValorAte)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(this.textFieldValorAte, 0, 0, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOkValor)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(scrollPanePesquisa, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTipo)
									.addComponent(this.textFieldTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(this.textFieldOperacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblOperao))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBairro)
								.addComponent(this.textFieldBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOkBairro))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCidade)
								.addComponent(this.textFieldCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOkCidade))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValor)
								.addComponent(this.textFieldValorDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblValorAte)
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addGap(3)
									.addComponent(this.textFieldValorAte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnOkValor)))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGap(14)
							.addComponent(btnOkTipoOperacao))
						.addComponent(scrollPanePesquisa, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSuperPesquisa)
						.addComponent(btnGravarResultadosEm))
					.addGap(14))
		);
		
		scrollPanePesquisa.setViewportView(this.tableListaImoveisPesquisa);
		this.tableListaImoveisPesquisa.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.tableListaImoveisPesquisa.setFillsViewportHeight(true);
		this.tableListaImoveisPesquisa.setColumnSelectionAllowed(true);
		this.tableListaImoveisPesquisa.setCellSelectionEnabled(true);
		this.tableListaImoveisPesquisa.setPreferredScrollableViewportSize(new Dimension(0,100));  
		this.tableListaImoveisPesquisa.setModel(this.iModelPesquisa);
		layeredPane.setLayout(gl_layeredPane);
		//layeredPane.setFocusTraversalPolicy(new FocusTraversalPolicy(new Component[]{btnSuperPesquisa, btnGravarResultadosEm, lblValor, lblCidade, lblBairro, lblTipo, lblOperao, textFieldOperacao, textFieldTipo, btnOkTipoOperacao, textFieldBairro, btnOkBairro, textFieldCidade, btnOkCidade, textFieldValorDe, lblValorAte, textFieldValorAte, btnOkValor}));
		this.frame.getContentPane().setLayout(groupLayout);
	}
}
