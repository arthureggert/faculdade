package financeiro.app.resources;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.data.api.audit.CurrentUser;
import financeiro.data.MemberRepository;
import financeiro.domain.model.Member;
import financeiro.service.MemberService;
import org.picketlink.Identity;
import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.idm.model.basic.User;

/**
 * Produces the current Employee for use with the Data module's audit
 * capability.
 *
 * The
 * {@link financeiro.domain.model.ExpenseReport}
 * entity has a {@code Employee lastChangedBy} field annotated
 * {@link org.apache.deltaspike.data.api.audit.ModifiedBy}. Upon persisting an
 * ExpenseReport, the Data module looks for a producer of {@code Employee}
 * qualified {@code @CurrentUser}.
 *
 */
@SessionScoped
public class CurrentEmployee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static class Modified {
	}
	
	private Member cached;
	
	@Inject
	private MemberRepository repo;
	
	private void updateCachedEmployee(Identity identity) {
		cached = repo.findBy(identity.getAccount().<Long> getAttribute(MemberService.MEMBER_ID_ATTRIBUTE)
		        .getValue());
	}
	
	public void setOnLogin(@Observes LoggedInEvent event, Identity identity) {
		updateCachedEmployee(identity);
	}
	
	public void setOnModification(@Observes Modified event, Identity identity) {
		updateCachedEmployee(identity);
	}
	
	@Produces
	@Named
	@CurrentUser
	public Member getCurrentEmployee() {
		if (cached != null) {
			cached = repo.merge(cached);
		}
		return cached;
	}
	
	@Produces
	@SessionScoped
	@Named
	@CurrentUser
	public User getCurrentUser(Identity identity) {
		return ((User) identity.getAccount());
	}
	
}
