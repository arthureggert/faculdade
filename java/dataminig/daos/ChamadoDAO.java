package br.com.ahe.dataminig.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;

import jpa.AbstractGenericDAO;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import utils.AJPAUtils;
import br.com.ahe.dataminig.tables.Chamado;

@Component
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ChamadoDAO extends AbstractGenericDAO<Chamado, Long> {

	public ChamadoDAO() {
		super(Chamado.class);
	}
	
	public List<Chamado> findByProblemas(String problemas){
		ArrayList<String> lProblemas = new ArrayList<String>(Arrays.asList(problemas.split(" ")));
		String qSQL = "SELECT c FROM Chamado c ";
		if(lProblemas != null && !lProblemas.isEmpty()){
			qSQL += "WHERE ";
			int tam = lProblemas.size();
			int i = 0;
			for (String problema : lProblemas) {
				i++;
				qSQL += "c.problema like '%"+problema+"%' ";
				if(i < tam){
					qSQL += "or "; 
				}
			}
		}
		System.out.println(qSQL);
		TypedQuery<Chamado> qChamado = AJPAUtils.createManualQuery(getEm(), qSQL, Chamado.class);
		return qChamado.getResultList();
	}

}
