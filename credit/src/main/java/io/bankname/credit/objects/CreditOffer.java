package io.bankname.credit.objects;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Credir Offer")
public class CreditOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	

	private Client client;
	
	@NotNull
	private Credit credit;
	
	@NotNull
	private long creditAmount;
	
	@NotNull
	private Date startCredit;
	
	@NotNull
	private Date endCredit;
	
	@OneToMany(orphanRemoval = true)
	private List<paySchedule> paySchedule;

	public CreditOffer(Client client, @NotNull Credit credit, @NotNull long creditAmount, @NotNull Date startCredit,
			@NotNull Date endCredit, List<io.bankname.credit.objects.paySchedule> paySchedule) {
		super();
		this.client = client;
		this.credit = credit;
		this.creditAmount = creditAmount;
		this.startCredit = startCredit;
		this.endCredit = endCredit;
		this.paySchedule = paySchedule;
	}

	public CreditOffer() {}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public long getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(long creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Date getStartCredit() {
		return startCredit;
	}

	public void setStartCredit(Date startCredit) {
		this.startCredit = startCredit;
	}

	public Date getEndCredit() {
		return endCredit;
	}

	public void setEndCredit(Date endCredit) {
		this.endCredit = endCredit;
	}

	public List<paySchedule> getPaySchedule() {
		return paySchedule;
	}

	public void setPaySchedule(List<paySchedule> paySchedule) {
		this.paySchedule = paySchedule;
	}

	public long getId() {
		return id;
	}
	
	

}
