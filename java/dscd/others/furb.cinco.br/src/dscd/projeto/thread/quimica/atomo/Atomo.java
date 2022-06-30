package dscd.projeto.thread.quimica.atomo;

import dscd.projeto.thread.quimica.tabela.TabelaPeriodicaElemento;

public class Atomo {

	private String nome;

	private Integer nox;

	private String sigla;

	private Integer peso;

	private String grupo;

	public Atomo(String nome, Integer nox, String sigla, Integer peso, String grupo) {
		this.nome = nome;
		this.nox = nox;
		this.sigla = sigla;
		this.peso = peso;
		this.grupo = grupo;
	}

	public Atomo(TabelaPeriodicaElemento elemento) {
		this.nome = elemento.getNome();
		this.nox = elemento.getNox();
		this.sigla = elemento.getSigla();
		this.peso = elemento.getPeso();
		this.grupo = elemento.getGrupo();
	}

	public String getNome() {
		return nome;
	}

	public Integer getNox() {
		return nox;
	}

	public String getSigla() {
		return sigla;
	}

	public Integer getPeso() {
		return peso;
	}

	public String getGrupo() {
		return grupo;
	}

	@Override
	public String toString() {
		return "Atomo [nome=" + nome + ", nox=" + nox
				+ ", sigla=" + sigla + ", peso=" + peso + ", grupo=" + grupo
				+ "]";
	}

}