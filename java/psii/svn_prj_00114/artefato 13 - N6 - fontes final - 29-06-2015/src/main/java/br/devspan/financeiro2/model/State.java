package br.devspan.financeiro2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "state", catalog = "devspan_financeiro", uniqueConstraints = { @UniqueConstraint(columnNames = "abbreviation") })
public class State extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "name", length = 45, nullable = false)
	private String name;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "abbreviation", length = 45, nullable = false)
	private String abbreviation;
	
	@Override
	public String toString() {
		return name;
	}
	
}
