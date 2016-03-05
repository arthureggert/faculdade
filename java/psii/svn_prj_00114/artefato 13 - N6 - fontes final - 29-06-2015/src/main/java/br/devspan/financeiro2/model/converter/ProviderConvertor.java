package br.devspan.financeiro2.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.devspan.financeiro2.model.Provider;
import br.devspan.financeiro2.service.ProviderService;

@Named
@FacesConverter("PROVIDERConverter")
public class ProviderConvertor implements Converter {

	@Inject
	private ProviderService service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		Long id = Long.parseLong(value);
		
		return service.findById(id);
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Long id = ((Provider) value).getId();
		
		return (id != null) ? id.toString() : null;
	}
	
}