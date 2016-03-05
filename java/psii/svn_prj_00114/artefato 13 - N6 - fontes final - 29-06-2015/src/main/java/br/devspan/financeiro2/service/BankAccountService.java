package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.BankAccount;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class BankAccountService {
	
	@Inject
	private EntityManager em;
	
	public BankAccount findById(Long id) {
		return em.find(BankAccount.class, id);
	}
	
	public void remove(Long id) {
		BankAccount bank = findById(id);
		em.remove(bank);
	}
	
	public void register(BankAccount bank) throws Exception {
		if (bank.getId() == null) {
			em.persist(bank);
		} else {
			em.merge(bank);
		}
	}
	
	public List<BankAccount> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BankAccount> criteria = cb.createQuery(BankAccount.class);
		Root<BankAccount> bank = criteria.from(BankAccount.class);
		criteria.select(bank).orderBy(cb.asc(bank.get("description")));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<BankAccount> findByName(String name) {
		UaiCriteria<BankAccount> criteria = UaiCriteriaFactory.createQueryCriteria(em, BankAccount.class);
		criteria.andStringLike("description", "%" + name + "%");
		return criteria.getResultList();
	}
}
