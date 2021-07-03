package io.bankname.credit.objects.repositories;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import io.bankname.credit.objects.CreditOffer;


public interface CreditOfferRepository extends JpaRepository<CreditOffer, Long>{
	
	@Override
	Optional<CreditOffer> findById(Long id);
	

}
