package br.devspan.financeiro2.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.devspan.financeiro2.model.Firm;
import br.devspan.financeiro2.service.FirmService;

@RequestScoped
public class FirmListProducer {
	
	@Inject
	private FirmService repository;
	
	private List<Firm> firms;
	
	@Produces
	@Named
	public List<Firm> getFirms() {
		return firms;
	}
	
	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) Firm firm) {
		retrieveAllFirms();
	}
	
	@PostConstruct
	public void retrieveAllFirms() {
		firms = repository.findAll();
	}
}
