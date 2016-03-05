package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.Pay;

@Stateless
public class PayService {
	
	@Inject
	private EntityManager em;
	
	public Pay findById(Long id) {
		return em.find(Pay.class, id);
	}
	
	public void remove(Long entityId) {
		Pay firm = findById(entityId);
		em.remove(firm);
	}
	
	public void register(Pay pay) throws Exception {
		if (pay.getId() == null) {
			em.persist(pay);
		} else {
			em.merge(pay);
		}
	}
	
	public List<Pay> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pay> criteria = cb.createQuery(Pay.class);
		Root<Pay> pay = criteria.from(Pay.class);
		criteria.select(pay);
		return em.createQuery(criteria).getResultList();
	}
	
}
