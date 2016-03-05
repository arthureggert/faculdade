package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.State;
import br.devspan.financeiro2.service.StateService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class StateController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private StateService service;

	@Inject
	private NaviggationController navigationController;

	@Getter
	@Setter
	private State state;

	@PostConstruct
	public void initNewState() {
		state = new State();
	}

	public String save() throws Exception {
		try {
			service.register(state);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewState();
			return navigationController.goToStatePage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}

	public void preRenderView() {
		if (state == null) {
			initNewState();
		}
	}

	public String delete() {
		service.remove(state.getId());
		initNewState();
		return navigationController.goToStatePage();
	}

	public boolean isNew() {
		return state.getId() == null;
	}
	
	public List<State> findByName(String name) {
		return service.findByName(name);
	}

}
