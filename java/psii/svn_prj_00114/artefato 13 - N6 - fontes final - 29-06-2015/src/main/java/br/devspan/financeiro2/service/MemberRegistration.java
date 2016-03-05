package br.devspan.financeiro2.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.devspan.financeiro2.model.Member;

@Stateless
public class MemberRegistration {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public void register(Member member) throws Exception {
		log.info("Registering " + member.getName());
		if (member.getId() == null) {
			em.persist(member);
		} else {
			em.merge(member);
		}
	}
}
