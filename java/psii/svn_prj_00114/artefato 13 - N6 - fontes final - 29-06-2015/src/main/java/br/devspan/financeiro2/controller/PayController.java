package br.devspan.financeiro2.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.Pay;
import br.devspan.financeiro2.service.PayService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class PayController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private PayService service;
	
	@Inject
	private NaviggationController navigationController;
	
	@Getter
	@Setter
	private Pay pay;
	
	@PostConstruct
	public void initNewPay() {
		pay = new Pay();
	}
	
	public String save() throws Exception {
		try {
			service.register(pay);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewPay();
			return navigationController.goToPayPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (pay == null) {
			initNewPay();
		}
	}
	
	public String delete() {
		service.remove(pay.getId());
		initNewPay();
		return navigationController.goToPayPage();
	}
	
	public boolean isNew() {
		return pay.getId() == null;
	}
	
}
