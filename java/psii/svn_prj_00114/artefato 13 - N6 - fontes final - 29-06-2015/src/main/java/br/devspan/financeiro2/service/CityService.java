package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.City;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class CityService {
	
	@Inject
	private EntityManager em;
	
	public City findById(Long id) {
		return em.find(City.class, id);
	}
	
	public void remove(Long id) {
		City entity = findById(id);
		em.remove(entity);
	}
	
	public void register(City city) throws Exception {
		if (city.getId() == null) {
			em.persist(city);
		} else {
			em.merge(city);
		}
	}
	
	public List<City> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<City> criteria = cb.createQuery(City.class);
		Root<City> city = criteria.from(City.class);
		criteria.select(city).orderBy(cb.asc(city.get("name")));
		return em.createQuery(criteria).getResultList();
	}

	public List<City> findByName(String name) {
		UaiCriteria<City> criteria = UaiCriteriaFactory.createQueryCriteria(em, City.class);
		criteria.andStringLike("name", "%" + name + "%");
		return criteria.getResultList();
	}
}
