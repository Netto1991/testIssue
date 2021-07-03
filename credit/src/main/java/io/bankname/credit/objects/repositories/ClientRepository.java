package io.bankname.credit.objects.repositories;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import io.bankname.credit.objects.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{


	@Override
	Optional<Client> findById(Long id);
	
	Optional<Client> findByPassportNumber(String number);


}
