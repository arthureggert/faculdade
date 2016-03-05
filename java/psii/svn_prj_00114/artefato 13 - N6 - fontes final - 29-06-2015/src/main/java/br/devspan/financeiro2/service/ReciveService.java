package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.Recive;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class ReciveService {
	
	@Inject
	private EntityManager em;
	
	public Recive findById(Long id) {
		return em.find(Recive.class, id);
	}
	
	public void remove(Long entityId) {
		Recive firm = findById(entityId);
		em.remove(firm);
	}
	
	public void register(Recive recive) throws Exception {
		if (recive.getId() == null) {
			em.persist(recive);
		} else {
			em.merge(recive);
		}
	}
	
	public List<Recive> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Recive> criteria = cb.createQuery(Recive.class);
		Root<Recive> recive = criteria.from(Recive.class);
		criteria.select(recive);
		return em.createQuery(criteria).getResultList();
	}
	
	public List<Recive> findByName(String name) {
		UaiCriteria<Recive> criteria = UaiCriteriaFactory.createQueryCriteria(em, Recive.class);
		criteria.andStringLike("name", "%" + name + "%");
		return criteria.getResultList();
	}
}
