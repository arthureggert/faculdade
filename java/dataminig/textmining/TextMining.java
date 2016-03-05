package br.com.ahe.dataminig.textmining;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.ahe.dataminig.daos.ChamadoDAO;
import br.com.ahe.dataminig.tables.Chamado;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TextMining {

	@Autowired
	private RemoveStopword removeStopword;
	
	@Autowired
	private RemovePrefixosSufixos removePrefixSufix;
	
	@Autowired
	private AdicionionaSinonimos adicionaSinonimos;
	
	@Autowired
	private ChamadoDAO dao;
	
	private String frasePesquisa;
	
	public void run(){
		this.frasePesquisa = this.removeStopword.removeStopWord(this.frasePesquisa);
		this.frasePesquisa = this.adicionaSinonimos.adicionaSinonimo(this.frasePesquisa);
		this.frasePesquisa = this.removePrefixSufix.removerPrefixsSufixs(this.frasePesquisa); 
	}
	
	public void setValue(Object ... values){
		this.frasePesquisa = (String) values[0];
	}

	public String getChamados() {
		List<Chamado> dados = this.dao.findByProblemas(this.frasePesquisa);
		return dados.toString();
	}
	
}
