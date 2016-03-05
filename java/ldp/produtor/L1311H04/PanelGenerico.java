package br.com.ahe.ldp.produtor.L1311H04;

import javax.swing.JPanel;

public abstract class PanelGenerico extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelGenerico() {
		this.setLayout(null);
		this.setBorder(Constantes.BORDA);
	}

	public abstract void inicializacateTela();

	public abstract void atualizar();

	public abstract void atualizarTempo();
}
