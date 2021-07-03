package io.bankname.credit.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Credit")
public class Credit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@NotNull
	private int creditLimit;
	
	@NotNull
	private int interestRate;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;

	public Credit(@NotNull int creditLimit, @NotNull int interestRate, @NotNull Bank bank) {
		super();
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

	public long getId() {
		return id;
	}
	
	
}
