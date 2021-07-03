package io.bankname.credit.objects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pay Schedule")
public class paySchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Date payDate;
	
	private long payAmount;
	
	private int payBody;
	
	private int payPercent;
	
	@ManyToOne
	@JoinColumn(name = "creditOffer_id", nullable = false)
	private CreditOffer creditOffer;
	
	

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public long getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(long payAmount) {
		this.payAmount = payAmount;
	}

	public int getPayBody() {
		return payBody;
	}

	public void setPayBody(int payBody) {
		this.payBody = payBody;
	}

	public int getPayPercent() {
		return payPercent;
	}

	public void setPayPercent(int payPercent) {
		this.payPercent = payPercent;
	}

	public CreditOffer getCreditOffer() {
		return creditOffer;
	}

	public void setCreditOffer(CreditOffer creditOffer) {
		this.creditOffer = creditOffer;
	}

	public long getId() {
		return id;
	}
	
	
}
