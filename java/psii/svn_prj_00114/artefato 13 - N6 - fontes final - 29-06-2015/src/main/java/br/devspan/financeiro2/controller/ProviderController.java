package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.login.UserSession;
import br.devspan.financeiro2.model.Provider;
import br.devspan.financeiro2.service.ProviderService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class ProviderController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ProviderService service;
	
	@Inject
	private NaviggationController navigationController;
	
	@Inject
	private UserSession session;
	
	@Getter
	@Setter
	private Provider provider;
	
	@PostConstruct
	public void initNewProvider() {
		provider = new Provider();
	}
	
	public String save() throws Exception {
		provider.setFirm(session.getSessionFirm());
		try {
			service.register(provider);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewProvider();
			return navigationController.goToProviderPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (provider == null) {
			initNewProvider();
		}
	}
	
	public String delete() {
		service.remove(provider.getId());
		initNewProvider();
		return navigationController.goToProviderPage();
	}
	
	public boolean isNew() {
		return provider.getId() == null;
	}
	
	public List<Provider> findByName(String name) {
		return service.findByName(name);
	}
	
}
