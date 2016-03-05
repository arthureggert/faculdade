package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.Firm;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class FirmService {
	
	@Inject
	private EntityManager em;
	
	public Firm findById(Long id) {
		return em.find(Firm.class, id);
	}
	
	public void remove(Long entityId) {
		Firm firm = findById(entityId);
		em.remove(firm);
	}
	
	public void register(Firm firm) throws Exception {
		if (firm.getId() == null) {
			em.persist(firm);
		} else {
			em.merge(firm);
		}
	}
	
	public List<Firm> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Firm> criteria = cb.createQuery(Firm.class);
		Root<Firm> firm = criteria.from(Firm.class);
		criteria.select(firm).orderBy(cb.asc(firm.get("name")));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<Firm> findByName(String name) {
		UaiCriteria<Firm> criteria = UaiCriteriaFactory.createQueryCriteria(em, Firm.class);
		criteria.andStringLike("name", "%" + name + "%");
		return criteria.getResultList();
	}
}
