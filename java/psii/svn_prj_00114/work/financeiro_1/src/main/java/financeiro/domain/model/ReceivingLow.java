package financeiro.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "receiving_low", catalog = "devspan_financeiro")
public class ReceivingLow extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_account_bank_id", nullable = false)
	private BankAccount bankAccount;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_form_id", nullable = false)
	private PaymentForm paymentForm;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recive_id", nullable = false)
	private Recive recive;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "low_date", nullable = false, length = 19)
	private Date lowDate;
	
	@NotNull
	@Digits(integer = 14, fraction = 4)
	@Column(name = "low_value", nullable = false, precision = 16, scale = 4)
	private BigDecimal lowValue;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receivingLow")
	private Set<AccountRegister> accountRegisters = new HashSet<AccountRegister>(0);
	
}
