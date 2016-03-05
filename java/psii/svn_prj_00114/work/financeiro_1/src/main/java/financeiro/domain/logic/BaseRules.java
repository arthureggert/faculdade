package financeiro.domain.logic;

import javax.enterprise.inject.Typed;
import javax.inject.Inject;

import org.apache.deltaspike.data.api.audit.CurrentUser;

import financeiro.app.security.Authorizations;
import financeiro.domain.model.Member;

/**
 * Contains state-transfer conditions and authorization rules for
 * ExpenseReports.
 */
@Typed(BaseRules.class)
public class BaseRules implements Rules {
	

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Authorizations auth;
	
	@Inject
	@CurrentUser
	private Member currentEmployee;
	
}
