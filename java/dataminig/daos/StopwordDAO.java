package br.com.ahe.dataminig.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import jpa.AbstractGenericDAO;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import utils.AJPAUtils;
import br.com.ahe.dataminig.tables.Stopword;

@Component
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StopwordDAO extends AbstractGenericDAO<Stopword, Long> {

	public StopwordDAO() {
		super(Stopword.class);
	}

	public List<String> findAllAsString(){
		TypedQuery<String> qSW = AJPAUtils.createNamedQuery(getEm(), Stopword.BUSCA_TODOS, String.class);
		return qSW.getResultList();
	}
	
}
