package br.com.ahe.aed.outros;


public class Aluno {
	
	private String nome;
	
	private int matricula;
	
	private float mediageral;
	
	private Aluno prox;
	
	public Aluno() {
	}

	public Aluno(String nome, int matricula, float mediageral) {
		setNome(nome);
		setMatricula(matricula);
		setMediageral(mediageral);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public float getMediageral() {
		return this.mediageral;
	}

	public void setMediageral(float mediageral) {
		this.mediageral = mediageral;
	}

	public Aluno getProx() {
		return this.prox;
	}

	public void setProx(Aluno prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + this.nome + ", matricula=" + this.matricula
				+ ", mediageral=" + this.mediageral + ", prox=" + this.prox + "]";
	}

}
