package financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.apache.deltaspike.jsf.api.message.JsfMessage;

import financeiro.app.extension.Begin;
import financeiro.app.extension.Controller;
import financeiro.app.extension.End;
import financeiro.app.extension.ViewStack;
import financeiro.app.resources.AppMessages;
import financeiro.app.resources.CurrentEmployee;
import financeiro.data.StateRepository;
import financeiro.domain.model.State;
import financeiro.service.StateService;
import financeiro.view.SecuredPages;
import financeiro.view.resources.NotTaken;

@Controller
@SuppressWarnings({ "unused", "cdi-ambiguous-dependency" })
public class StateController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ViewNavigationHandler view;

	@Inject
	private StateRepository repo;

	@Inject
	private StateService svc;

	@Inject
	private FacesContext faces;

	@Inject
	private ViewStack viewStack;

	@Inject
	private JsfMessage<AppMessages> msg;

	@Inject
	private Event<CurrentEmployee.Modified> stateModEvent;

	private State selected;

	@NotTaken
	private String username;

	private List<String> roles;

	@Begin
	public Class<? extends ViewConfig> create() {
		selected = new State();
		username = new String();
		return SecuredPages.State.class;
	}

	@Begin
	public Class<? extends ViewConfig> edit(State state) {
		selected = state;
		roles = svc.getRoles(state);
		username = svc.getUserForState(state).getLoginName();
		return SecuredPages.State.class;
	}

	public void delete(State state) {
		repo.remove(state);
	}

	public Class<? extends ViewConfig> save() {
		svc.setRoles(selected, roles.toArray(new String[roles.size()]));
		repo.save(selected);
		msg.addInfo().allChangesSaved();
		return viewStack.pop();
	}

	@End
	public Class<? extends ViewConfig> cancel() {
		return viewStack.pop();
	}

	public List<State> getStates() {
		return repo.findAll();
	}

	public boolean isNewState() {
		return selected.getId() == null;
	}

	public State getSelected() {
		return selected;
	}

	public void setSelected(State selected) {
		this.selected = selected;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
