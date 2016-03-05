package br.com.ahe.ldp.produtor.exem1;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class ProdutorConsumidorTela extends JFrame {

	Armazem armazem1;

	Armazem armazem2;

	JPanel pnProdutor;

	JPanel pnArmazem1;

	JPanel pnProdCons;

	JPanel pnArmazem2;

	JPanel pnConsumidor;
	
	public ProdutorConsumidorTela(int qtdProdutores, int qtdProdConsumidores,
			int qtdConsumidores, int tamArmazem1, int tamArmazem2) {
		this.setTitle("L102N1G01 - Wagner Jean Reetz");

		JPanel pnPrincipal = new JPanel();
		pnPrincipal.setLayout(new GridLayout(1, 5));

		this.pnProdutor = new JPanel();
		pnPrincipal.add(this.pnProdutor);
		this.pnArmazem1 = new JPanel();
		this.pnArmazem1.setBorder(new LineBorder(Color.black));
		pnPrincipal.add(this.pnArmazem1);
		this.pnProdCons = new JPanel();
		pnPrincipal.add(this.pnProdCons);
		this.pnArmazem2 = new JPanel();
		this.pnArmazem2.setBorder(new LineBorder(Color.black));
		pnPrincipal.add(this.pnArmazem2);
		this.pnConsumidor = new JPanel();
		pnPrincipal.add(this.pnConsumidor);

		this.add(pnPrincipal);

		
		this.setSize(800, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	


}
