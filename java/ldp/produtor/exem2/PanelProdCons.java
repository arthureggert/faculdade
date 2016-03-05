package br.com.ahe.ldp.produtor.exem2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelProdCons extends PanelPrincipal {

	private static final long serialVersionUID = 1L;
	private String totalConsProd = "Total cons./prod. . . . . : ", prod = "Produto. . . . . . . . . . . . . : ",
			temConsProd = "Tempo cons./prod. . . : ", status = "status: ";
	private JLabel lbTotalConsProd, lbConsProd, lbTemConsProd, lbStatus;
	private ProdutorConsumidor produtorConsumidor;
	private JPanel panelPri;
	private int i;
	private Font fonte;

	public PanelProdCons(JPanel panelPri, int i, Font fonte,
			ProdutorConsumidor produtorConsumidor) {
		this.produtorConsumidor = produtorConsumidor;
		this.panelPri = panelPri;
		this.i = i;
		this.fonte = fonte;
		initComponents();
	}

	@Override
	public void initComponents() {
		this.setBackground(new Color(248, 248, 248));
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.panelPri.add(this);

		JLabel lbConsProdutor = new JLabel("CONSUMIDOR/PROD. 2." + (this.i + 1));
		lbConsProdutor.setBounds(10, 10, 170, 14);
		lbConsProdutor.setFont(this.fonte);
		this.add(lbConsProdutor);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 248));
		panel.setLayout(null);
		panel.setBounds(0, 30, 175, 90);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		this.add(panel);

		this.lbTotalConsProd = new JLabel(this.totalConsProd + this.produtorConsumidor.getTotal());
		this.lbTotalConsProd.setBounds(20, 10, 160, 14);
		this.lbTotalConsProd.setFont(this.fonte);
		panel.add(this.lbTotalConsProd);

		this.lbConsProd = new JLabel(this.prod + this.produtorConsumidor.getProduto());
		this.lbConsProd.setBounds(20, 35, 160, 14);
		this.lbConsProd.setFont(this.fonte);
		panel.add(this.lbConsProd);

		this.lbTemConsProd = new JLabel(this.temConsProd + this.produtorConsumidor.getTempo());
		this.lbTemConsProd.setBounds(20, 60, 160, 14);
		this.lbTemConsProd.setFont(this.fonte);
		panel.add(this.lbTemConsProd);

		JPanel panelStatus = new JPanel();
		panelStatus.setBackground(new Color(248, 248, 248));
		panelStatus.setLayout(null);
		panelStatus.setBounds(0, 119, 175, 40);
		panelStatus.setBorder(BorderFactory.createTitledBorder(""));
		this.add(panelStatus);

		this.lbStatus = new JLabel(this.status + this.produtorConsumidor.getStatus());
		this.lbStatus.setBounds(30, 12, 150, 14);
		this.lbStatus.setFont(this.fonte);
		panelStatus.add(this.lbStatus);
	}

	@Override
	public void atualizarProcessos() {
		this.lbTotalConsProd.setText(this.totalConsProd + this.produtorConsumidor.getTotal());
		this.lbStatus.setText(this.status + this.produtorConsumidor.getStatus());
		this.lbConsProd.setText(this.prod + this.produtorConsumidor.getProduto());
		this.lbTemConsProd.setText(this.temConsProd + this.produtorConsumidor.getTempo());
	}
}
