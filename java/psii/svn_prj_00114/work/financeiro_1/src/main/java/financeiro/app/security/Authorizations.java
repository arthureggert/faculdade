package financeiro.app.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.data.api.audit.CurrentUser;
import financeiro.domain.model.MemberRole;
import financeiro.service.MemberService;
import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.idm.model.basic.User;

/**
 * This is a utility bean that may be used by the view layer to determine
 * whether the current user has specific privileges.
 */
@Named("idm")
@SessionScoped
public class Authorizations implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Dummy used as event payload.
	 */
	public static class Modified {}
	
	@Inject
	private MemberService empSvc;
	
	@Inject
	@CurrentUser
	private User currentUser;
	
	private Set<String> currentRoles;
	
	private boolean isAdmin;
	
	public Authorizations() {
		currentRoles = new HashSet<String>();
	}
	
	public void refreshOnModification(@Observes Modified event) {
		refreshRoles();
	}
	
	public void setOnLogin(@Observes LoggedInEvent event) {
		refreshRoles();
	}
	
	private void refreshRoles() {
		currentRoles.clear();
		currentRoles.addAll(empSvc.getRoles(currentUser));
		isAdmin = currentRoles.contains(MemberRole.ADMIN);
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public boolean hasRole(String roleName) {
		return currentRoles.contains(roleName);
	}
	
	public boolean hasAnyRole(String... roleNames) {
		for (String roleName : roleNames) {
			if (hasRole(roleName)) {
				return true;
			}
		}
		return false;
	}
}
