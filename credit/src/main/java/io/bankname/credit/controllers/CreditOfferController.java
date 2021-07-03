package io.bankname.credit.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.bankname.credit.objects.Bank;
import io.bankname.credit.objects.Client;
import io.bankname.credit.objects.Credit;
import io.bankname.credit.objects.CreditOffer;
import io.bankname.credit.objects.services.BaseService;
import io.bankname.credit.objects.services.CreditServiceImpl;

@Controller
@RequestMapping("/{bankName}/{creditName}")
public class CreditOfferController {

		@Autowired
		@Qualifier("creditOffer")
		private BaseService<CreditOffer> creditOfferService;
		
		@Autowired
		@Qualifier("credit")
		private CreditServiceImpl creditService;
		
		@Autowired
		@Qualifier("client")
		private BaseService<Client> clientService;

		@Autowired
		@Qualifier("bank")
		private BaseService<Bank> bankService;
		
		
		@GetMapping("/creditoffer")
		public String showFormcreditOffer(@PathVariable("{bankName}") String bankName,
										@PathVariable("{creditName}") String creditName,
										Model model, Principal principal) {
			if(principal != null) {
				model.addAttribute("Client",  clientService.presentEntityByName(principal.getName()));
				}
			CreditOffer creditOffer = new CreditOffer();
			Credit credit = creditService.presentEntityByName(creditName, bankService.presentEntityByName(bankName));
			creditOffer.setCredit(credit);
			model.addAttribute("creditOffer", creditOffer);
			model.addAttribute("credits", creditService.showAllEntity());
			return "formCreditOffer";
		}

		@GetMapping("/credits/{creditId}")
		public String showOffer(@PathVariable("{creditName}") String creditName, Model model) {
			model.addAttribute("credit", creditOfferService.presentEntityByName(creditName));
			return "showCreditOffer";
		}
		
		@GetMapping("/creditoffer/showpaySchedule")
		public String addFormCredit(Model model) {
			return "showpaySchedule";
		}
		

		@PostMapping("/creditoffer/showpaySchedule")
		public String addEditCreditOffer(Model model, 
								CreditOffer creditOffer) {
			
			creditOfferService.saveEntity(creditOffer);
			return "redirect:/";
		}
		
		@PostMapping("/credits/{creditId}/{creditOfferId}")
		public String removeCreditOffer(@PathVariable("{creditOfferId}") long creditOfferId, 
								Model model, 
								CreditOffer creditOffer) {
			
			creditOfferService.deleteEntity(creditOffer);
			return "redirect:/";
		}

}
