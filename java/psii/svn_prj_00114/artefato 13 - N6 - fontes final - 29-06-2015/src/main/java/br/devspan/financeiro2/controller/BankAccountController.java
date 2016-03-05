package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.BankAccount;
import br.devspan.financeiro2.service.BankAccountService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class BankAccountController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private BankAccountService service;
	
	@Inject
	private NaviggationController navigationController;
	
	@Getter
	@Setter
	private BankAccount bankAccount;
	
	@PostConstruct
	public void initNewBankAccount() {
		bankAccount = new BankAccount();
	}
	
	public String save() throws Exception {
		try {
			service.register(bankAccount);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewBankAccount();
			return navigationController.goToBankAccountPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (bankAccount == null) {
			initNewBankAccount();
		}
	}
	
	public String delete() {
		service.remove(bankAccount.getId());
		initNewBankAccount();
		return navigationController.goToBankAccountPage();
	}
	
	public boolean isNew() {
		return bankAccount.getId() == null;
	}

	public List<BankAccount> findByName(String name) {
		return service.findByName(name);
	}
	
}
