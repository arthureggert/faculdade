package br.devspan.financeiro2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	
}
