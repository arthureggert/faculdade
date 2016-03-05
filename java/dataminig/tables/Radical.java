package br.com.ahe.dataminig.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import jpa.AbstractEntity;

@Entity
@Table(name = "radical", schema = "servicedesk")
@NamedQueries({
	@NamedQuery(name = Radical.BUSCA_POR_PALAVRA, 
			    query = "SELECT r FROM Radical r " +
			    	    "where r.palavra = :palavra") 
})
public class Radical extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	public static final String BUSCA_POR_PALAVRA = "radical.buscaPorPalavra"; 
	
	@Column(name = "palavra")
	private String palavra;
	
	@Column(name = "radical")
	private String radical;
	
	public Radical() {}

	public Radical(String radical, String palavra) {
		this.palavra = palavra;
		this.radical = radical;
	}

	public String getPalavra() {
		return this.palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getRadical() {
		return this.radical;
	}

	public void setRadical(String radical) {
		this.radical = radical;
	}

	@Override
	public String toString() {
		return "Radical [palavra=" + this.palavra + ", radical=" + this.radical + "]";
	}
		
}
