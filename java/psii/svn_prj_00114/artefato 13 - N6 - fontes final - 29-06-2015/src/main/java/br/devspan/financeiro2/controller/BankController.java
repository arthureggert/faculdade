package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.Bank;
import br.devspan.financeiro2.service.BankService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class BankController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private BankService service;
	
	@Inject
	private NaviggationController navigationController;
	
	@Getter
	@Setter
	private Bank bank;
	
	@PostConstruct
	public void initNewBank() {
		bank = new Bank();
	}
	
	public String save() throws Exception {
		try {
			service.register(bank);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewBank();
			return navigationController.goToBankPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (bank == null) {
			initNewBank();
		}
	}
	
	public String delete() {
		service.remove(bank.getId());
		initNewBank();
		return navigationController.goToBankPage();
	}
	
	public boolean isNew() {
		return bank.getId() == null;
	}

	public List<Bank> findByName(String name) {
		return service.findByName(name);
	}
	
}
