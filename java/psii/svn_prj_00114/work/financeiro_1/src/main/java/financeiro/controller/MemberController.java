package financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

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
import financeiro.data.MemberRepository;
import financeiro.domain.model.Member;
import financeiro.service.MemberService;
import financeiro.view.SecuredPages;
import financeiro.view.resources.NotTaken;

@Controller
@SuppressWarnings({ "unused", "cdi-ambiguous-dependency" })
public class MemberController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ViewNavigationHandler view;
	
	@Inject
	private MemberRepository repo;
	
	@Inject
	private MemberService svc;
	
	@Inject
	private FacesContext faces;
	
	@Inject
	private ViewStack viewStack;
	
	@Inject
	private PasswordHolder pwdHolder;
	
	@Inject
	private JsfMessage<AppMessages> msg;
	
	@Inject
	@CurrentUser
	private Member currentMember;
	
	@Inject
	private Event<CurrentEmployee.Modified> memberModEvent;
	
	private Member selected;
	
	@NotTaken
	private String username;
	
	private List<String> roles;
	
	@Begin
	public Class<? extends ViewConfig> create() {
		selected = new Member();
		username = new String();
		return SecuredPages.Member.class;
	}
	
	@Begin
	public Class<? extends ViewConfig> edit(Member member) {
		selected = member;
		roles = svc.getRoles(member);
		username = svc.getUserForMember(member).getLoginName();
		return SecuredPages.Member.class;
	}
	
	public void delete(Member member) {
		repo.remove(member);
	}
	
	public Class<? extends ViewConfig> save() {
		if (isNewMember()) {
			svc.registerMember(repo.save(selected), username, pwdHolder.getPassword(), roles.toArray(new String[roles.size()]));
			msg.addInfo().employeeCreated(selected.getFirstName(), selected.getLastName());
		} else {
			svc.setRoles(selected, roles.toArray(new String[roles.size()]));
			repo.save(selected);
			msg.addInfo().allChangesSaved();
			if (selected.equals(currentMember)) {
				memberModEvent.fire(new CurrentEmployee.Modified());
			}
		}
		return viewStack.pop();
	}
	
	@End
	public Class<? extends ViewConfig> cancel() {
		return viewStack.pop();
	}
	
	public List<Member> getMembers() {
		return repo.findAll();
	}
	
	public boolean isNewMember() {
		return selected.getId() == null;
	}
	
	public Member getSelected() {
		return selected;
	}
	
	public void setSelected(Member selected) {
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
	
	@Controller
	public static class PasswordHolder implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Inject
		private FacesContext faces;
		
		@Inject
		private MemberService svc;
		
		@Inject
		private JsfMessage<AppMessages> msg;
		
		@Size(min = 4)
		private String password;
		
		@End
		public void changePassword(Member member, String password) {
			svc.changePassword(member, password);
			msg.addInfo().passwordChanged();
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	
}
