package br.com.ahe.ldp.produtor.exem2;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelArmazem extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel[] numArmazem;
	private JLabel[] iniFila;
	private JLabel[] fimFila;
	private Font fonte;
	private final int TAMANHO;

	public PanelArmazem(Armazem armazem, Font fonte) {
		this.fonte = fonte;
		setLayout(null);
		this.TAMANHO = armazem.getTamanho();
		this.numArmazem = new JLabel[this.TAMANHO];
		this.iniFila = new JLabel[this.TAMANHO];
		this.fimFila = new JLabel[this.TAMANHO];
		this.initComponents();

	}

	public void initComponents() {
		for (int i = 0; i < this.TAMANHO; i++) {
			this.iniFila[i] = new JLabel();
			this.iniFila[i].setBounds(10, i * 20, 20, 20);
			this.numArmazem[i] = new JLabel("0");
			this.numArmazem[i].setBounds(30, i * 20, 50, 20);
			this.fimFila[i] = new JLabel();
			this.fimFila[i].setBounds(80, i * 20, 20, 20);
			add(this.numArmazem[i]).setFont(this.fonte);
			add(this.iniFila[i]).setFont(this.fonte);
			add(this.fimFila[i]).setFont(this.fonte);
		}
		this.iniFila[0].setText(">");
		this.fimFila[0].setText("<");
	}

	public void atualizar(int[] armazem, int inicio, int fim) {
		for (int i = 0; i < this.TAMANHO; i++) {
			if (i == inicio) {
				this.iniFila[i].setText(">");
			} else {
				this.iniFila[i].setText("");
			}
			if (i == fim) {
				this.fimFila[i].setText("<");
			} else {
				this.fimFila[i].setText("");
			}
			this.numArmazem[i].setText(armazem[i] + "");
		}
	}
}
