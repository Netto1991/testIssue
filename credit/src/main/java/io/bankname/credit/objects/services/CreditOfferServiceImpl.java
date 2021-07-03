package io.bankname.credit.objects.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import io.bankname.credit.objects.CreditOffer;
import io.bankname.credit.objects.repositories.CreditOfferRepository;

@Service
@Qualifier("creditOffer")
public class CreditOfferServiceImpl implements BaseService<CreditOffer> {

	@Autowired
	private CreditOfferRepository creditOfferRepo;
	
	@Override
	public void saveEntity(CreditOffer creditOffer) {
		creditOfferRepo.save(creditOffer);
		
	}

	@Override
	public void deleteEntity(CreditOffer creditOffer) {
		creditOfferRepo.delete(creditOffer);
		
	}

	@Override
	public CreditOffer showEntity(long id) {
		
		return (CreditOffer) creditOfferRepo.findById(id).get();
	}

	@Override
	public List<CreditOffer> showAllEntity() {
		
		return creditOfferRepo.findAll();
	}

	@Override
	public CreditOffer presentEntityByName(String number) {
		
		return null;
	}

}
