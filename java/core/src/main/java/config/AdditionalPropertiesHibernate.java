package config;

import java.util.Properties;

public class AdditionalPropertiesHibernate extends Properties {

	private static final long serialVersionUID = 1L;
	
	public AdditionalPropertiesHibernate() {
         //setProperty("hibernate.hbm2ddl.auto", "create-drop");
         setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	}

}
