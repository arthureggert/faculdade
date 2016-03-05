package br.devspan.financeiro2.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import br.devspan.financeiro2.model.City;
import br.devspan.financeiro2.service.CityService;

@RequestScoped
public class CityListProducer {

	@Inject
	private CityService repository;

	@Named
	@Getter
	@Produces
	private List<City> cities;

	public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final City city) {
		retrieveAllCities();
	}

	@PostConstruct
	public void retrieveAllCities() {
		cities = repository.findAll();
	}
}
