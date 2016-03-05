package financeiro.app;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.lifecycle.Initialized;

// import static financeiro.domain.model.MemberRole.*;
// import financeiro.data.MemberRepository;
// import financeiro.domain.model.Member;

public class DemoInitializer {
	
//	@Inject
//	private MemberRepository empRepo;
	
	@Inject
	private ContextControl ctxCtl;
	
//	@Inject
//	private IDMInitializer idmInit;
	
	public void initialize(@Observes @Initialized ServletContext ctx) throws Exception {
		
		ctxCtl.startContext(SessionScoped.class);
		ctxCtl.startContext(RequestScoped.class);
		ctxCtl.startContext(ConversationScoped.class);
		
//		Member admin = empRepo.save(new Member("Arthur Henrique", "Eggert", "opa.roa@gmail.com", "4733874011"));
		// Member john = empRepo.save(new Member("John", "Employee",
		// "john@example.com", "987654321"));
		// Member anna = empRepo.save(new Member("Anna", "Accountant",
		// "anna@example.com", "654321987"));
		//
//		idmInit.initializeRoles();
		//
//		idmInit.registerEmployee(admin, "admin2", "admin2", USER, ADMIN);
		// idmInit.registerEmployee(john, "john", "john", EMPLOYEE);
		// idmInit.registerEmployee(anna, "anna", "anna", EMPLOYEE, ACCOUNTANT);
		
		ctxCtl.stopContext(ConversationScoped.class);
		ctxCtl.stopContext(RequestScoped.class);
		ctxCtl.stopContext(SessionScoped.class);
	}
	
}
