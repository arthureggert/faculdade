package br.devspan.financeiro2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.City;
import br.devspan.financeiro2.service.CityService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class CityController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private CityService service;
	
	@Inject
	private NaviggationController navigationController;
	
	@Getter
	@Setter
	private City city;
	
	@PostConstruct
	public void initNewCity() {
		city = new City();
	}
	
	public String save() throws Exception {
		try {
			service.register(city);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewCity();
			return navigationController.goToCityPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (city == null) {
			initNewCity();
		}
	}
	
	public String delete() {
		service.remove(city.getId());
		initNewCity();
		return navigationController.goToCityPage();
	}
	
	public boolean isNew() {
		return city.getId() == null;
	}

	public List<City> findByName(String name) {
		return service.findByName(name);
	}
	
}
