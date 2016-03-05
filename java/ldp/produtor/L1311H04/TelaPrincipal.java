package br.com.ahe.ldp.produtor.L1311H04;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class TelaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;

	private List<Processo> produtores;

	private List<Processo> consumidores;
	
	public TelaPrincipal(int qtdProdutores, int qtdConsumidor, int tamanhoArmazemProdutores ) throws InterruptedException{
		setSize(650, 600);  
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setTitle("L1311H04 - Arthur Henrique Eggert");
		setLayout(null);
		
		this.produtores = new ArrayList<>();
		this.consumidores = new ArrayList<>();
		
		inicializaComponentes(qtdProdutores, qtdConsumidor, tamanhoArmazemProdutores);
		setVisible(true);  
		informacoesFinais();
	}

	private void informacoesFinais() throws InterruptedException {
		for (Processo p : this.produtores) {
			p.join();
		}
		for (Processo p : this.consumidores) {
			p.join();
		}

		System.out.println("\nL1311H04 - Arthur Henrique Eggert");
		for (Processo p : this.produtores) {
			System.out.println("Produtos manuseados pelo PRODUTOR 1." + p.getIdentificador() + ": " + p.getTotal());
		}

		for (Processo p : this.consumidores) {
			System.out.println("Produtos manuseados pelo CONSUMIDOR 1." + p.getIdentificador() + ": " + p.getTotal());
		}
	}

	
	private void inicializaComponentes(int qtdProdutores, int qtdConsumidor, int tamanhoArmazem) throws InterruptedException {
		JPanel painel = new JPanel();  
		painel.setLayout(null);

		JScrollPane scroll = new JScrollPane();  
		scroll.setViewportView(painel);  
		
		JPanel panelNome = new JPanel();
		panelNome.setBounds(10, 11, 615, 25);
		painel.add(panelNome);
		panelNome.setLayout(null);
		
		JLabel labeNome = new JLabel("L1311H04 - Arthur Henrique Eggert");
		labeNome.setBounds(0, 0, 268, 25);
		panelNome.add(labeNome);
		
		JLabel labelLinhaProducao = new JLabel("Linha de Produ\u00E7\u00E3o 1");
		labelLinhaProducao.setHorizontalAlignment(SwingConstants.LEFT);
		labelLinhaProducao.setBounds(10, 36, 119, 14);
		painel.add(labelLinhaProducao);
		
		JLabel labelArmazen = new JLabel("Armazen");
		labelArmazen.setHorizontalAlignment(SwingConstants.CENTER);
		labelArmazen.setBounds(10, 36, 615, 14);
		painel.add(labelArmazen);
		
		JLabel labelLinhaConsumo = new JLabel("Linha de Consumo 1");
		labelLinhaConsumo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLinhaConsumo.setBounds(473, 36, 152, 14);
		painel.add(labelLinhaConsumo);
		
		Armazem armazem = new Armazem(tamanhoArmazem);
		
		int yTela = 0;
		
		for (int i = 0, y = 60; i < qtdProdutores; i++ , y+= 150) {
			Produtor produtor = new Produtor(i, armazem);
			PanelGenerico panel = new PanelProdutor(produtor);
			produtor.setPanel(panel);
			this.produtores.add(produtor);
			panel.setBounds(10, y, 171, 150);
			painel.add(panel);
			yTela = y;
		}
		
		armazem.setListaProcessos(this.produtores);
		
		for (int i = 0, y = 60; i < qtdConsumidor; i++, y+= 150) {
			Consumidor consumidor = new Consumidor(i, armazem);
			PanelGenerico panel = new PanelConsumidor(consumidor);
			consumidor.setPanel(panel);
			this.consumidores.add(consumidor);
			panel.setBounds(450, y, 171, 150);
			painel.add(panel);	
			yTela = y > yTela ? yTela = y : yTela;
		}
		

		PanelArmazem armazemPanel = new PanelArmazem(armazem, 1);
		armazemPanel.setBounds(250, 50, 100, 60);
		armazem.setPanel(armazemPanel);
		painel.add(armazemPanel);

		painel.setPreferredSize(new Dimension(600, yTela));

		setContentPane(scroll);  
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}
}