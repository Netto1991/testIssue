package io.bankname.credit.objects.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.bankname.credit.objects.Bank;


public interface BankRepository extends JpaRepository<Bank, Long>{

	
	@Override
	Optional<Bank> findById(Long id);

	Optional<Bank> findByName(String name);
}
