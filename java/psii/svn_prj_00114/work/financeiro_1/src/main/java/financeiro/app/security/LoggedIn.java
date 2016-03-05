package financeiro.app.security;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Inject;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.apache.deltaspike.security.api.authorization.AccessDecisionVoter;
import org.apache.deltaspike.security.api.authorization.AccessDecisionVoterContext;
import org.apache.deltaspike.security.api.authorization.Secured;
import org.apache.deltaspike.security.api.authorization.SecurityViolation;
import financeiro.app.resources.AppMessages;
import org.picketlink.Identity;

/**
 * Declarative security in
 * {@link org.apache.deltaspike.core.api.config.view.ViewConfig}s. Just a
 * stereotype which hides the {@link Secured} annotation.
 */
@Target({TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Inherited
@Stereotype
@Secured(LoggedIn.LoggedInVoter.class)
public @interface LoggedIn {

    @RequestScoped
    public static class LoggedInVoter implements AccessDecisionVoter {

        private static final long serialVersionUID = 1L;

		@Inject
        private Identity identity;

        @Inject
        private JsfMessage<AppMessages> msg;

        @Override
        public Set<SecurityViolation> checkPermission(AccessDecisionVoterContext accessDecisionVoterContext) {
            if (!identity.isLoggedIn()) {
                return Collections.<SecurityViolation>singleton(new SecurityViolation() {

                    private static final long serialVersionUID = 1L;

					@Override
                    public String getReason() {
						return msg.get().noUserIsLoggedIn();
                    }
                });
            } else {
                return Collections.<SecurityViolation>emptySet();
            }
        }

    }

}
