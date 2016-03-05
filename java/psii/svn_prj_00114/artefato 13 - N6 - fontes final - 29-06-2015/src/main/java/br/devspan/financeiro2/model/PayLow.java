package br.devspan.financeiro2.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pay_low", catalog = "devspan_financeiro")
public class PayLow extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_account_id", nullable = false)
	private BankAccount bankAccount;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pay_id", nullable = false)
	private Pay pay;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_form_id", nullable = false)
	private PaymentForm paymentForm;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "low_date", nullable = false, length = 10)
	private Date lowDate;
	
	@Digits(integer = 12, fraction = 4)
	@Column(name = "low_value", nullable = false, precision = 16, scale = 4)
	private BigDecimal lowValue;
	
}
