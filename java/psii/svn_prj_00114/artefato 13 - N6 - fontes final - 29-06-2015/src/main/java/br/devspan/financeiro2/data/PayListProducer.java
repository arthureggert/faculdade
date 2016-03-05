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
import br.devspan.financeiro2.model.Pay;
import br.devspan.financeiro2.service.PayService;

@RequestScoped
public class PayListProducer {
	
	@Inject
	private PayService repository;
	
	@Named
	@Getter
	@Produces
	private List<Pay> pays;
	
	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) Pay firm) {
		retrieveAllPays();
	}
	
	@PostConstruct
	public void retrieveAllPays() {
		pays = repository.findAll();
	}
}
