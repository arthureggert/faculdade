package financeiro.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.picketlink.annotations.PicketLink;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.Attribute;
import org.picketlink.idm.model.IdentityType;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.User;
import org.picketlink.idm.query.AttributeParameter;
import org.picketlink.idm.query.IdentityQuery;
import org.picketlink.idm.query.IdentityQueryBuilder;

import financeiro.app.security.Authorizations;
import financeiro.data.BankAccountRepository;
import financeiro.domain.model.BankAccount;

@Named
@ApplicationScoped
public class BankAccountService {

	public static final String MEMBER_ID_ATTRIBUTE = "employeeId";

	@Inject
	private Event<Authorizations.Modified> authModifiedEvent;

	@Inject
	private IdentityManager idm;

	@Inject
	private RelationshipManager relMgr;

	@Inject
	private BankAccountRepository empRepo;

	public List<User> listUsers() {
		IdentityQuery<User> query = idm.getQueryBuilder().createIdentityQuery(
				User.class);
		return query.getResultList();
	}

	public User getUserForBankAccount(BankAccount bankAccount) {
		IdentityQueryBuilder builder = idm.getQueryBuilder();
		return builder
				.createIdentityQuery(User.class)
				.where(builder.equal(
						new AttributeParameter(MEMBER_ID_ATTRIBUTE),
						bankAccount.getId())).getResultList().get(0);
	}

	public BankAccount getBankAccountByUsername(String username) {
		IdentityQueryBuilder builder = idm.getQueryBuilder();
		Long employeeId = builder.createIdentityQuery(User.class)
				.where(builder.equal(User.LOGIN_NAME, username))
				.getResultList().get(0)
				.<Long> getAttribute(MEMBER_ID_ATTRIBUTE).getValue();
		return empRepo.findBy(employeeId);
	}

	public boolean isUsernameAvailable(String username) {
		IdentityQueryBuilder builder = idm.getQueryBuilder();
		int resultCount = builder.createIdentityQuery(User.class)
				.where(builder.equal(User.LOGIN_NAME, username))
				.getResultCount();
		return resultCount == 0;
	}

	@Transactional(qualifier = PicketLink.class)
	public void registerBankAccount(BankAccount bankAccount, String username,
			String password, String... roles) {
		User user = new User();
		user.setLoginName(username);
		user.setAttribute(new Attribute<Long>(MEMBER_ID_ATTRIBUTE, bankAccount
				.getId()));

		idm.add(user);
		idm.updateCredential(user, new Password(password));

		setRoles(user, roles);
	}

	@Transactional(qualifier = PicketLink.class)
	public void changePassword(BankAccount emp, String password) {
		User user = getUserForBankAccount(emp);
		idm.updateCredential(user, new Password(password));
	}

	@Transactional(qualifier = PicketLink.class)
	public void setRoles(BankAccount bankAccount, String... roles) {
		setRoles(getUserForBankAccount(bankAccount), roles);
		authModifiedEvent.fire(new Authorizations.Modified());
	}

	private void setRoles(IdentityType identity, String... roles) {
		for (String role : roles) {
			BasicModel.grantRole(relMgr, identity,
					BasicModel.getRole(idm, role));
		}
	}

	public List<String> getRoles(User user) {
		List<String> result = new ArrayList<String>();
		return result;
	}

	public List<String> getRoles(BankAccount employee) {
		User user = getUserForBankAccount(employee);
		return getRoles(user);
	}
}
