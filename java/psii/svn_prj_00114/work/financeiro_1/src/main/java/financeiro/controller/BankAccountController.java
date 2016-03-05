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
import financeiro.data.BankAccountRepository;
import financeiro.domain.model.BankAccount;
import financeiro.service.BankAccountService;
import financeiro.view.SecuredPages;
import financeiro.view.resources.NotTaken;

@Controller
@SuppressWarnings({ "unused", "cdi-ambiguous-dependency" })
public class BankAccountController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ViewNavigationHandler view;

	@Inject
	private BankAccountRepository repo;

	@Inject
	private BankAccountService svc;

	@Inject
	private FacesContext faces;

	@Inject
	private ViewStack viewStack;

	@Inject
	private JsfMessage<AppMessages> msg;

	@Inject
	private Event<CurrentEmployee.Modified> bankAccountModEvent;

	private BankAccount selected;

	@NotTaken
	private String username;

	private List<String> roles;

	@Begin
	public Class<? extends ViewConfig> create() {
		selected = new BankAccount();
		username = new String();
		return SecuredPages.BankAccount.class;
	}

	@Begin
	public Class<? extends ViewConfig> edit(BankAccount bankAccount) {
		selected = bankAccount;
		roles = svc.getRoles(bankAccount);
		username = svc.getUserForBankAccount(bankAccount).getLoginName();
		return SecuredPages.BankAccount.class;
	}

	public void delete(BankAccount bankAccount) {
		repo.remove(bankAccount);
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

	public List<BankAccount> getBankAccounts() {
		return repo.findAll();
	}

	public boolean isNewBankAccount() {
		return selected.getId() == null;
	}

	public BankAccount getSelected() {
		return selected;
	}

	public void setSelected(BankAccount selected) {
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
