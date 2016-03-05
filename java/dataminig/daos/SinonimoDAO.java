package br.com.ahe.dataminig.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import jpa.AbstractGenericDAO;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import utils.AJPAUtils;
import br.com.ahe.dataminig.tables.Sinonimo;

@Component
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SinonimoDAO extends AbstractGenericDAO<Sinonimo, Long> {

	public SinonimoDAO() {
		super(Sinonimo.class);
	}

	public List<Sinonimo> findByPalavra(String palavra) {
		TypedQuery<Sinonimo> qSinonimo = AJPAUtils.createNamedQuery(getEm(), Sinonimo.BUSCA_POR_PALAVRA, Sinonimo.class);
		qSinonimo.setParameter("palavra", palavra);
		return qSinonimo.getResultList();			
	}

}
