package financeiro.domain.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
	private Long id;
		
	@Override
	public String toString() {
		List<String> attrList = new ArrayList<String>();
		
		for (Field f : this.getClass().getDeclaredFields()) {
			OneToMany oneToMany = f.getAnnotation(OneToMany.class);
			if (oneToMany == null) {
				try {
					attrList.add(f.getName() + "=" + f.get(this).toString());
				} catch (Exception ex) {
				}
			}
			
		}
		return this.getClass().getSimpleName() + attrList.toString();
	}
}
