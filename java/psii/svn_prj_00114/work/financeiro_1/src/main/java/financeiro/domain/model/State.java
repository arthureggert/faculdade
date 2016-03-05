package financeiro.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "state", catalog = "devspan_financeiro", uniqueConstraints = { @UniqueConstraint(columnNames = "abbreviation") })
public class State extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(max = 45)
	@Column(name = "name", length = 45, nullable = false)
	private String name;
	
	@NotNull
	@Size(max = 45)
	@Column(name = "abbreviation", length = 45, nullable = false)
	private String abbreviation;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	private Set<City> cities = new HashSet<City>(0);
	
}
