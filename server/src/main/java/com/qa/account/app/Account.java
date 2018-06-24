package com.qa.account.app;


import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Account {
    @Id @GeneratedValue
    private Long id;
    @Size(min = 1, max = 255)
    private @NonNull String firstName;
    @Size(min = 1, max = 255)
    private @NonNull String lastName;
    @Size(min = 4, max = 4)
    private @NonNull String accountNumber;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
    
    
}
