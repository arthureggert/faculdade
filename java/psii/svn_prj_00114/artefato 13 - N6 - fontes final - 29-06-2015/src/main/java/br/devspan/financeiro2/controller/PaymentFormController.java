package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.PaymentForm;
import br.devspan.financeiro2.service.PaymentFormService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class PaymentFormController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private PaymentFormService service;
	
	@Inject
	private NaviggationController navigationController;
	
	@Getter
	@Setter
	private PaymentForm paymentForm;
	
	@PostConstruct
	public void initNewPaymentForm() {
		paymentForm = new PaymentForm();
	}
	
	public String save() throws Exception {
		try {
			service.register(paymentForm);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewPaymentForm();
			return navigationController.goToPaymentFormPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (paymentForm == null) {
			initNewPaymentForm();
		}
	}
	
	public String delete() {
		service.remove(paymentForm.getId());
		initNewPaymentForm();
		return navigationController.goToPaymentFormPage();
	}
	
	public boolean isNew() {
		return paymentForm.getId() == null;
	}

	public List<PaymentForm> findByName(String name) {
		return service.findByName(name);
	}
	
}
