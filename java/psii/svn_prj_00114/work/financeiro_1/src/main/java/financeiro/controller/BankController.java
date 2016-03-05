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
import financeiro.data.BankRepository;
import financeiro.domain.model.Bank;
import financeiro.service.BankService;
import financeiro.view.SecuredPages;
import financeiro.view.resources.NotTaken;

@Controller
@SuppressWarnings({ "unused", "cdi-ambiguous-dependency" })
public class BankController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ViewNavigationHandler view;

	@Inject
	private BankRepository repo;

	@Inject
	private BankService svc;

	@Inject
	private FacesContext faces;

	@Inject
	private ViewStack viewStack;

	@Inject
	private JsfMessage<AppMessages> msg;

	@Inject
	private Event<CurrentEmployee.Modified> bankModEvent;

	private Bank selected;

	@NotTaken
	private String username;

	private List<String> roles;

	@Begin
	public Class<? extends ViewConfig> create() {
		selected = new Bank();
		username = new String();
		return SecuredPages.Bank.class;
	}

	@Begin
	public Class<? extends ViewConfig> edit(Bank bank) {
		selected = bank;
		roles = svc.getRoles(bank);
		username = svc.getUserForBank(bank).getLoginName();
		return SecuredPages.Bank.class;
	}

	public void delete(Bank bank) {
		repo.remove(bank);
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

	public List<Bank> getBanks() {
		return repo.findAll();
	}

	public boolean isNewBank() {
		return selected.getId() == null;
	}

	public Bank getSelected() {
		return selected;
	}

	public void setSelected(Bank selected) {
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
