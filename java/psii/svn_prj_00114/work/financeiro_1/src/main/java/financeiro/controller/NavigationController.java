package financeiro.controller;

import java.io.Serializable;

import org.apache.deltaspike.core.api.config.view.ViewConfig;

import financeiro.app.extension.Controller;
import financeiro.app.extension.End;
import financeiro.view.SecuredPages;

@Controller
public class NavigationController implements Serializable {
    
    private static final long serialVersionUID = 1L;

	@End
    public Class<? extends ViewConfig> goHome() {
        return SecuredPages.Home.class;
    }
    
    @End
    public Class<? extends ViewConfig> goToMembers() {
        return SecuredPages.Admin.Members.class;
    }
    
}
