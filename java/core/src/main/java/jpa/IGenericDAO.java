package jpa;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public interface IGenericDAO <T extends AbstractEntity, ID>  {  
	  
    T findById( ID id );
  
    List<T> findAll();
      
    void delete( ID id );
    
    T create( T entity );
    
    T update( T entity );
    
    void flush( T entity );
}  
