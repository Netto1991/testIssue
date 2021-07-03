package io.bankname.credit.objects.repositories;



import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import io.bankname.credit.objects.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{


	@Override
	Optional<Client> findById(Long id);
	
	Stream<Client> findAllBySurname(String name);


}
