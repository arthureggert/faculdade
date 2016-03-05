package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionListener;

import Model.Contato;

@ManagedBean(name = "agenda")
@SessionScoped
public class Agenda {

	private DAO dao = new DAO();

	public List<Contato> getContatos() {

		System.out.println("teste");

		return dao.getLista();
	}

	public void acao(ActionListener a) {
		System.out.println("teste");
		dao.teste();

	}

}
