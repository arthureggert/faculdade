package br.com.ahe.aed.provas.prova3;

public class Aluno {
	
   private String nome;
   private int nacionalidade;
   private int idade;
   private float mediaEnem;
   
   public Aluno(int nacionalidade, char[] nome, int idade) {
       this.nome = new String(nome);
       this.nacionalidade = nacionalidade;
       this.idade = idade;
   }

   public String getNome() {
	   return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNacionalidade() {
		return this.nacionalidade;
	}
	
	public void setNacionalidade(int nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public float getMediaEnem() {
		return this.mediaEnem;
	}
	
	public void setMediaEnem(float mediaEnem) {
		this.mediaEnem = mediaEnem;
	}
	   
  
}


