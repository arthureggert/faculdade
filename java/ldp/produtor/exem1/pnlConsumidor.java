package br.com.ahe.ldp.produtor.exem1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class pnlConsumidor extends JPanel {

	private static final long serialVersionUID = 1L;

	Consumidor consumidor;

	JLabel lbNome;

	JLabel lbTotalProd;

	JLabel lbProd;

	JLabel lbTmpProd;

	JLabel lbStatus;

	public pnlConsumidor(int id, Armazem a) {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 1));
		this.lbNome = new JLabel(" Consumidor " + id);
		panel.add(this.lbNome);
		JLabel lbDivisor = new JLabel("------------------------------");
		panel.add(lbDivisor);
		this.lbTotalProd = new JLabel(" Total: ");
		panel.add(this.lbTotalProd);
		this.lbProd = new JLabel(" Produto: ");
		panel.add(this.lbProd);
		this.lbTmpProd = new JLabel(" Tempo prod: ");
		panel.add(this.lbTmpProd);
		this.lbStatus = new JLabel(" Status: ");
		panel.add(this.lbStatus);

		panel.setBorder(new LineBorder(Color.black));

		this.consumidor = new Consumidor(id, a, this);

	}

	public void refresh() {
		this.lbStatus.setText(" Status: " + this.consumidor.getStatus());
		this.lbProd.setText(" Produto: " + this.consumidor.getProd());
		this.lbTotalProd.setText(" Total: " + this.consumidor.getContador());
		this.repaint();

	}

}
