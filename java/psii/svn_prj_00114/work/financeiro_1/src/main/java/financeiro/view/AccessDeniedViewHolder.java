package financeiro.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.exception.control.BeforeHandles;
import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.apache.deltaspike.security.api.authorization.ErrorViewAwareAccessDeniedException;
import financeiro.app.extension.CurrentView;

/**
 * A helper which holds the view that was requested and resulted in an access
 * denied exception.
 */
@SessionScoped
@ExceptionHandler
@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
public class AccessDeniedViewHolder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext faces;
	
	@Inject
	@CurrentView
	private Instance<Class> currentView;
	
	private Class<? extends ViewConfig> deniedView;
	
	@SuppressWarnings("")
	public void rememberDeniedView(@BeforeHandles ExceptionEvent<ErrorViewAwareAccessDeniedException> evt) {
		deniedView = currentView.get();
		evt.handledAndContinue();
	}
	
	public Class<? extends ViewConfig> getDeniedView() {
		return deniedView;
	}
	
	public void resetDeniedView() {
		this.deniedView = null;
	}
	
	public boolean hasDeniedView() {
		return deniedView != null;
	}
	
}
