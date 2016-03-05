package financeiro.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Member extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String lastName;
	
	@Email
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@Size(min = 10, max = 12)
	@Digits(fraction = 0, integer = 12)
	@Column(name = "phone_number")
	private String phoneNumber;
	
	public String getFullName() {
		return String.format("%s %s", firstName, lastName);
	}
}
