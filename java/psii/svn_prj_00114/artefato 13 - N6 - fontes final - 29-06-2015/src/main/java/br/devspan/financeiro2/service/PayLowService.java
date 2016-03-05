package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.Pay;
import br.devspan.financeiro2.model.PayLow;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class PayLowService {
	
	@Inject
	private EntityManager em;
	
	public PayLow findById(Long id) {
		return em.find(PayLow.class, id);
	}
	
	public void remove(Long entityId) {
		PayLow firm = findById(entityId);
		em.remove(firm);
	}
	
	public void register(PayLow recive) throws Exception {
		if (recive.getId() == null) {
			em.persist(recive);
		} else {
			em.merge(recive);
		}
	}
	
	public List<PayLow> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PayLow> criteria = cb.createQuery(PayLow.class);
		Root<PayLow> recive = criteria.from(PayLow.class);
		criteria.select(recive);
		return em.createQuery(criteria).getResultList();
	}

	public List<PayLow> findByPay(Pay pay) {
		UaiCriteria<PayLow> query = UaiCriteriaFactory.createQueryCriteria(em, PayLow.class);
		query.andEquals("pay", pay);
		return query.getResultList();
    }
	
}
