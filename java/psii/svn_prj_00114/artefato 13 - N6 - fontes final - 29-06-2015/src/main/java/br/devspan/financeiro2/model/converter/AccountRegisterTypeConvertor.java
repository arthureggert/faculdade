package br.devspan.financeiro2.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.devspan.financeiro2.model.AccountRegisterType;
import br.devspan.financeiro2.service.AccountRegisterTypeService;

@Named
@FacesConverter("ACCOUNTREGISTERTYPEConverter")
public class AccountRegisterTypeConvertor implements Converter {
	
	@Inject
	private AccountRegisterTypeService service;
	
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
		Long id = ((AccountRegisterType) value).getId();
		
		return (id != null) ? id.toString() : null;
	}
	
}