package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.Recive;
import br.devspan.financeiro2.service.ReciveService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class ReciveController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private ReciveService service;

	@Inject
	private NaviggationController navigationController;

	@Getter
	@Setter
	private Recive recive;

	@PostConstruct
	public void initNewRecive() {
		recive = new Recive();
	}

	public String save() throws Exception {
		try {
			service.register(recive);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewRecive();
			return navigationController.goToRecivePage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}

	public void preRenderView() {
		if (recive == null) {
			initNewRecive();
		}
	}

	public String delete() {
		service.remove(recive.getId());
		initNewRecive();
		return navigationController.goToRecivePage();
	}

	public boolean isNew() {
		return recive.getId() == null;
	}
	
	public List<Recive> findByName(String name) {
		return service.findByName(name);
	}

}
