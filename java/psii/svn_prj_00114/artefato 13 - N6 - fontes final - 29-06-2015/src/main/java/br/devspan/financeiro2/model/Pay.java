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
@Table(name = "pay", catalog = "devspan_financeiro")
public class Pay extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "provider_id", nullable = false)
	private Provider provider;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "due_date", nullable = false, length = 10)
	private Date dueDate;
	
	@NotNull
	@Digits(fraction = 4, integer = 16)
	@Column(name = "value", nullable = false, precision = 16, scale = 4)
	private BigDecimal value;
	
	@Size(max = 45)
	@Column(name = "document_number", nullable = false, length = 45)
	private String documentNumber;
	
	public boolean isVencido() {
		return !(new Date()).before(dueDate);
	}
}
