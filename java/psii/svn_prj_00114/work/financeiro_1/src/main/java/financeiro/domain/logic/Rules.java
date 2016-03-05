package financeiro.domain.logic;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.core.util.metadata.AnnotationInstanceProvider;

import financeiro.app.security.Authorizations;

public interface Rules extends Serializable {
	
	public static class Producer {
		
		@Inject
		private Authorizations auth;
		
		@Produces
		@Named("rules")
		@SessionScoped
		public Rules produceRules() {
			if (auth.isAdmin()) {
				// the qualifier is needed due to DELTASPIKE-739
				return BeanProvider.getContextualReference(AdminRules.class, AnnotationInstanceProvider.of(AdminRules.Annotation.class));
			} else {
				return BeanProvider.getContextualReference(BaseRules.class);
			}
		}
		
	}
	
}
