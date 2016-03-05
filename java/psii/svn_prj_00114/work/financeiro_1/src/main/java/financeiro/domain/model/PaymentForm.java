package financeiro.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "payment_form", catalog = "devspan_financeiro")
public class PaymentForm extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Size(max = 45)
	@Column(name = "description", length = 45)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentForm")
	private Set<PayLow> payLows = new HashSet<PayLow>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentForm")
	private Set<ReceivingLow> receivingLows = new HashSet<ReceivingLow>(0);
	
}
