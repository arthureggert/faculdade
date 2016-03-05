package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.AccountRegisterType;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class AccountRegisterTypeService {
	
	@Inject
	private EntityManager em;
	
	public AccountRegisterType findById(Long id) {
		return em.find(AccountRegisterType.class, id);
	}
	
	public void remove(Long id) {
		AccountRegisterType bank = findById(id);
		em.remove(bank);
	}
	
	public void register(AccountRegisterType bank) throws Exception {
		if (bank.getId() == null) {
			em.persist(bank);
		} else {
			em.merge(bank);
		}
	}
	
	public List<AccountRegisterType> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AccountRegisterType> criteria = cb.createQuery(AccountRegisterType.class);
		Root<AccountRegisterType> accountregistertype = criteria.from(AccountRegisterType.class);
		criteria.select(accountregistertype).orderBy(cb.asc(accountregistertype.get("description")));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<AccountRegisterType> findByName(String name) {
		UaiCriteria<AccountRegisterType> criteria = UaiCriteriaFactory.createQueryCriteria(em, AccountRegisterType.class);
		criteria.andStringLike("description", "%" + name + "%");
		return criteria.getResultList();
	}
}
