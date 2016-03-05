package br.devspan.financeiro2.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.devspan.financeiro2.model.Member;
import br.devspan.financeiro2.service.MemberRepository;

@Named
public class MemberConvertor implements Converter {

	@Inject
	private MemberRepository users;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		Long id = Long.parseLong(value);
		
		return users.findById(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Long id = ((Member) value).getId();
		
		return (id != null) ? id.toString() : null;
	}

}