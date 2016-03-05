package br.com.ahe.ldp.produtor.exem1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class pnlProdutor extends JPanel implements ActionListener {

	Produtor produtor;

	JLabel lbNome;

	JLabel lbTotalProd;

	JLabel lbProd;

	JLabel lbTmpProd;

	JLabel lbStatus;

	JButton btn;

	public pnlProdutor(int id, Armazem a) {

		this.setSize(300, 300);

		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(7, 1));

		this.lbNome = new JLabel(" Produtor " + id);
		this.lbTotalProd = new JLabel(" Total: ");
		this.lbProd = new JLabel(" Produto: ");
		this.lbTmpProd = new JLabel(" Tempo Prod: ");
		this.lbStatus = new JLabel(" Status: ");
		this.btn = new JButton(" Finalizar");
		JLabel label = new JLabel("------------------------------");
		this.btn.addActionListener(this);

		panel.add(this.lbNome);
		panel.add(label);
		panel.add(this.lbTotalProd);
		panel.add(this.lbProd);
		panel.add(this.lbTmpProd);
		panel.add(this.lbStatus);
		panel.add(this.btn);

		this.setBorder(new LineBorder(Color.black));

		this.produtor = new Produtor(id, a, this);
	}

	public void refresh() {

		this.lbStatus.setText(" Status: " + this.produtor.getStatus());
		this.lbProd.setText(" Produto: " + this.produtor.getProd());
		this.lbTotalProd.setText(" Total: " + this.produtor.getContador());

	}



	public void actionPerformed(ActionEvent arg0) {
		this.produtor.terminar();
	}

}
