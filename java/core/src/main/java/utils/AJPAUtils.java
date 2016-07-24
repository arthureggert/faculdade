package utils;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AJPAUtils {

	public static <T> TypedQuery<T> createNamedQuery(EntityManager entityManager, String query, Class<T> classz) {
		return entityManager.createNamedQuery(query, classz);	
	}

	public static <T> TypedQuery<T> createManualQuery(EntityManager entityManager, String query, Class<T> classz) {
		return entityManager.createQuery(query, classz);
	}
	


}
