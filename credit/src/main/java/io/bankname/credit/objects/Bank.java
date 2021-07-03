package io.bankname.credit.objects;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Bank")
public class Bank {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
	
	private String name;
	
	@ManyToMany(mappedBy = "banks")
	private Set<Client> clients;
	
	@OneToMany(cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Credit> credits;
	
	
	public Bank() {}


	public Bank(String name, Set<Client> clients, Set<Credit> credits) {
		super();
		this.name = name;
		this.clients = clients;
		this.credits = credits;
	}

	public UUID getId() {
		return id;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	public void setOneClient(Client client) {
		Set<Client> clients = this.getClients();
		clients.add(client);
		this.clients = clients;
	}

	public Set<Credit> getCredits() {
		return credits;
	}

	public void setCredits(Set<Credit> credits) {
		this.credits = credits;
	}
	
	public void setOneCredit(Credit credit) {
		Set<Credit> credits = this.getCredits();
		credits.add(credit);
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
