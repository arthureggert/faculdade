package financeiro.domain.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class MemberRole {
	
	@Produces
	@Named
	public static final String ADMIN = "ADMIN";
	
	@Produces
	@Named
	public static final String USER = "USER";
	
	@Produces
	@Named("roles")
	public static List<String> getAllRoles() {
		List<String> result = new ArrayList<String>();
		for (Field field : MemberRole.class.getDeclaredFields()) {
			try {
				result.add((String) field.get(null));
			} catch (Exception ex) {
			}
		}
		return result;
	}
	
}
