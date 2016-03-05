package br.com.ahe.ldp.fila;

public class FilaLista {

	private NoLista ini;
	private NoLista fim;
	private int qtdade = 0;

	public FilaLista() {
		this.ini = null;
		this.fim = null;
	}

	public void insere(String info) {
		NoLista novo = new NoLista();
		novo.setInfo(info);
		novo.setProx(null);
		if (this.fim != null) {
			this.fim.setProx(novo);
		} else {
			this.ini = novo;
		}
		this.fim = novo;
		this.qtdade++;
	}

	public boolean vazio() {
		return this.ini == null && this.fim == null;
	}

	public void libera() {
		this.ini = null;
		this.fim = null;
	}

	public String xsPrimeiros(int v) {
		NoLista n = this.ini;
		String s = "LISTAGEM DOS " + v + " PRIMEIROS DA FILA\n";
		while (n != null && v != 0) {
			s += n.getInfo() + " ";
			n = n.getProx();
			v--;
		}
		return s;
	}

	public String xsUltimos(int v) {
		NoLista n = this.ini;
		String s = "LISTAGEM DOS " + v + " ULTIMOS DA FILA\n";
		int t = this.qtdade - v;
		int i = 0;
		while (n != null) {
			if (i >= t) {
				s += n.getInfo() + " ";
			}
			i++;
			n = n.getProx();
		}
		return s;
	}
}
