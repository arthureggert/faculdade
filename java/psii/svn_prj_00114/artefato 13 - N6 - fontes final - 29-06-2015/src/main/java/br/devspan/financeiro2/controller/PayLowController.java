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
import br.devspan.financeiro2.model.Pay;
import br.devspan.financeiro2.model.PayLow;
import br.devspan.financeiro2.service.AccountRegisterService;
import br.devspan.financeiro2.service.PayLowService;
import br.devspan.financeiro2.util.ErrorUtil;

@Model
public class PayLowController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private PayLowService service;
	
	@Inject
	private AccountRegisterService movimentacaoService;
	
	@Inject
	private NaviggationController navigationController;
	
	@Getter
	private Pay pay;
	
	@Getter
	@Setter
	private PayLow payLow;
	
	@Getter
	@Setter
	private AccountRegisterType accountRegisterType;
	
	@PostConstruct
	public void initNewPayLow() {
		payLow = new PayLow();
	}
	
	public String save() throws Exception {
		try {
			service.register(payLow);
			AccountRegister movimentacao = new AccountRegister(payLow.getBankAccount(), payLow, null, new Date());
			movimentacaoService.register(movimentacao);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewPayLow();
			return navigationController.goToPayPage();
		} catch (Exception e) {
			String errorMessage = ErrorUtil.getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}
	
	public void preRenderView() {
		if (payLow == null) {
			initNewPayLow();
		}
	}
	
	public boolean isNew() {
		return payLow.getId() == null;
	}
	
	public boolean isPago(Pay receber) {
		List<PayLow> resultado = service.findByPay(receber);
		return resultado != null && resultado.size() > 0;
	}
	
	public void setPay(Pay pay) {
		this.pay = pay;
		this.payLow.setLowDate(new Date());
		this.payLow.setPay(pay);
		this.payLow.setLowValue(pay.getValue());
	}
}
