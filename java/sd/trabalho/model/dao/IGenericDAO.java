package br.com.ahe.sd.trabalho.model.dao;

import java.io.Serializable;
import java.util.List;

import br.com.ahe.sd.trabalho.core.SimpleEntityManager;
import br.com.ahe.sd.trabalho.model.DefaultTable;

public interface IGenericDAO <T extends DefaultTable, ID extends Serializable>  {

    T findById(ID id);

    List<T> findAll();

    default void delete(ID id) {

    }

    T create(T entity);

    T update(T entity);

    void flush(T entity);

    Class<T> getTypeOfT();

    SimpleEntityManager getSimpleEntityManager();
}
