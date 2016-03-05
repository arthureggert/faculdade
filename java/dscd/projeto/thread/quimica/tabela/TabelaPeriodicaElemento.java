package br.com.ahe.dscd.projeto.thread.quimica.tabela;

public class TabelaPeriodicaElemento {

	private String nome;
	
	private Integer nox;
	
	private String sigla;
	
	private Integer peso;
	
	private String grupo;

	public TabelaPeriodicaElemento(String nome, Integer nox, String sigla, Integer peso, String grupo) {
		this.nome = nome;
		this.nox = nox;
		this.sigla = sigla;
		this.peso = peso;
		this.grupo = grupo;
	}

	public String getNome() {
		return this.nome;
	}

	public Integer getNox() {
		return this.nox;
	}

	public String getSigla() {
		return this.sigla;
	}

	public Integer getPeso() {
		return this.peso;
	}

	public String getGrupo() {
		return this.grupo;
	}

	@Override
	public String toString() {
		return "TabelaPeriodicaElemento [nome=" + this.nome + ", nox=" + this.nox
				+ ", sigla=" + this.sigla + ", peso=" + this.peso + ", grupo=" + this.grupo
				+ "]";
	}
}
