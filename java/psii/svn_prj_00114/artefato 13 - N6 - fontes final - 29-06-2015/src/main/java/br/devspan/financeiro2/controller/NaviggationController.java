package br.devspan.financeiro2.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class NaviggationController {
	
	public String goToUserPage() {
		return "/pages/protected/admin/members.xhtml?faces-redirect=true";
	}
	
	public String goToFirmPage() {
		return "/pages/protected/admin/firms.xhtml?faces-redirect=true";
	}
	
	public String goToCityPage() {
		return "/pages/protected/user/cities.xhtml?faces-redirect=true";
	}
	
	public String goToStatePage() {
		return "/pages/protected/user/states.xhtml?faces-redirect=true";
	}
	
	public String goToBankPage() {
		return "/pages/protected/user/banks.xhtml?faces-redirect=true";
	}
	
	public String goToBankAccountPage() {
		return "/pages/protected/user/bankaccounts.xhtml?faces-redirect=true";
	}
	
	public String goToClientPage() {
		return "/pages/protected/user/clients.xhtml?faces-redirect=true";
	}
	
	public String goToProviderPage() {
		return "/pages/protected/user/providers.xhtml?faces-redirect=true";
	}
	
	public String goToAccountRegisterTypePage() {
		return "/pages/protected/user/accountregistertypes.xhtml?faces-redirect=true";
	}

	public String goToPaymentFormPage() {
		return "/pages/protected/user/paymentforms.xhtml?faces-redirect=true";
	}
	
	public String goToRecivePage() {
		return "/pages/protected/user/revices.xhtml?faces-redirect=true";
	}
	
	public String goToPayPage() {
		return "/pages/protected/user/pays.xhtml?faces-redirect=true";
	}
	
	public String goToHomePage() {
		return "/pages/protected/index.xhtml?faces-redirect=true";
	}
}

