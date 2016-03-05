package br.devspan.financeiro2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import lombok.Getter;

import org.primefaces.model.chart.PieChartModel;

import br.devspan.financeiro2.model.AccountRegister;
import br.devspan.financeiro2.model.Pay;
import br.devspan.financeiro2.model.Recive;
import br.devspan.financeiro2.service.AccountRegisterService;
import br.devspan.financeiro2.service.PayService;
import br.devspan.financeiro2.service.ReciveService;

@Model
public class IndexController {
	
	@Getter
	private PieChartModel receberPorCliente;
	
	@Getter
	private List<AccountRegister> movimentacoes;
	
	@Inject
	private ReciveService reciveService;
	
	@Inject
	private PayService payService;
	
	@Inject
	private AccountRegisterService accountRegisterService;
	
	@Getter
	private PieChartModel pagarPorFonecedor;
	
	@PostConstruct
	public void init() {
		criaReceberPorCliente();
		criaPagarPorForncedor();
		criaRegistroMovimentacoes();
	}
	
	private void criaRegistroMovimentacoes() {
		movimentacoes = accountRegisterService.findAll();
	}
	
	private void criaReceberPorCliente() {
		List<Recive> tmpList = reciveService.findAll();
		Map<String, Number> tmpMap = new HashMap<String, Number>();
		
		for (Recive recive : tmpList) {
			Number qtd = 0;
			String key = recive.getClient().getName();
			if (tmpMap.containsKey(key)) {
				qtd = tmpMap.get(key);
			}
			qtd = qtd.intValue() + 1;
			tmpMap.put(key, qtd);
		}
		
		receberPorCliente = new PieChartModel(tmpMap);
		receberPorCliente.setLegendPosition("w");
	}
	
	private void criaPagarPorForncedor() {
		List<Pay> tmpList = payService.findAll();
		Map<String, Number> tmpMap = new HashMap<String, Number>();
		
		for (Pay recive : tmpList) {
			Number qtd = 0;
			String key = recive.getProvider().getName();
			if (tmpMap.containsKey(key)) {
				qtd = tmpMap.get(key);
			}
			qtd = qtd.intValue() + 1;
			tmpMap.put(key, qtd);
		}
		
		pagarPorFonecedor = new PieChartModel(tmpMap);
		pagarPorFonecedor.setLegendPosition("w");
	}
	
}
