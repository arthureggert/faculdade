package financeiro.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "account_register_type", catalog = "devspan_financeiro")
public class AccountRegisterType extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "description", length = 45)
	private String description;
	
	@NotNull
	@Column(name = "credit")
	private Boolean credit;
	
	@NotNull
	@Column(name = "debit")
	private Boolean debit;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountRegisterType")
	private Set<AccountRegister> accountRegisters = new HashSet<AccountRegister>(0);
	
}
