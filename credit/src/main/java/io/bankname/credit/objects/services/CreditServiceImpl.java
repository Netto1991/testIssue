package io.bankname.credit.objects.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.bankname.credit.objects.Bank;
import io.bankname.credit.objects.Credit;
import io.bankname.credit.objects.repositories.CreditRepository;

@Service
@Qualifier("credit")
public class CreditServiceImpl implements BaseService<Credit>{

	@Autowired
	private CreditRepository creditRepo;
	
	
	@Override
	public void saveEntity(Credit credit) {
		creditRepo.save(credit);
		
	}

	@Override
	public void deleteEntity(Credit credit) {
		creditRepo.delete(credit);
		
	}

	@Override
	public Credit showEntity(long id) {
		
		return (Credit) creditRepo.findById(id).get();
	}

	@Override
	public List<Credit> showAllEntity() {
		return creditRepo.findAll();
	}

	public Credit presentEntityByName(String name, Bank bank) {
		
		return creditRepo.findByNameAndBank(name, bank).get();
	
	}

	@Override
	public Credit presentEntityByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
