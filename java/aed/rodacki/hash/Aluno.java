package br.com.ahe.aed.rodacki.hash;

public class Aluno {

	private String nome;
	private int matricula;
	private float mediageral;
	private Aluno prox;
	
	public String getNome() {
		return this.nome;
	}
	public int getMatricula() {
		return this.matricula;
	}
	public float getMediageral() {
		return this.mediageral;
	}
	public Aluno getProx() {
		return this.prox;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public void setMediageral(float mediageral) {
		this.mediageral = mediageral;
	}
	public void setProx(Aluno prox) {
		this.prox = prox;
	}
	
	@Override
	public String toString() {
		return "Aluno [nome=" + this.nome + ", matricula=" + this.matricula + ", mediageral=" + this.mediageral + "]";
	}
}
