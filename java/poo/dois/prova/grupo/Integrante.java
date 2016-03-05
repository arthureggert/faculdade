package br.com.ahe.poo.dois.prova.grupo;

public class Integrante implements Comparable<Integrante>{

	private String nome;
	private int idade;
	private String sexo;	
	
	public Integrante(String nome, int idade, String sexo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public String getNome() {
		return this.nome;
	}
	public int getIdade() {
		return this.idade;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Integrante [nome=" + this.nome + ", idade=" + this.idade + ", sexo=" + this.sexo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.idade;
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
		result = prime * result + ((this.sexo == null) ? 0 : this.sexo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Integrante other = (Integrante) obj;
		if (this.idade != other.idade)
			return false;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		if (this.sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!this.sexo.equals(other.sexo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Integrante o) {
        if (getIdade() < o.getIdade()) {
            return -1;
        } 
        if (getIdade() > o.getIdade()) {
            return +1;
        }        
        return 0;
	}
	
	
}
