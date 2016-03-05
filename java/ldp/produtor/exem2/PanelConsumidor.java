package br.com.ahe.ldp.produtor.exem2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConsumidor extends PanelPrincipal {

	private static final long serialVersionUID = -1305386479605535241L;
	private String totalCons = "Total consumido. . . . . . : ", prod = "Produto. . . . . . . . . . . . . . : ", 
			temCons = "Tempo de Consumo. . : ", status = "status: ";
	private JLabel lbTotalCons, lbProd, lbTemCons, lbStatus;
	private Consumidor consumidor;
	private JPanel panelPri;
	private Font fonte;
	private int i;
	private int posicaoConsProd;

	public PanelConsumidor(JPanel panelPri, int posicaoConsProd, int i, Font fonte, Consumidor consumidor) {
		this.panelPri = panelPri;
		this.fonte = fonte;
		this.i = i;
		this.consumidor = consumidor;
		this.posicaoConsProd = posicaoConsProd;
		initComponents();
	}

	@Override
	public void initComponents() {
		this.setBackground(new Color(248, 248, 248));
		this.setLayout(null);
		this.setBounds(this.posicaoConsProd, 45 + (this.i * 200), 175, 160);
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.panelPri.add(this);

		JLabel lbConsumidor = new JLabel("CONSUMIDOR 3." + (this.i + 1));
		lbConsumidor.setBounds(40, 10, 130, 14);
		lbConsumidor.setFont(this.fonte);
		this.add(lbConsumidor);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 248));
		panel.setLayout(null);
		panel.setBounds(0, 30, 175, 90);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		this.add(panel);

		this.lbTotalCons = new JLabel(this.totalCons + this.consumidor.getTotal());
		this.lbTotalCons.setBounds(20, 10, 160, 14);
		this.lbTotalCons.setFont(this.fonte);
		panel.add(this.lbTotalCons);

		this.lbProd = new JLabel(this.prod + this.consumidor.getProduto());
		this.lbProd.setBounds(20, 35, 160, 14);
		this.lbProd.setFont(this.fonte);
		panel.add(this.lbProd);

		this.lbTemCons = new JLabel(this.temCons + this.consumidor.getTempo());
		this.lbTemCons.setBounds(20, 60, 160, 14);
		this.lbTemCons.setFont(this.fonte);
		panel.add(this.lbTemCons);

		JPanel panelStatus = new JPanel();
		panelStatus.setBackground(new Color(248, 248, 248));
		panelStatus.setLayout(null);
		panelStatus.setBounds(0, 119, 175, 40);
		panelStatus.setBorder(BorderFactory.createTitledBorder(""));
		this.add(panelStatus);

		this.lbStatus = new JLabel(this.status + this.consumidor.getStatus());
		this.lbStatus.setBounds(30, 12, 130, 14);
		this.lbStatus.setFont(this.fonte);
		panelStatus.add(this.lbStatus);
	}

	@Override
	public void atualizarProcessos() {
		this.lbTotalCons.setText(this.totalCons + this.consumidor.getTotal());
		this.lbStatus.setText(this.status + this.consumidor.getStatus());
		this.lbProd.setText(this.prod + this.consumidor.getProduto());
		this.lbTemCons.setText(this.temCons + this.consumidor.getTempo());
	}
}
