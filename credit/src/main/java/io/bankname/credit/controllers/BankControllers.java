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
import io.bankname.credit.objects.services.BaseService;

@Controller
@RequestMapping("/")
public class BankControllers {
	
	@Autowired
	@Qualifier("bank")
	private BaseService<Bank> bankService;
	
	@GetMapping("/banks")
	public String showBanks(Model model) {
		model.addAttribute("banks", bankService.showAllEntity());
		return "showBanks";
	}
	
	@GetMapping("/{bankName}")
	public String presentBank(@PathVariable("{bankName}") String name, Model model) {
		model.addAttribute("bank", bankService.presentEntityByName(name));
		return "presentBank";
	}
	
	@GetMapping("/{bankName}/edit")
	public String editFormBank(@PathVariable("{bankName}") String bankName, Model model) {
		model.addAttribute("bank", bankService.presentEntityByName(bankName));
		return "formBank";
	}
	
	@GetMapping("/addbank")
	public String addFormBank(Model model) {
		model.addAttribute("bank", new Bank());
		return "formBank";
	}

	@PostMapping("/{bankName}/edit")
	public String editBank(@PathVariable ("{bankName}") 
							String bankName, 
							Model model, 
							Bank bank) {
		
		bankService.saveEntity(bank);
		return "redirect:/";
	}
	
	@PostMapping("/addbank")
	public String addBank(	Model model, 
							Bank bank) {
		
		bankService.saveEntity(bank);
		return "redirect:/";
	}
	
	@PostMapping("/{bankName}")
	public String removeBank(@PathVariable ("{bankName}") 
							String bankName, 
							Model model, 
							Bank bank) {
		
		bankService.deleteEntity(bank);
		return "redirect:/";
	}
}
