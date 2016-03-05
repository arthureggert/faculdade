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
import br.devspan.financeiro2.model.State;
import br.devspan.financeiro2.service.StateService;

@RequestScoped
public class StateListProducer {

	@Inject
	private StateService repository;

	@Named
	@Getter
	@Produces
	private List<State> states;

	public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final State state) {
		retrieveAllStates();
	}

	@PostConstruct
	public void retrieveAllStates() {
		states = repository.findAll();
	}
}
