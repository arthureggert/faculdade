package financeiro.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "city", catalog = "devspan_financeiro")
public class City extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", nullable = false)
	private State state;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "name", length = 45)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private Set<Client> clients = new HashSet<Client>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private Set<Provider> providers = new HashSet<Provider>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private Set<Firm> firms = new HashSet<Firm>(0);
	
}
