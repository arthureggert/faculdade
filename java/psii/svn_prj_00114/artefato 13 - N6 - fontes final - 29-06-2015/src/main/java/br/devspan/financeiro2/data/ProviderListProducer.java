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
import br.devspan.financeiro2.model.Provider;
import br.devspan.financeiro2.service.ProviderService;

@RequestScoped
public class ProviderListProducer {
	
	@Inject
	private ProviderService repository;
	
	@Named
	@Getter
	@Produces
	private List<Provider> providers;
	
	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) Provider provider) {
		retrieveAllProviders();
	}
	
	@PostConstruct
	public void retrieveAllProviders() {
		providers = repository.findAll();
	}
}
