package br.com.ahe.dataminig.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import jpa.AbstractEntity;


@Entity
@Table(name = "chamado", schema = "servicedesk")
public class Chamado extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "status")
	private Character status;
	
	@Column(name = "problema")
	private String problema;

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Character getStatus() {
		return this.status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public String getProblema() {
		return this.problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	@Override
	public String toString() {
		return "Chamado [numero=" + this.numero + ", status=" + this.status + ", problema=" + this.problema + "]\n";
	}
	

}
