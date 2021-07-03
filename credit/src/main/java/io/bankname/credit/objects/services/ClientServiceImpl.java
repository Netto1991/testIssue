package io.bankname.credit.objects.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import io.bankname.credit.objects.Client;
import io.bankname.credit.objects.repositories.ClientRepository;

@Service
@Qualifier("client")
public class ClientServiceImpl implements BaseService<Client>{

	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public void saveEntity(Client t) {
		clientRepo.save(t);
		
	}

	@Override
	public void deleteEntity(Client t) {
		clientRepo.delete(t);
		
	}

	@Override
	public Client showEntity(long id) {
		
		return (Client) clientRepo.findById(id).get();
	}

	@Override
	public List<Client> showAllEntity() {
		
		return clientRepo.findAll();
	}

	@Override
	public Client presentEntityByName(String number) {
		return clientRepo.findByPassportNumber(number).get();
	}

}
