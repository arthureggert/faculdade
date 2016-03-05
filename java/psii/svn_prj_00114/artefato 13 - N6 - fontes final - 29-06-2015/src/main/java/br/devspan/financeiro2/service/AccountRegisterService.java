package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.AccountRegister;

@Stateless
public class AccountRegisterService {
	
	@Inject
	private EntityManager em;
	
	public AccountRegister findById(Long id) {
		return em.find(AccountRegister.class, id);
	}
	
	public void remove(Long id) {
		AccountRegister bank = findById(id);
		em.remove(bank);
	}
	
	public void register(AccountRegister accountRegister) throws Exception {
		if (accountRegister.getId() == null) {
			em.persist(accountRegister);
		} else {
			em.merge(accountRegister);
		}
	}
	
	public List<AccountRegister> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AccountRegister> criteria = cb.createQuery(AccountRegister.class);
		Root<AccountRegister> accountRegister = criteria.from(AccountRegister.class);
		criteria.select(accountRegister);
		return em.createQuery(criteria).getResultList();
	}
}
