package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.AccountRegisterType;
import br.devspan.financeiro2.service.AccountRegisterTypeService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class AccountRegisterTypeController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private AccountRegisterTypeService service;
	
	@Inject
	private NaviggationController navigationController;
	
	@Getter
	@Setter
	private AccountRegisterType accountRegisterType;
	
	@PostConstruct
	public void initNewAccountRegisterType() {
		accountRegisterType = new AccountRegisterType();
	}
	
	public String save() throws Exception {
		try {
			service.register(accountRegisterType);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewAccountRegisterType();
			return navigationController.goToAccountRegisterTypePage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (accountRegisterType == null) {
			initNewAccountRegisterType();
		}
	}
	
	public String delete() {
		service.remove(accountRegisterType.getId());
		initNewAccountRegisterType();
		return navigationController.goToAccountRegisterTypePage();
	}
	
	public boolean isNew() {
		return accountRegisterType.getId() == null;
	}

	public List<AccountRegisterType> findByName(String name) {
		return service.findByName(name);
	}
	
}
