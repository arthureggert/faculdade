package br.com.ahe.ldp.produtor.L1311H04;

import java.awt.Color;

import javax.swing.JLabel;

public class PanelConsumidor extends PanelGenerico {
	
	private static final long serialVersionUID = 1L;
	
	private Consumidor consumidor;
	
	private JLabel total;
	
	private JLabel produto;
	
	private JLabel tempo;
	
	private JLabel status;
	
	private JLabel titulo;

	public PanelConsumidor(Consumidor cons) {
		super();
		this.consumidor = cons;
		this.inicializacateTela();
	}

	@Override
	public void inicializacateTela() {
		this.titulo = new JLabel("   CONSUMIDOR 1." + this.consumidor.getIdentificador());
		this.titulo.setAlignmentY(CENTER_ALIGNMENT);
		this.titulo.setBounds(0, 0, 175, 25);
		this.titulo.setBorder(Constantes.BORDA);

		this.total = new JLabel(Constantes.TOTALCONSUMIDOR + 0);
		this.total.setBounds(10, 25, 150, 20);

		this.produto = new JLabel(Constantes.PRODUTO + this.consumidor.getProduto());
		this.produto.setBounds(10, 45, 150, 20);

		this.tempo = new JLabel(Constantes.TEMPOCONSUMIDOR + this.consumidor.getTempo());
		this.tempo.setBounds(10, 65, 150, 20);

		this.status = new JLabel(this.consumidor.getStatus().getDescricao());
		this.status.setBounds(10, 85, 150, 20);
		this.status.setForeground(Color.BLUE);

		add(this.titulo);
		add(this.total);
		add(this.produto);
		add(this.tempo);
		add(this.status);
	}

	@Override
	public void atualizar() {
		if(this.consumidor.getStatus().equals(EStatusProcesso.FINALIZADO)){
			this.status.setForeground(Color.RED);
		}
		this.total.setText(Constantes.TOTALCONSUMIDOR + this.consumidor.getTotal());
		this.status.setText(this.consumidor.getStatus().getDescricao());
		this.produto.setText(Constantes.PRODUTO + this.consumidor.getProduto());
	}

	public void atualizarTempo() {
		this.tempo.setText(Constantes.TEMPOCONSUMIDOR + this.consumidor.getTempo());
	}

}
