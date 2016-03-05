package br.com.ahe.sd.trabalho.core;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SimpleEntityManager {

    private static SessionFactory sessionFactory;

    @SuppressWarnings( "deprecation" )
    private static SessionFactory getSessionFactory()  throws MappingException  {
        if(sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

    public Session getSession() {
        return getSessionFactory().openSession();
    }
}
