package br.devspan.financeiro2.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.devspan.financeiro2.model.Member;
import br.devspan.financeiro2.service.MemberRegistration;
import br.devspan.financeiro2.service.MemberRepository;

@Model
public class MemberController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private MemberRegistration memberRegistration;

	@Inject
	private MemberRepository memberRepository;

	private Member newMember;

	@PostConstruct
	public void initNewMember() {
		newMember = new Member();
	}

	public String register() throws Exception {
		try {
			memberRegistration.register(newMember);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewMember();
			return "index.html";
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
			return null;
		}
	}

	public Member getNewMember() {
		return newMember;
	}

	public void setNewMember(Member newMember) {
		this.newMember = newMember;
	}

	public void preRenderView() {
		if (newMember == null) {
			initNewMember();
		}
	}

	public String delete() {
		memberRepository.remove(newMember.getId());
		initNewMember();
		return "index.html";
	}

	public boolean isNovo() {
		return newMember.getId() == null;
	}

	private static String getRootErrorMessage(Exception e) {
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			return errorMessage;
		}

		Throwable t = e;
		while (t != null) {
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		return errorMessage;
	}

}
