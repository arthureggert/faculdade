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
import br.devspan.financeiro2.model.AccountRegisterType;
import br.devspan.financeiro2.model.BankAccount;
import br.devspan.financeiro2.service.AccountRegisterTypeService;

@RequestScoped
public class AccountRegisterTypeListProducer {
	
	@Inject
	private AccountRegisterTypeService repository;
	
	@Named
	@Getter
	@Produces
	private List<AccountRegisterType> accountRegisterTypes;
	
	public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final BankAccount city) {
		retrieveAllAccountRegisterTypes();
	}
	
	@PostConstruct
	public void retrieveAllAccountRegisterTypes() {
		accountRegisterTypes = repository.findAll();
	}
}
