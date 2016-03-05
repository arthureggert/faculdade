package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.PaymentForm;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class PaymentFormService {
	
	@Inject
	private EntityManager em;
	
	public PaymentForm findById(Long id) {
		return em.find(PaymentForm.class, id);
	}
	
	public void remove(Long id) {
		PaymentForm bank = findById(id);
		em.remove(bank);
	}
	
	public void register(PaymentForm paymentForm) throws Exception {
		if (paymentForm.getId() == null) {
			em.persist(paymentForm);
		} else {
			em.merge(paymentForm);
		}
	}
	
	public List<PaymentForm> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PaymentForm> criteria = cb.createQuery(PaymentForm.class);
		Root<PaymentForm> paymentform = criteria.from(PaymentForm.class);
		criteria.select(paymentform).orderBy(cb.asc(paymentform.get("description")));
		return em.createQuery(criteria).getResultList();
	}

	public List<PaymentForm> findByName(String name) {
		UaiCriteria<PaymentForm> criteria = UaiCriteriaFactory.createQueryCriteria(em, PaymentForm.class);
		criteria.andStringLike("description", "%" + name + "%");
		return criteria.getResultList();
	}
}
