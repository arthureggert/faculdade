package financeiro.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//@Entity
public class ____Member extends BaseEntity {

    private static final long serialVersionUID = 1L;

	@Size(min = 2, max = 50)
    @Pattern(regexp = "[A-Z][a-z]*")
    private String firstName;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "[A-Z][a-z]*")
    private String lastName;

    @NotNull
    @Column(unique = true)
    private String email;

    @Digits(integer = 9, fraction = 0)
    private String bankAccount;

    public ____Member(String firstName, String lastName, String email, String bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bankAccount = bankAccount;
    }

    public ____Member() {
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
