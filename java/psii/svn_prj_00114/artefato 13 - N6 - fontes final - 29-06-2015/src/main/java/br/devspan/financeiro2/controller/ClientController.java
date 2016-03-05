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
import br.devspan.financeiro2.model.Client;
import br.devspan.financeiro2.service.ClientService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class ClientController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ClientService service;
	
	@Inject
	private NaviggationController navigationController;
	
	@Inject
	private UserSession session;
	
	@Getter
	@Setter
	private Client client;
	
	@PostConstruct
	public void initNewClient() {
		client = new Client();
	}
	
	public String save() throws Exception {
		client.setFirm(session.getSessionFirm());
		try {
			service.register(client);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewClient();
			return navigationController.goToClientPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (client == null) {
			initNewClient();
		}
	}
	
	public String delete() {
		service.remove(client.getId());
		initNewClient();
		return navigationController.goToClientPage();
	}
	
	public boolean isNew() {
		return client.getId() == null;
	}
	
	public List<Client> findByName(String name) {
		return service.findByName(name);
	}
	
}
