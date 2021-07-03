package io.bankname.credit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.bankname.credit.objects.Bank;
import io.bankname.credit.objects.Credit;
import io.bankname.credit.objects.services.BaseService;
import io.bankname.credit.objects.services.CreditServiceImpl;

@Controller
@RequestMapping("/{bankName}")
public class CreditController {

		@Autowired
		@Qualifier("credit")
		private CreditServiceImpl creditService;
		
		@Autowired
		@Qualifier("bank")
		private BaseService<Bank> bankService;
				
		@GetMapping("/{creditName}")
		public String presentCredit(@PathVariable("{bankName}") String bankName,
									@PathVariable("{creditName}") String creditName, 
									Model model) {
			model.addAttribute("credit", creditService.presentEntityByName(creditName, bankService.presentEntityByName(bankName)));
			return "presentCredit";
		}
		
		@GetMapping("/{creditName}/edit")
		public String editFormCredits(@PathVariable("{bankName}") String bankName,
				@PathVariable("{creditName}") String creditName, Model model) {
			model.addAttribute("credit", creditService.presentEntityByName(creditName, bankService.presentEntityByName(bankName)));
			return "formCredit";
		}
		
		@GetMapping("/addcredit")
		public String addFormCredit(@PathVariable("{bankName}") String bankName, Model model) {
			Credit credit = new Credit();
			credit.setBank(bankService.presentEntityByName(bankName));
			model.addAttribute("credit", credit);
			return "formCredit";
		}

		@PostMapping("/{creditName}/edit")
		public String editCredit(@PathVariable("{creditName}") String creditName, 
								Model model, 
								Credit credit) {
			creditService.saveEntity(credit);
			model.addAttribute("bankName", credit.getBank().getName());
			return "redirect:/{bankName}";
		}
		
		@PostMapping("/addcredit")
		public String addCredit(Model model, 
								Credit credit) {
			
			creditService.saveEntity(credit);
			model.addAttribute("bankName", credit.getBank().getName());
			return "redirect:/{bankName}";
		}
		
		@PostMapping("/{creditName}")
		public String removeCredit(
									Model model, 
									Credit credit) {
			
			creditService.deleteEntity(credit);
			return "redirect:/";
		}

}
