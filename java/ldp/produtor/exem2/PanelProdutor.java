package br.com.ahe.ldp.produtor.exem2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelProdutor extends PanelPrincipal {
	private static final long serialVersionUID = 1L;

	private String totalProd = "Total produzido. . . . . : ", prod = "Produto. . . . . . . . . . . . : ",
			temProd = "Tempo de produ��o: ", status = "status: ";
	private JLabel lbTotalProd, lbProd, lbTemProd, lbStatus;
	private Produtor produtor;
	private JButton btFinalizacao;
	private JPanel panelPri;
	private Font fonte;
	private int i;

	public PanelProdutor(JPanel panelPri, Font fonte, int i, Produtor produtor) {
		this.panelPri = panelPri;
		this.fonte = fonte;
		this.i = i;
		this.produtor = produtor;
		initComponents();
	}

	@Override
	public void initComponents() {
		this.setBackground(new Color(248, 248, 248));
		this.setLayout(null);
		this.setBounds(20, 45 + (this.i * 200), 175, 186);
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.panelPri.add(this);

		JLabel lbProdutor = new JLabel("PRODUTOR 1." + (this.i + 1));
		lbProdutor.setBounds(40, 10, 120, 14);
		lbProdutor.setFont(this.fonte);
		this.add(lbProdutor);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 248));
		panel.setLayout(null);
		panel.setBounds(0, 30, 175, 90);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		this.add(panel);

		this.lbTotalProd = new JLabel(this.totalProd + this.produtor.getTotal());
		this.lbTotalProd.setBounds(20, 10, 160, 14);
		this.lbTotalProd.setFont(this.fonte);
		panel.add(this.lbTotalProd);

		this.lbProd = new JLabel(this.prod + this.produtor.getProduto());
		this.lbProd.setBounds(20, 35, 160, 14);
		this.lbProd.setFont(this.fonte);
		panel.add(this.lbProd);

		this.lbTemProd = new JLabel(this.temProd + this.produtor.getTempo());
		this.lbTemProd.setBounds(20, 60, 160, 14);
		this.lbTemProd.setFont(this.fonte);
		panel.add(this.lbTemProd);

		JPanel panelStatus = new JPanel();
		panelStatus.setBackground(new Color(248, 248, 248));
		panelStatus.setLayout(null);
		panelStatus.setBounds(0, 119, 175, 40);
		panelStatus.setBorder(BorderFactory.createTitledBorder(""));
		this.add(panelStatus);

		this.lbStatus = new JLabel(this.status + this.produtor.getStatus());
		this.lbStatus.setBounds(30, 12, 130, 14);
		this.lbStatus.setFont(this.fonte);
		panelStatus.add(this.lbStatus);

		this.btFinalizacao = new JButton("BOT�O DE FINALIZA��O");
		this.btFinalizacao.setBounds(0, 159, 175, 26);
		this.add(this.btFinalizacao);
		this.btFinalizacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				PanelProdutor.this.produtor.terminar();
			}
		});
	}

	@Override
	public void atualizarProcessos() {
		this.lbTotalProd.setText(this.totalProd + this.produtor.getTotal());
		this.lbStatus.setText(this.status + this.produtor.getStatus());
		this.lbProd.setText(this.prod + this.produtor.getProduto());
		this.lbTemProd.setText(this.temProd + this.produtor.getTempo());
	}
}
