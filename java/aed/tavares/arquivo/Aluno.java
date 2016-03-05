package br.com.ahe.aed.tavares.arquivo;

public class Aluno {
	
	private int vinculo;
	private LimitString nome ;
	private Byte curso;
	private LimitString endreco;
	
	public Aluno(int vinculo, LimitString nome, Byte curso, LimitString endreco) {
		this.vinculo = vinculo;
		this.nome = nome;
		this.curso = curso;
		this.endreco = endreco;
	}
	
	public Aluno(){
		
	}

	public int getVinculo() {
		return this.vinculo;
	} 
	
	public LimitString getNome() {
		return this.nome;
	}
	
	public Byte getCurso() {
		return this.curso;
	}
	
	public LimitString getEndreco() {
		return this.endreco;
	}
	
	public void setVinculo(int vinculo) {
		this.vinculo = vinculo;
	}
	
	public void setNome(LimitString nome) {
		this.nome = nome;
	}
	
	public void setCurso(Byte curso) {
		this.curso = curso;
	}
	
	public void setEndreco(LimitString endreco) {
		this.endreco = endreco;
	}

	@Override
	public String toString() {
		return "Aluno [vinculo=" + this.vinculo + ", nome=" + this.nome + ", curso=" + this.curso + ", endreco=" + this.endreco + "]";
	}
	
	

	
}
	