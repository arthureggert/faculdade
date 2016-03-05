package br.com.ahe.ldp.produtor.exem1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ProdutorConsumidorControl {

	Armazem armazem1;

	Armazem armazem2;

	ProdutorConsumidorTela tela;

	pnlProdutor produtores[];

	pnlProdCons prodcons[];

	pnlConsumidor consumidores[];

	Processo processos[];

	relatorio relatorio;

	int qtdProcessos;

	int qtdProdutoresAtivos;
	
	int qtdProdConsAtivos;

	int qtdProdutores;
	int qtdProdCons;

	public ProdutorConsumidorControl() {

		this.qtdProdutores = Integer.parseInt(JOptionPane
				.showInputDialog("Informe a quantidade de produtores ..."));

		int tamArmazem1 = Integer.parseInt(JOptionPane
				.showInputDialog("Informe o tamanho do armazem1 ..."));

		this.qtdProdCons = Integer
				.parseInt(JOptionPane
						.showInputDialog("Informe a quantidade de produtores/consumidores ..."));

		int tamArmazem2 = Integer.parseInt(JOptionPane
				.showInputDialog("Informe o tamanho do armazem2 ..."));

		int qtdConsumidores = Integer.parseInt(JOptionPane
				.showInputDialog("Informe a quantidade de consumidores ..."));

		this.qtdProcessos = this.qtdProdutores + this.qtdProdCons + qtdConsumidores;
		this.produtores = new pnlProdutor[this.qtdProdutores];
		this.prodcons = new pnlProdCons[this.qtdProdCons];
		this.consumidores = new pnlConsumidor[qtdConsumidores];
		this.processos = new Processo[this.qtdProcessos];

		this.qtdProdutoresAtivos = this.qtdProdutores;
		this.qtdProdConsAtivos = this.qtdProdCons;

		this.tela = new ProdutorConsumidorTela(this.qtdProdutores, this.qtdProdCons,
				qtdConsumidores, tamArmazem1, tamArmazem2);

		Armazem armazem1 = new Armazem(this, tamArmazem1, this.qtdProdutores);
		Armazem armazem2 = new Armazem(this, tamArmazem2, this.qtdProdCons);

		this.tela.pnArmazem1.add(armazem1);
		this.tela.pnArmazem2.add(armazem2);

		int iProc = 0;
		// criar produtores
		for (int i = 0; i < this.qtdProdutores; i++) {
			this.produtores[i] = new pnlProdutor(i + 1, armazem1);
			this.processos[iProc] = ((Processo) this.produtores[i].produtor);
			this.tela.pnProdutor.add(this.produtores[i]);
			iProc++;
		}

		// criar Prodconsumidores
		for (int i = 0; i < this.qtdProdCons; i++) {
			this.prodcons[i] = new pnlProdCons(i + 1, armazem1, armazem2);
			this.processos[iProc] = ((Processo) this.prodcons[i].prodCons);
			this.tela.pnProdCons.add(this.prodcons[i]);
			iProc++;
		}

		// criar consumidores
		for (int i = 0; i < qtdConsumidores; i++) {
			this.consumidores[i] = new pnlConsumidor(i + 1, armazem2);
			this.processos[iProc] = ((Processo) this.consumidores[i].consumidor);
			this.tela.pnConsumidor.add(this.consumidores[i]);
			iProc++;
		}

		JMenuBar barraMenu = new JMenuBar();
		JMenu menu = new JMenu("Relat�rio");
		JMenuItem item = new JMenuItem("Gerar Relat�rio");

		menu.add(item);
		barraMenu.add(menu);
		this.tela.setJMenuBar(barraMenu);

		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRel();
			}
		});

		this.tela.setVisible(true);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void gerarRel() {

		boolean procAtivo = false;

		ArrayList lista = new ArrayList();

		for (int i = 0; i < this.qtdProcessos; i++) {
			if (!this.processos[i].isFlagTerminar()) {
				procAtivo = true;
			}
			lista.add(this.processos[i]);
			

		}

		if (!procAtivo) {
			this.relatorio = new relatorio(lista);
			
			
			this.tela.repaint();

		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"N�o foi poss�vel gerar o relat�rio, finalize os produtores e espere para que todos os processos sejam finalizados...");

		}

	}

	public static void main(String[] args) {
		new ProdutorConsumidorControl();
	}

	public int getQtdProdutoresAtivos() {
		int qtdAtivos = 0;
		for (int i = 0; i < this.qtdProdutores; i++) {
			if ((this.produtores[i].produtor.getStatus() != "Finalizado")) {
				qtdAtivos++;
			}

		}

		this.setQtdProdutoresAtivos(qtdAtivos);

		return this.qtdProdutoresAtivos;
	}

	public void setQtdProdutoresAtivos(int qtdProdutoresAtivos) {
		this.qtdProdutoresAtivos = qtdProdutoresAtivos;
	}
	
	public int getQtdProdConsAtivos() {
		int qtdAtivos = 0;
		for (int i = 0; i < this.qtdProdCons; i++) {
			if ((this.prodcons[i].prodCons.getStatus() != "Finalizado")) {
				qtdAtivos++;
			}

		}

		this.setQtdProdConsAtivos(qtdAtivos);

		return this.qtdProdConsAtivos;
	}

	public void setQtdProdConsAtivos(int qtdProdConsAtivos) {
		this.qtdProdConsAtivos = qtdProdConsAtivos;
	}

}
