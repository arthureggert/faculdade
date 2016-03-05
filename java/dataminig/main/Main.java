package br.com.ahe.dataminig.main;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import utils.ASpringUtils;
import br.com.ahe.dataminig.telas.InitialGUI;
import config.SpringApplicationConfig;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Main extends SpringApplicationConfig {
	
	private InitialGUI window;
	
	public Main() {
		this.window = new InitialGUI();
	}
	
	public static void main(String[] args) {
		Main m = ASpringUtils.getBean( Main.class );
		m.window.setVisible(true);

		
	}
	
}
