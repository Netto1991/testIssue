package io.bankname.credit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.bankname.credit.objects.Credit;
import io.bankname.credit.objects.CreditOffer;
import io.bankname.credit.objects.services.BaseService;

@Controller
@RequestMapping("/{bankName}")
public class CreditOfferController {

		@Autowired
		@Qualifier("creditOffer")
		private BaseService<CreditOffer> creditOfferService;
		
		@Autowired
		@Qualifier("credit")
		private BaseService<Credit> creditService;
		
		@GetMapping("/creditoffer")
		public String showFormcreditOffer(Model model) {
			model.addAttribute("creditOffer", new CreditOffer());
			model.addAttribute("credits", creditService.showAllEntity());
			return "formCreditOffer";
		}

		@GetMapping("/credits/{creditId}")
		public String showOffer(@PathVariable("{creditId}") long creditId, Model model) {
			model.addAttribute("credit", creditOfferService.showEntity(creditId));
			return "showCreditOffer";
		}
		
		@GetMapping("/creditoffer/showpaySchedule")
		public String addFormCredit(Model model) {
			model.addAttribute("credit", new Credit());
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
