package br.com.ahe.ldp.produtor.L1311H04;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelArmazem extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel[] caixas;
	private JLabel[] inicioFila;
	private JLabel[] fimFila;
	private final int tamanho;

	public PanelArmazem(Armazem armazem, int id) {
		this.tamanho = armazem.getTamanho();

		this.caixas = new JLabel[this.tamanho];
		this.inicioFila = new JLabel[this.tamanho];
		this.fimFila = new JLabel[this.tamanho];

		this.setLayout(null);
		this.setBorder(Constantes.BORDA);

		this.initComponents(id);

	}

	public void initComponents(int id) {

		for (int i = 0; i < this.tamanho; i++) {
			this.inicioFila[i] = new JLabel();
			this.inicioFila[i].setBounds(10, i * 20 + 20, 20, 20);

			this.caixas[i] = new JLabel("0");
			this.caixas[i].setBounds(30, i * 20 + 20, 20, 20);
			this.caixas[i].setBorder(Constantes.BORDA);

			this.fimFila[i] = new JLabel();
			this.fimFila[i].setBounds(80, i * 20 + 20, 20, 20);

			add(this.caixas[i]);
			add(this.inicioFila[i]);
			add(this.fimFila[i]);
		}

		this.inicioFila[0].setText(">");
		this.fimFila[0].setText("<");
	}

	public void atualizar(int[] armazem, int inicio, int fim) {
		for (int i = 0; i < this.tamanho; i++) {
			if (i == inicio) {
				this.inicioFila[i].setText(">");
			} else {
				this.inicioFila[i].setText("");
			}

			if (i == fim) {
				this.fimFila[i].setText("<");
			} else {
				this.fimFila[i].setText("");
			}
			this.caixas[i].setText(armazem[i] + "");
		}
	}

}
