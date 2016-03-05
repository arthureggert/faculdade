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
import br.devspan.financeiro2.model.Bank;
import br.devspan.financeiro2.service.BankService;

@RequestScoped
public class BankListProducer {

	@Inject
	private BankService repository;

	@Named
	@Getter
	@Produces
	private List<Bank> banks;

	public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Bank city) {
		retrieveAllCities();
	}

	@PostConstruct
	public void retrieveAllCities() {
		banks = repository.findAll();
	}
}
