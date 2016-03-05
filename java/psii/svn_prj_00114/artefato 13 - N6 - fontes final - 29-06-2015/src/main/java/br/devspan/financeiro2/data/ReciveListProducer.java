package br.devspan.financeiro2.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import br.devspan.financeiro2.model.Recive;
import br.devspan.financeiro2.service.ReciveService;

@RequestScoped
public class ReciveListProducer {
	
	@Inject
	private ReciveService repository;
	
	@Named
	@Getter
	@Produces
	private List<Recive> recives;
	
	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) Recive firm) {
		retrieveAllRecives();
	}
	
	@PostConstruct
	public void retrieveAllRecives() {
		recives = repository.findAll();
	}
}
