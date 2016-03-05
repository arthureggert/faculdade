package br.devspan.financeiro2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.stella.bean.validation.CNPJ;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "firm", catalog = "devspan_financeiro")
public class Firm extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@NotNull
	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "display_name", length = 45)
	private String displayName;
	
	@CNPJ
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "cnpj", length = 45)
	private String cnpj;
	
	@NotNull
	@NotEmpty
	@Column(name = "ie", length = 45)
	private String ie;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "address", length = 45)
	private String address;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "neighborhood", length = 45)
	private String neighborhood;
	
	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "zip_code", length = 45)
	private String zipCode;
	
}
