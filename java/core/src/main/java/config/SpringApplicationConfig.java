package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationConfig {

	static {
		appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
	}

	private static ApplicationContext appContext;

	public static ApplicationContext getAppContext() {
        return appContext;
	}

	public static void setAppContext(ApplicationContext appContext) {
		SpringApplicationConfig.appContext = appContext;
	}
}
