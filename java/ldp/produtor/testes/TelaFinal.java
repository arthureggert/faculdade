package br.com.ahe.ldp.produtor.testes;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.ahe.ldp.produtor.exem2.Processo;

public class TelaFinal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public TelaFinal(List<Processo> consumidores, List<Processo> produtores) throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		informacoesFinais(consumidores,produtores);
	}
	
	private void informacoesFinais(List<Processo> consumidores, List<Processo> produtores) throws InterruptedException {
		for (Processo p : produtores) {
			p.join();
		}
		for (Processo p : consumidores) {
			p.join();
		}

		System.out.println("\nL1122I07 - Joelvis Roman da Silva");
		for (Processo p : produtores) {
			System.out.println("Produtos manuseados pelo PRODUTOR "
					+ 1 + "." + p.getIdentificador() + ": "
					+ p.getTotal());
		}

		for (Processo p : consumidores) {
			System.out.println("Produtos manuseados pelo CONSUMIDOR "
					+ 1 + "." + p.getIdentificador() + ": "
					+ p.getTotal());
		}
	}

}
