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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "provider", catalog = "devspan_financeiro")
public class Provider extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "firm_id", nullable = false)
	private Firm firm;
	
	@Column(name = "name")
	private String name;
	
	@Size(max = 45)
	@Column(name = "display_name", length = 45)
	private String displayName;
	
	@Size(max = 45)
	@Column(name = "cnpj", length = 45)
	private String cnpj;
	
	@Size(max = 45)
	@Column(name = "ie", length = 45)
	private String ie;
	
	@Size(max = 45)
	@Column(name = "address", length = 45)
	private String address;
	
	@Size(max = 45)
	@Column(name = "neighborhood", length = 45)
	private String neighborhood;
	
	@Size(max = 45)
	@Column(name = "zip_code", length = 45)
	private String zipCode;
}