package io.bankname.credit.objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Bank")
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToMany(mappedBy = "banks")

	private List<Client> clients;
	
	@OneToMany(cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Credit> credits;
	
	

	public Bank() {}

	public Bank(List<Client> clients, List<Credit> credits) {
		super();
		this.clients = clients;
		this.credits = credits;
	}

	public long getId() {
		return id;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}
	
}
