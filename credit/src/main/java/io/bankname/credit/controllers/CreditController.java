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
import io.bankname.credit.objects.services.BaseService;

@Controller
@RequestMapping("/{bankName}/credits")
public class CreditController {

		@Autowired
		@Qualifier("credit")
		private BaseService<Credit> creditService;
		
		@GetMapping()
		public String showCreditsForBank(Model model) {
			model.addAttribute("credits", creditService.showAllEntity());
			return "showCredits";
		}
		
		
		@GetMapping("/{creditId}")
		public String presentCredit(@PathVariable("{creditId}") long creditId, Model model) {
			model.addAttribute("credit", creditService.showEntity(creditId));
			return "presentCredit";
		}
		
		@GetMapping("/{creditId}/edit")
		public String editFormCredits(@PathVariable("{creditId}") long creditId, Model model) {
			model.addAttribute("credit", creditService.showEntity(creditId));
			return "formCredit";
		}
		
		@GetMapping("/addcredit")
		public String addFormCredit(Model model) {
			model.addAttribute("credit", new Credit());
			return "formCredit";
		}

		@PostMapping("/{creditId}/edit")
		public String editCredit(@PathVariable("{creditId}") long creditId, 
								Model model, 
								Credit credit) {
			creditService.saveEntity(credit);
			return "redirect:/";
		}
		
		@PostMapping("/addcredit")
		public String addCredit(Model model, 
								Credit credit) {
			
			creditService.saveEntity(credit);
			return "redirect:/";
		}
		
		@PostMapping("/{creditId}")
		public String removeCredit(@PathVariable("{creditId}") long creditId, 
								Model model, 
								Credit credit) {
			
			creditService.deleteEntity(credit);
			return "redirect:/";
		}

}
