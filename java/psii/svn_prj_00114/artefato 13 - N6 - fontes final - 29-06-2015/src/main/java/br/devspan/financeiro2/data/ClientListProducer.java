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
import br.devspan.financeiro2.model.Client;
import br.devspan.financeiro2.service.ClientService;

@RequestScoped
public class ClientListProducer {
	
	@Inject
	private ClientService repository;
	
	@Named
	@Getter
	@Produces
	private List<Client> clients;
	
	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) Client client) {
		retrieveAllClients();
	}
	
	@PostConstruct
	public void retrieveAllClients() {
		clients = repository.findAll();
	}
}
