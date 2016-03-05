package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.Bank;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class BankService {
	
	@Inject
	private EntityManager em;
	
	public Bank findById(Long id) {
		return em.find(Bank.class, id);
	}
	
	public void remove(Long id) {
		Bank bank = findById(id);
		em.remove(bank);
	}
	
	public void register(Bank bank) throws Exception {
		if (bank.getId() == null) {
			em.persist(bank);
		} else {
			em.merge(bank);
		}
	}
	
	public List<Bank> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Bank> criteria = cb.createQuery(Bank.class);
		Root<Bank> bank = criteria.from(Bank.class);
		criteria.select(bank).orderBy(cb.asc(bank.get("name")));
		return em.createQuery(criteria).getResultList();
	}

	public List<Bank> findByName(String name) {
		UaiCriteria<Bank> criteria = UaiCriteriaFactory.createQueryCriteria(em, Bank.class);
		criteria.andStringLike("name", "%" + name + "%");
		return criteria.getResultList();
	}
}
