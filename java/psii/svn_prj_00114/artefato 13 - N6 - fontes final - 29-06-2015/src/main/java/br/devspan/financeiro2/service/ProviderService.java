package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.Provider;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class ProviderService {
	
	@Inject
	private EntityManager em;
	
	public Provider findById(Long id) {
		return em.find(Provider.class, id);
	}
	
	public void remove(Long entityId) {
		Provider firm = findById(entityId);
		em.remove(firm);
	}
	
	public void register(Provider provider) throws Exception {
		if (provider.getId() == null) {
			em.persist(provider);
		} else {
			em.merge(provider);
		}
	}
	
	public List<Provider> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Provider> criteria = cb.createQuery(Provider.class);
		Root<Provider> provider = criteria.from(Provider.class);
		criteria.select(provider).orderBy(cb.asc(provider.get("name")));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<Provider> findByName(String name) {
		UaiCriteria<Provider> criteria = UaiCriteriaFactory.createQueryCriteria(em, Provider.class);
		criteria.andStringLike("name", "%" + name + "%");
		return criteria.getResultList();
	}
}
