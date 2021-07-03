package io.bankname.credit.objects.repositories;



import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import io.bankname.credit.objects.Bank;
import io.bankname.credit.objects.Credit;


public interface CreditRepository extends JpaRepository<Credit, Long>{

	@Override
	Optional<Credit> findById(Long id);
	
	Stream<Bank> findByName(String name);

}
