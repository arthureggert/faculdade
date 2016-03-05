package br.com.ahe.dataminig.textmining;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import utils.AListUtils;
import br.com.ahe.dataminig.daos.StopwordDAO;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RemoveStopword {
	
	@Autowired
	private StopwordDAO dao;

	public String removeStopWord(String textToRemoveStopword){
		ArrayList<String> vfrase = new ArrayList<String>(Arrays.asList(textToRemoveStopword.split(" ")));
		vfrase.removeAll(this.dao.findAllAsString());
		textToRemoveStopword = AListUtils.getStringFromList(vfrase);
		return textToRemoveStopword;
	}
	
	
	
}
