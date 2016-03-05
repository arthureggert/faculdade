package br.com.ahe.sd.trabalho.core;

import java.util.Set;

import javax.persistence.Table;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.reflections.Reflections;

public class SDApp {

    public void criaTabelas(){
        Configuration config = new Configuration();
        for (Class<?> classz : this.getEntityTables()) {
            System.out.println(classz);
            config.addAnnotatedClass(classz);
        }
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/pregao");
        config.setProperty("hibernate.connection.username","root");
        config.setProperty("hibernate.connection.password","");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        SchemaExport schema = new SchemaExport(config);
        schema.create(true, true);
    }

    private Set<Class<?>> getEntityTables(){
        Reflections classScanner = new Reflections("br/com/ahe/sd/trabalho/model");
        return classScanner.getTypesAnnotatedWith(Table.class);
    }
}
