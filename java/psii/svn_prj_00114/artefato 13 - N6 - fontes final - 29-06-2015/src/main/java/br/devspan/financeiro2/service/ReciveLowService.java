package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

import br.devspan.financeiro2.model.ReceivingLow;
import br.devspan.financeiro2.model.Recive;

@Stateless
public class ReciveLowService {
	
	@Inject
	private EntityManager em;
	
	public ReceivingLow findById(Long id) {
		return em.find(ReceivingLow.class, id);
	}
	
	public void remove(Long entityId) {
		ReceivingLow firm = findById(entityId);
		em.remove(firm);
	}
	
	public void register(ReceivingLow recive) throws Exception {
		if (recive.getId() == null) {
			em.persist(recive);
		} else {
			em.merge(recive);
		}
	}
	
	public List<ReceivingLow> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ReceivingLow> criteria = cb.createQuery(ReceivingLow.class);
		Root<ReceivingLow> recive = criteria.from(ReceivingLow.class);
		criteria.select(recive);
		return em.createQuery(criteria).getResultList();
	}

	public List<ReceivingLow> findByRecive(Recive receber) {
		UaiCriteria<ReceivingLow> query = UaiCriteriaFactory.createQueryCriteria(em, ReceivingLow.class);
		query.andEquals("recive", receber);
		return query.getResultList();
    }
	
}
