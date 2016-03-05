package financeiro.domain.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
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
@Table(name = "bank_account", catalog = "devspan_financeiro")
public class BankAccount extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "account_number", nullable = false, length = 45)
	private String accountNumber;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "agency_number", nullable = false, length = 45)
	private String agencyNumber;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "description", nullable = false, length = 45)
	private String description;
	
	@NotNull
	@Digits(integer = 12 , fraction= 4)
	@Column(name = "opening_balance", nullable = false, precision = 16, scale = 4)
	private BigDecimal openingBalance;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bankAccount")
	private Set<PayLow> payLows = new HashSet<PayLow>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bankAccount")
	private Set<ReceivingLow> receivingLows = new HashSet<ReceivingLow>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bankAccount")
	private Set<AccountRegister> accountRegisters = new HashSet<AccountRegister>(0);
	
}
