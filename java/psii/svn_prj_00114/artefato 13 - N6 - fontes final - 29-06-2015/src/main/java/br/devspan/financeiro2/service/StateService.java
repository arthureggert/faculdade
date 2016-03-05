package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.State;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class StateService {
	
	@Inject
	private EntityManager em;
	
	public State findById(Long id) {
		return em.find(State.class, id);
	}
	
	public void remove(Long id) {
		State entity = findById(id);
		em.remove(entity);
	}
	
	public void register(State state) throws Exception {
		if (state.getId() == null) {
			em.persist(state);
		} else {
			em.merge(state);
		}
	}
	
	public List<State> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<State> criteria = cb.createQuery(State.class);
		Root<State> state = criteria.from(State.class);
		criteria.select(state).orderBy(cb.asc(state.get("name")));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<State> findByName(String name) {
		UaiCriteria<State> criteria = UaiCriteriaFactory.createQueryCriteria(em, State.class);
		criteria.andStringLike("name", "%" + name + "%");
		return criteria.getResultList();
	}
}
