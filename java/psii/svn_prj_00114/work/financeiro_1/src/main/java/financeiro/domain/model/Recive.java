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
@Table(name = "recive", catalog = "devspan_financeiro")
public class Recive extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "due_date", nullable = false, length = 19)
	private Date dueDate;
	
	@NotNull
	@Digits(integer = 14, fraction = 4)
	@Column(name = "value", nullable = false, precision = 16, scale = 4)
	private BigDecimal value;
	
	@NotNull
	@Size(max = 45)
	@Column(name = "document_number", nullable = false, length = 45)
	private String documentNumber;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "recive")
	private Set<ReceivingLow> receivingLows = new HashSet<ReceivingLow>(0);
	
}
