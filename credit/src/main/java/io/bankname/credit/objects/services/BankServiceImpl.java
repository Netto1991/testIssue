package io.bankname.credit.objects.services;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import io.bankname.credit.objects.Bank;
import io.bankname.credit.objects.repositories.BankRepository;

@Service
@Qualifier("bank")
public class BankServiceImpl implements BaseService<Bank>{
	
	@Autowired
	private BankRepository bankRepo;

	@Override
	public Bank showEntity(long id) {
		
		return (Bank) bankRepo.findById(id).get();
	}

	@Override
	public void saveEntity(Bank bank) {
		bankRepo.save(bank);
	}

	@Override
	public void deleteEntity(Bank bank) {
		bankRepo.delete(bank);	
	}

	@Override
	public List<Bank> showAllEntity() {
		return bankRepo.findAll();
	}
	
	public Stream<Bank> presentEntityByName(String bankName) {
		return bankRepo.findByName(bankName);
	}
}
