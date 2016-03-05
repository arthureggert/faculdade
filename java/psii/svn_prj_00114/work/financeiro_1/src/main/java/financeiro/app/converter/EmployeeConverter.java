package financeiro.app.converter;

import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import financeiro.data.MemberRepository;
import financeiro.domain.model.Member;

@Named
@FacesConverter(forClass = Member.class)
public class EmployeeConverter extends BaseEntityConverter<MemberRepository, Member> {
}
