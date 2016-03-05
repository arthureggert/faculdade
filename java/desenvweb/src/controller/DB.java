package controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory get() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("default");

		}
		return emf;
	}

}
