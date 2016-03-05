package controller;

import java.util.List;

import Model.Categoria;
import Model.Contato;

public class DAO {

	public List<Contato> getLista() {

		return (List<Contato>) DB.get().createEntityManager()
				.createQuery("select c from contato as c").getResultList();
	}

	public void teste() {
		DB.get()
				.createEntityManager()
				.persist(
						new Contato(1, "João1", "(47) 3324-5678",
								"(47) 9999-9999", "jhony@inf.furb.br",
								"Observação", new Categoria(3, "Azul",
										"#0000ff")));

		System.out.println("enter1");

	}

}
