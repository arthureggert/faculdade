package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.Client;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Stateless
public class ClientService {
	
	@Inject
	private EntityManager em;
	
	public Client findById(Long id) {
		return em.find(Client.class, id);
	}
	
	public void remove(Long entityId) {
		Client firm = findById(entityId);
		em.remove(firm);
	}
	
	public void register(Client client) throws Exception {
		if (client.getId() == null) {
			em.persist(client);
		} else {
			em.merge(client);
		}
	}
	
	public List<Client> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Client> criteria = cb.createQuery(Client.class);
		Root<Client> client = criteria.from(Client.class);
		criteria.select(client).orderBy(cb.asc(client.get("name")));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<Client> findByName(String name) {
		UaiCriteria<Client> criteria = UaiCriteriaFactory.createQueryCriteria(em, Client.class);
		criteria.andStringLike("name", "%" + name + "%");
		return criteria.getResultList();
	}
}
