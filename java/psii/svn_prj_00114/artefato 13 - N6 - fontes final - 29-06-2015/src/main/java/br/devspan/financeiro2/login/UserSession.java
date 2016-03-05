package br.devspan.financeiro2.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.Firm;
import br.devspan.financeiro2.model.User;
import br.devspan.financeiro2.service.FirmService;

@SessionScoped
public class UserSession implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private User sessionUser;
	
	@Inject
	private FirmService firmService;
	
	// TODO: Must return user firm!
	public Firm getSessionFirm() {
		return firmService.findByName("devspan").get(0);
	}
	
}
