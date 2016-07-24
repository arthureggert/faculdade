package utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ASpringUtils implements ApplicationContextAware {
	
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		initializeApplicationContext(applicationContext);
	}
	
	private static void initializeApplicationContext(ApplicationContext applicationContext) {
		context = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return context;
	}
	
	public static <T> T getBean(Class<T> bean) throws BeansException {
		return context.getBean(bean);
	}
	
	@SuppressWarnings( "unchecked" )
	public static <T> T getBean(String bean) throws BeansException {
		return (T) context.getBean(bean);
	}
	
}
