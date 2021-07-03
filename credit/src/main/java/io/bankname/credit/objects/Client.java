package io.bankname.credit.objects;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "client")
public class Client {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
	
	@NotNull
	@Size(min = 2, max = 32)
	private String name;
	@NotNull
	@Size(min = 2, max = 32)
	private String surname;
	
	private String fathersName;
	@NotNull
	@Size(min = 10, max = 13)
	private String phoneNumber;
	
	@NotNull
	@Size(min = 6)
	private String email;
	
	@NotNull
	@Size(min = 10, max = 10)
	private String passportsNumber;
	
	@ManyToMany
	@JoinTable(name = "bank_client",
			joinColumns=
            @JoinColumn(name="Client_ID", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="Bank_ID", referencedColumnName="id"))
	private Set<Bank> banks;
	
	

	public Client() {}

	public Client(@NotNull @Size(min = 2, max = 32) String name, @NotNull @Size(min = 2, max = 32) String surname,
			String fathersName, @NotNull @Size(min = 10, max = 13) String phoneNumber,
			@NotNull @Size(min = 6) String email, @NotNull @Size(min = 10, max = 10) String passportsNumber, Set<Bank> banks) {
		super();
		this.name = name;
		this.surname = surname;
		this.fathersName = fathersName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.passportsNumber = passportsNumber;
		this.setBanks(banks);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassportsNumber() {
		return passportsNumber;
	}

	public void setPassportsNumber(String passportsNumber) {
		this.passportsNumber = passportsNumber;
	}

	public UUID getId() {
		return id;
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}
	
}
