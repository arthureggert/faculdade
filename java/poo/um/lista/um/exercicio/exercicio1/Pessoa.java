package br.com.ahe.poo.um.lista.um.exercicio.exercicio1;

import java.math.BigDecimal;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private BigDecimal rendaAnual;
	
	public Pessoa(String nome, String cpf, BigDecimal renda) throws Exception{
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRendaAnual(renda);
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public BigDecimal getRendaAnual() {
		return this.rendaAnual;
	}

	public void setNome(String nome) throws NullPointerException {
		if(nome.isEmpty() || nome == null){
			throw new NullPointerException("Nome não pode ser nulo");
		} else {
			this.nome = nome;			
		}
	}

	public void setCpf(String cpf) throws NullPointerException {
		if(cpf.isEmpty() || cpf == null){
			throw new NullPointerException("CPF não pode ser nulo");
		} else {
			this.cpf = cpf;			
		}
	}

	public void setRendaAnual(BigDecimal rendaAnual) throws NullPointerException,NumberFormatException {
		if(rendaAnual == null || rendaAnual.compareTo(BigDecimal.ZERO) < 0){
			throw new NumberFormatException("Renda não pode ser 0");
		} else {
			this.rendaAnual = rendaAnual;			
		}
	}
}
