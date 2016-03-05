package financeiro.view;

import static financeiro.domain.model.MemberRole.ADMIN;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View;

import financeiro.app.extension.ViewStacked;
import financeiro.app.security.LoggedIn;
import financeiro.app.security.RolesAllowed;

@LoggedIn
@ViewStacked
@Folder(name = "/secured")
@View(navigation = View.NavigationMode.REDIRECT)
public interface SecuredPages extends ViewConfig {
	
	class Home implements SecuredPages {}
	
	class Member implements SecuredPages {}

	class City implements SecuredPages {}

	class State implements SecuredPages {}
	
	class Bank implements SecuredPages {}
	
	class BankAccount implements SecuredPages {}
	
	@RolesAllowed(ADMIN)
	interface Admin extends SecuredPages {
		
		class Members implements Admin {}
		
	}
	
}
