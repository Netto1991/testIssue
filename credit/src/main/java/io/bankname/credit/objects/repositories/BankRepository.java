package io.bankname.credit.objects.repositories;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import io.bankname.credit.objects.Bank;


public interface BankRepository extends JpaRepository<Bank, Long>{

	
	@Override
	Optional<Bank> findById(Long id);

	Stream<Bank> findByName(String name);
}
