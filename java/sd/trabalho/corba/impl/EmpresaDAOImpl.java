package br.com.ahe.sd.trabalho.corba.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ahe.sd.trabalho.corba.Empresa;
import br.com.ahe.sd.trabalho.corba.EmpresaDAOPOA;
import br.com.ahe.sd.trabalho.core.SimpleEntityManager;
import br.com.ahe.sd.trabalho.model.dao.IGenericDAO;

/**
 * Created by aheggert on 28/06/14.
 */
public class EmpresaDAOImpl extends EmpresaDAOPOA implements IGenericDAO<br.com.ahe.sd.trabalho.model.Empresa, Long> {

    private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();

    @Override
    public void cadastraEmpresa(Empresa emp) {
        br.com.ahe.sd.trabalho.model.Empresa empCad = new br.com.ahe.sd.trabalho.model.Empresa();
        empCad.setNomeEmpresa(emp.nome);
        empCad.setSiglaEmpresa(emp.sigla);
        create(empCad);
    }

    @Override
    public boolean isEmpresaCadastrada(Empresa emp) {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Empresa o WHERE o.nomeEmpresa = :nome");
        query.setParameter("nome" , emp.nome);
        return query.uniqueResult() != null;
    }

    @Override
    public br.com.ahe.sd.trabalho.model.Empresa findById(Long aLong) {
        return (br.com.ahe.sd.trabalho.model.Empresa) getSimpleEntityManager().getSession().load(getTypeOfT() , aLong);
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<br.com.ahe.sd.trabalho.model.Empresa> findAll() {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Empresa o");
        return query.list();
    }

    @Override
    public br.com.ahe.sd.trabalho.model.Empresa create(br.com.ahe.sd.trabalho.model.Empresa entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.save(entity);
            tx.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            tx.rollback();
        }
        List<br.com.ahe.sd.trabalho.model.Empresa> dados = findAll();
        for (br.com.ahe.sd.trabalho.model.Empresa emp : dados) {
            if(emp.getNomeEmpresa().equals(entity.getNomeEmpresa())) {
                entity = emp;
                break;
            }
        }
        return entity;
    }

    @Override
    public br.com.ahe.sd.trabalho.model.Empresa update(br.com.ahe.sd.trabalho.model.Empresa entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.update(entity);
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        }
        return entity;
    }

    @Override
    public void flush(br.com.ahe.sd.trabalho.model.Empresa entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.flush();
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        }
    }

    @Override
    public Class<br.com.ahe.sd.trabalho.model.Empresa> getTypeOfT() {
        return br.com.ahe.sd.trabalho.model.Empresa.class;
    }

    @Override
    public SimpleEntityManager getSimpleEntityManager() {
        return this.simpleEntityManager;
    }
}
