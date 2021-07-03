package io.bankname.credit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import io.bankname.credit.objects.Client;
import io.bankname.credit.objects.services.BaseService;

@Controller
@RequestMapping("/")
public class ClientController {
	
		
		@Autowired
		@Qualifier("client")
		private BaseService<Client> clientService;
		
		@GetMapping("/clients")
		public String showClients(Model model) {
			model.addAttribute("clients", clientService.showAllEntity());
			return "showClients";
		}
		
		@GetMapping("/{clientId}")
		public String presentClient(@PathVariable("{clientId}") Long clientId, Model model) {
			model.addAttribute("client", clientService.showEntity(clientId));
			return "presentClient";
		}
		
		@GetMapping("/{clientId}/edit")
		public String getFormClient(@PathVariable("{clientId}") Long clientId, Model model) {
			model.addAttribute("client", clientService.showEntity(clientId));
			return "formClient";
		}
		
		@GetMapping("/addclient")
		public String addFormClient(Model model) {
			model.addAttribute("client", new Client());
			return "formClient";
		}

		@PostMapping("/{clientId}/edit")
		public String editClient(@PathVariable ("{clientId}") 
								long clientId, 
								Model model, 
								Client client) {
			
			clientService.saveEntity(client);
			return "redirect:/";
		}
		
		@PostMapping("/addclient")
		public String addEditClient(Model model, 
									Client client) {
			
			clientService.saveEntity(client);
			return "redirect:/";
		}
		
		@PostMapping("/{clientId}")
		public String removeClient(@PathVariable ("{clientId}") 
								long clientId, 
								Model model, 
								Client client) {
			
			clientService.deleteEntity(client);
			return "redirect:/";
		}
}


