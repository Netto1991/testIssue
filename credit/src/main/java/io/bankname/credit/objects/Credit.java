package io.bankname.credit.objects;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Credit")
public class Credit {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int creditLimit;
	
	@NotNull
	private int interestRate;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;



	public Credit(@NotNull String name, @NotNull int creditLimit, @NotNull int interestRate, @NotNull Bank bank) {
		super();
		this.name = name;
		this.creditLimit = creditLimit;
		this.interestRate = interestRate;
		this.bank = bank;
	}

	public Credit() {
		
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	}


