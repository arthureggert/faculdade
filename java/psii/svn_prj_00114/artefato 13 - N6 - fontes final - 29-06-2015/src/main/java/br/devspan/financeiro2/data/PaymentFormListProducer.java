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
import br.devspan.financeiro2.model.PaymentForm;
import br.devspan.financeiro2.service.PaymentFormService;

@RequestScoped
public class PaymentFormListProducer {

	@Inject
	private PaymentFormService repository;

	@Named
	@Getter
	@Produces
	private List<PaymentForm> paymentForms;

	public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) PaymentForm city) {
		retrieveAllPaymentForms();
	}

	@PostConstruct
	public void retrieveAllPaymentForms() {
		paymentForms = repository.findAll();
	}
}
