package br.com.ahe.ldp.produtor.exem1;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class relatorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public relatorio(ArrayList lista) {
		JTextArea txt = new JTextArea();

		this.setLayout(new BorderLayout());

		Collections.sort(lista, new Comparator() {
			public int compare(Object o1, Object o2) {
				String c1 = "" + ((Processo) o1).getContador();
				String c2 = "" + ((Processo) o2).getContador();
				return c2.compareTo(c1);
			}
		});

		String texto = "";
		
		this.setLayout(new GridLayout(lista.size(),1));

		for (Iterator it = lista.iterator(); it.hasNext();) {
			Processo proc =(Processo) it.next();
			texto = ""+proc.getContador();
			texto = texto + "   =   "+ proc.getNome();
			

			this.add(new JLabel(texto));
			
			

		}

	
	
		
		this.setSize(200, 20 * lista.size());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
