package br.devspan.financeiro2.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.devspan.financeiro2.model.AccountRegister;
import br.devspan.financeiro2.model.AccountRegisterType;
import br.devspan.financeiro2.model.ReceivingLow;
import br.devspan.financeiro2.model.Recive;
import br.devspan.financeiro2.service.AccountRegisterService;
import br.devspan.financeiro2.service.ReciveLowService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class ReciveLowController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ReciveLowService service;
	
	@Inject
	private AccountRegisterService movimentacaoService;
	
	@Inject
	private NaviggationController navigationController;
	
	@Getter
	private Recive recive;
	
	@Getter
	@Setter
	private ReceivingLow reciveLow;
	
	@Getter
	@Setter
	private AccountRegisterType accountRegisterType;
	
	@PostConstruct
	public void initNewReciveLow() {
		reciveLow = new ReceivingLow();
	}
	
	public String save() throws Exception {
		try {
			service.register(reciveLow);
			AccountRegister movimentacao = new AccountRegister(reciveLow.getBankAccount(), null, reciveLow, new Date());
			movimentacaoService.register(movimentacao);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewReciveLow();
			return navigationController.goToRecivePage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (reciveLow == null) {
			initNewReciveLow();
		}
	}
	
	public boolean isNew() {
		return reciveLow.getId() == null;
	}
	
	public boolean isPago(Recive receber){
		List<ReceivingLow> resultado = service.findByRecive(receber);
		return resultado != null && resultado.size() > 0; 
	}
	
	public void setRecive(Recive recive) {
		this.recive = recive;
		this.reciveLow.setLowDate(new Date());
		this.reciveLow.setRecive(recive);
	}
}
