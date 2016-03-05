package br.com.ahe.dataminig.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import jpa.AbstractEntity;


@Entity
@Table(name = "sinonimo", schema = "servicedesk")
@NamedQueries({
	@NamedQuery(name = Sinonimo.BUSCA_POR_PALAVRA, 
			    query = "SELECT s FROM Sinonimo s " +
			    	    "where s.palavra = :palavra") 
})
public class Sinonimo extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	public static final String BUSCA_POR_PALAVRA = "sinonimo.buscaPorPalavra";
	
	@Column(name = "palavra")
	private String palavra;
	
	@Column(name = "sinonimo")
	private String sinomimo;

	public Sinonimo() {}
	
	public Sinonimo(String sinonimo, String palavra) {
		this.palavra = palavra;
		this.sinomimo = sinonimo;
	}

	public String getPalavra() {
		return this.palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getSinomimo() {
		return this.sinomimo;
	}

	public void setSinomimo(String sinomimo) {
		this.sinomimo = sinomimo;
	}

	@Override
	public String toString() {
		return "Sinonimo [palavra=" + this.palavra + ", sinomimo=" + this.sinomimo + "]";
	}
	
}
