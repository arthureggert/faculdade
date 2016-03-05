package br.com.ahe.ldp.produtor.exem1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class pnlProdCons extends JPanel {

	ProdutorConsumidor prodCons;

	JLabel lbNome;

	JLabel lbTotalProd;

	JLabel lbProd;

	JLabel lbTmpProd;

	JLabel lbStatus;

	public pnlProdCons(int id, Armazem a1, Armazem a2) {

		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 1));
		this.lbNome = new JLabel(" Prod/Cons " + id);
		panel.add(this.lbNome);
		JLabel lbDivisor = new JLabel("------------------------------");
		panel.add(lbDivisor);
		this.lbTotalProd = new JLabel(" Total: ");
		panel.add(this.lbTotalProd);
		this.lbProd = new JLabel(" Produto: ");
		panel.add(this.lbProd);
		this.lbTmpProd = new JLabel(" Tempo prod: ");
		panel.add(this.lbTmpProd);
		this.lbStatus = new JLabel(" Status:");
		panel.add(this.lbStatus);

		panel.setBorder(new LineBorder(Color.black));

		this.prodCons = new ProdutorConsumidor(id, a1, a2, this);

	}

	public void refresh() {

		this.lbStatus.setText(" Status: " + this.prodCons.getStatus());
		this.lbProd.setText(" Produto: " + this.prodCons.getProd());
		this.lbTotalProd.setText(" Total: " + this.prodCons.getContador());

	}

}
