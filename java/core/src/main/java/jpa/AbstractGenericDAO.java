package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public abstract class AbstractGenericDAO<T extends AbstractEntity, ID> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> entityClass;

	public AbstractGenericDAO(Class<T> classe) {
		this.entityClass = classe;
	}

	@Transactional
	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	public void delete(ID id) {
		this.entityManager.remove(this.entityManager.getReference(this.entityClass, id));
	}

	public T update(T t) {
		return this.entityManager.merge(t);    
	}

	public T findById(ID id) {
		return this.entityManager.find(this.entityClass, id);
	}

	public void flush(T entity) {
		this.entityManager.flush();
	}

	public EntityManager getEm() {
		return this.entityManager;
	}
	
	public List<T> findAll(){
        return this.entityManager.createQuery("From " + getEntityClass().getName(), getEntityClass()).getResultList();
	}
	
	public Class<T> getEntityClass() {
		return this.entityClass;
	}
}    