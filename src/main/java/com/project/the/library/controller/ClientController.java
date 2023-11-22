package com.project.the.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.the.library.model.Client;
import com.project.the.library.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	// display list of clients
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listClients", clientService.getAllCliens());
		return "index";
	}

	@GetMapping("/showNewClientForm")
	public String showNewClientForm(Model model) {
		// create model attribute to bind form data
		Client client = new Client();
		model.addAttribute("client", client);
		return "new_client";
	}

	@PostMapping("/saveClient")
	public String saveClient(@ModelAttribute("client") Client client) {
		// save client to database
		clientService.saveClient(client);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get client form the service
		Client client = clientService.getClientById(id);

		// set client as a model attribute to pre-populate the form
		model.addAttribute("client", client);
		return "update_client";

	}
	
	@GetMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable(value = "id") long id) {
		
		//call delete client method
		this.clientService.deleteClientById(id);
		return "redirect:/";
	}
	
	
	

}
