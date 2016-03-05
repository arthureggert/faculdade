package financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.apache.deltaspike.data.api.audit.CurrentUser;
import org.apache.deltaspike.jsf.api.message.JsfMessage;

import financeiro.app.extension.Begin;
import financeiro.app.extension.Controller;
import financeiro.app.extension.End;
import financeiro.app.extension.ViewStack;
import financeiro.app.resources.AppMessages;
import financeiro.app.resources.CurrentEmployee;
import financeiro.data.CityRepository;
import financeiro.domain.model.City;
import financeiro.service.CityService;
import financeiro.view.SecuredPages;

@Controller
@SuppressWarnings({ "unused", "cdi-ambiguous-dependency" })
public class CityController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ViewNavigationHandler view;

	@Inject
	private CityRepository repo;

	@Inject
	private CityService svc;

	@Inject
	private FacesContext faces;

	@Inject
	private ViewStack viewStack;

	@Inject
	private JsfMessage<AppMessages> msg;

	@Inject
	private Event<CurrentEmployee.Modified> cityModEvent;

	private City selected;

	private List<String> roles;

	@Begin
	public Class<? extends ViewConfig> create() {
		selected = new City();
		return SecuredPages.City.class;
	}

	@Begin
	public Class<? extends ViewConfig> edit(City city) {
		selected = city;
		return SecuredPages.City.class;
	}

	public void delete(City city) {
		repo.remove(city);
	}

	public Class<? extends ViewConfig> save() {
		repo.save(selected);
		msg.addInfo().allChangesSaved();
		return viewStack.pop();
	}

	@End
	public Class<? extends ViewConfig> cancel() {
		return viewStack.pop();
	}

	public List<City> getCities() {
		return repo.findAll();
	}

	public boolean isNewCity() {
		return selected.getId() == null;
	}

	public City getSelected() {
		return selected;
	}

	public void setSelected(City selected) {
		this.selected = selected;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
