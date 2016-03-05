package br.com.ahe.dataminig.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import jpa.AbstractEntity;


@Entity
@Table(name = "stopword", schema = "servicedesk")
@NamedQueries({
	@NamedQuery(name = Stopword.BUSCA_TODOS, 
			    query = "SELECT s.stopword FROM Stopword s") 
})
public class Stopword extends AbstractEntity {
	
	public static final String BUSCA_TODOS = "stopword.buscaTodos"; 
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "stopword")
	private String stopword;
	
	public Stopword() {}
	
	public Stopword(String stopword) {
		this.stopword = stopword;
	}

	public void setStopword(String stopword) {
		this.stopword = stopword;
	}
	
	public String getStopword() {
		return this.stopword;
	}

	@Override
	public String toString() {
		return "Stopword [stopword=" + this.stopword + "]";
	}
	
}
