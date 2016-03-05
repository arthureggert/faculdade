package financeiro.domain.model;

// Generated 04/06/2015 14:18:33 by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "account_register", catalog = "devspan_financeiro")
public class AccountRegister extends BaseEntity {
	
    private static final long serialVersionUID = 1L;

	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_register_type_id", nullable = false)
	private AccountRegisterType accountRegisterType;
    
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", nullable = false)
	private BankAccount bankAccount;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_low_id")
	private PayLow payLow;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiving_low_id")
	private ReceivingLow receivingLow;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "register_date", nullable = false, length = 10)
	private Date registerDate;

	
}
