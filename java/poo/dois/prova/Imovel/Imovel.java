package br.com.ahe.poo.dois.prova.Imovel;

import java.io.Serializable;

public class Imovel implements Serializable{

	private static final long serialVersionUID = 1L;
	private int qtdComodos;
	private double valor;
	private char tipo;
	private char operacao;
	private String nome;
	private String telefone;
	private String endereco;
	private String bairro;
	private String cidade;

	public Imovel() {
	}

	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public String getCidade() {
		return this.cidade;
	}
	
	public int getQtdComodos() {
		return this.qtdComodos;
	}

	public double getValor() {
		return this.valor;
	}

	public char getTipo() {
		return this.tipo;
	}

	public char getOperacao() {
		return this.operacao;
	}

	public void setQtdComodos(int qtdComodos) {
		this.qtdComodos = qtdComodos;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public void setOperacao(char operacao) {
		this.operacao = operacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (this.bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!this.bairro.equals(other.bairro))
			return false;
		if (this.cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!this.cidade.equals(other.cidade))
			return false;
		if (this.operacao != other.operacao)
			return false;
		if (this.tipo != other.tipo)
			return false;
		if (Double.doubleToLongBits(this.valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	

}
