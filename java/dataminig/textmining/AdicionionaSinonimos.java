package br.com.ahe.dataminig.textmining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.ahe.dataminig.daos.SinonimoDAO;
import br.com.ahe.dataminig.tables.Sinonimo;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AdicionionaSinonimos {

	@Autowired
	private SinonimoDAO dao;

	public String adicionaSinonimo(String textToAddSinonimo){
		ArrayList<String> vfrase = new ArrayList<String>(Arrays.asList(textToAddSinonimo.split(" ")));
		String retorno = "";
		for (String string : vfrase) {
			List<Sinonimo> sinonimos = this.dao.findByPalavra(string);
			if(sinonimos != null && sinonimos.size() > 0){
				for (Sinonimo sinonimo : sinonimos) {
					retorno += sinonimo.getSinomimo() + " ";
				}
			} 
			retorno += string + " ";
		}
		return retorno;
	}
}
