package financeiro.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Email;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "user", catalog = "devspan_financeiro", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "firm_id", nullable = false)
	private Firm firm;
	
	@Email
	@NotNull
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@NotNull
	@Size(max = 45)
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	
	@NotNull
	@Size(max = 45)
	@Column(name = "lastname", nullable = false, length = 45)
	private String lastname;
	
	@NotNull
	@Size(max = 45)
	@Column(name = "login", nullable = false, length = 45)
	private String login;
	
	@NotNull
	@Size(max = 45)
	@Column(name = "password", nullable = false, length = 45)
	private String password;
	
}
