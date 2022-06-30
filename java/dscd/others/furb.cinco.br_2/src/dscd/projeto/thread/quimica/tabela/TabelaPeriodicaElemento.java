package dscd.projeto.thread.quimica.tabela;

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
		return "TabelaPeriodicaElemento [nome=" + nome + ", nox=" + nox
				+ ", sigla=" + sigla + ", peso=" + peso + ", grupo=" + grupo
				+ "]";
	}
}
