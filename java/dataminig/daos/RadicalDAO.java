package br.com.ahe.dataminig.daos;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import jpa.AbstractGenericDAO;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import utils.AJPAUtils;
import br.com.ahe.dataminig.tables.Radical;

@Component
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RadicalDAO extends AbstractGenericDAO<Radical, Long> {

	public RadicalDAO() {
		super(Radical.class);
	}

	public Radical findByRadical(String palavra) {
		TypedQuery<Radical> qRadical = AJPAUtils.createNamedQuery(getEm(), Radical.BUSCA_POR_PALAVRA, Radical.class);
		qRadical.setParameter("palavra", palavra);
		try {
			return qRadical.getSingleResult();			
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}

}
