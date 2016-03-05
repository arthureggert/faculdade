package br.com.ahe.ldp.produtor.L1311H04;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelProdutor extends PanelGenerico {

	private static final long serialVersionUID = 1L;
	
	private Produtor produtor;
	
	private JLabel total;
	
	private JLabel produto;
	
	private JLabel tempo;
	
	private JLabel status;
	
	private JLabel titulo;
	
	private JButton finalizar;

	public PanelProdutor(Produtor prod) {
		super();
		this.produtor = prod;
		this.inicializacateTela();
	}

	@Override
	public void inicializacateTela() {
		this.titulo = new JLabel("    PRODUTOR 1." + this.produtor.getIdentificador());
		this.titulo.setBounds(0, 0, 175, 25);
		this.titulo.setBorder(Constantes.BORDA);

		this.total = new JLabel(Constantes.TOTALPRODUTOR + 0);
		this.total.setBounds(10, 25, 150, 20);

		this.produto = new JLabel(Constantes.PRODUTO + this.produtor.getProduto());
		this.produto.setBounds(10, 45, 150, 20);

		this.tempo = new JLabel(Constantes.TEMPOPRODUTOR + this.produtor.getTempo());
		this.tempo.setBounds(10, 65, 150, 20);

		this.status = new JLabel(this.produtor.getStatus().getDescricao());
		this.status.setBounds(10, 85, 150, 20);
		this.status.setForeground(Color.blue);

		this.finalizar = new JButton("FINALIZAR");
		this.finalizar.setBounds(10, 110, 135, 20);

		this.finalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PanelProdutor.this.produtor.terminar();
				PanelProdutor.this.finalizar.setEnabled(false);
			}
		});

		add(this.titulo);
		add(this.total);
		add(this.produto);
		add(this.tempo);
		add(this.status);
		add(this.finalizar);
	}

	@Override
	public void atualizar() {
		if(this.produtor.getStackTrace().equals(EStatusProcesso.FINALIZADO)){
			this.status.setForeground(Color.RED);
		}
		this.total.setText(Constantes.TOTALPRODUTOR + this.produtor.getTotal());
		this.status.setText(this.produtor.getStatus().getDescricao());
		this.produto.setText(Constantes.PRODUTO + this.produtor.getProduto());
	}

	public void atualizarTempo() {
		this.tempo.setText(Constantes.TEMPOPRODUTOR + this.produtor.getTempo());
	}

}