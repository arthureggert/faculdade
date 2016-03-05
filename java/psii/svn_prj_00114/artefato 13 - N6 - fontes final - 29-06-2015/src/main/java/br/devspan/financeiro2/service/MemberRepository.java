
package br.devspan.financeiro2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.devspan.financeiro2.model.Member;

@Stateless
public class MemberRepository {

	@Inject
	private EntityManager em;

	public Member findById(Long id) {
		return em.find(Member.class, id);
	}

	public void remove(Long entityId) {
		Member entity = findById(entityId);
		em.remove(entity);
	}

	public Member findByEmail(String email) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
		Root<Member> member = criteria.from(Member.class);
		criteria.select(member).where(cb.equal(member.get("email"), email));
		return em.createQuery(criteria).getSingleResult();
	}

	public List<Member> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
		Root<Member> member = criteria.from(Member.class);
		criteria.select(member).orderBy(cb.asc(member.get("name")));
		return em.createQuery(criteria).getResultList();
	}
}
