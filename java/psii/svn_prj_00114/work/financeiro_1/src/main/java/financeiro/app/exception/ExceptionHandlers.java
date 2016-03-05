package financeiro.app.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.config.view.DefaultErrorView;
import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.apache.deltaspike.security.api.authorization.ErrorViewAwareAccessDeniedException;
import financeiro.app.resources.AppMessages;
import financeiro.view.Login;

/**
 * During development, exceptions won't get handled and will be shown directly.
 */
@Exclude(ifProjectStage = ProjectStage.Development.class)
@ExceptionHandler
public class ExceptionHandlers {

    @Inject
    private FacesContext faces;

    @Inject
    private ViewNavigationHandler view;

    @Inject
    private JsfMessage<AppMessages> msg;

    public void handleAppException(@Handles ExceptionEvent<ApplicationException> evt) {
        faces.getExternalContext().getFlash().setKeepMessages(true);
        faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, evt.getException().getMessage(), null));
        evt.handled();
    }

    // doesn't work for some reason
//    public void handleAccessDeniedException(@BeforeHandles ExceptionEvent<? extends AccessDeniedException> evt) {
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, evt.getException().getMessage(), null));
//        view.navigateTo(Login.class);
//        evt.handled();
//    }
    public void handleAccessDeniedException(@Handles ExceptionEvent<ErrorViewAwareAccessDeniedException> evt) {
        // need this to keep messages between redirects
        faces.getExternalContext().getFlash().setKeepMessages(true);
        view.navigateTo(Login.class);
        evt.handled();
    }

    public void handleOtherExceptions(@Handles ExceptionEvent<Exception> evt) {
        msg.addError().unknownErrorOccurred();
        // need this to keep messages between redirects
        faces.getExternalContext().getFlash().setKeepMessages(true);
        Logger.getLogger(ExceptionHandlers.class.getName()).log(Level.SEVERE, "Handled exception", evt.getException());
        view.navigateTo(DefaultErrorView.class);
        evt.handled();
    }

}
