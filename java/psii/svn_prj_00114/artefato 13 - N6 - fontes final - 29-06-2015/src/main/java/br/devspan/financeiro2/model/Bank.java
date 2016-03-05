package br.devspan.financeiro2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "bank", catalog = "devspan_financeiro")
public class Bank extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "name", length = 45)
	private String name;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "febraban_id", length = 45)
	private String febrabanId;
	
	@Override
	public String toString() {
		return name;
	}
	
}
