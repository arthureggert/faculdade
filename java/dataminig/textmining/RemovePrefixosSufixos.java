package br.com.ahe.dataminig.textmining;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.ahe.dataminig.daos.RadicalDAO;
import br.com.ahe.dataminig.tables.Radical;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RemovePrefixosSufixos {
	
	@Autowired
	private RadicalDAO dao;
	
	public String removerPrefixsSufixs(String textToRemoveSufixPrefix){
		ArrayList<String> vfrase = new ArrayList<String>(Arrays.asList(textToRemoveSufixPrefix.split(" ")));
		return removePrefixSufix(vfrase);
	}

	private String removePrefixSufix(ArrayList<String> vfrase) {
		String retorno = "";
		for (String string : vfrase) {
			Radical radical = this.dao.findByRadical(string);
			if(radical != null){
				retorno += radical.getRadical() + " ";
			} else {
				retorno += string + " ";
			}
		}
		return retorno;
	}

}
