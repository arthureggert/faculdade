package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.Firm;
import br.devspan.financeiro2.service.FirmService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class FirmController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private FirmService service;

	@Inject
	private NaviggationController navigationController;

	@Getter
	@Setter
	private Firm firm;

	@PostConstruct
	public void initNewState() {
		firm = new Firm();
	}

	public String save() throws Exception {
		try {
			service.register(firm);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewState();
			return navigationController.goToFirmPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}

	public void preRenderView() {
		if (firm == null) {
			initNewState();
		}
	}

	public String delete() {
		service.remove(firm.getId());
		initNewState();
		return navigationController.goToFirmPage();
	}

	public boolean isNew() {
		return firm.getId() == null;
	}
	
	public List<Firm> findByName(String name) {
		return service.findByName(name);
	}

}
