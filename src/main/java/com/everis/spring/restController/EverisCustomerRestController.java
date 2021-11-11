package com.everis.spring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.services.EverisCustomerManagementServiceI;

@RestController
public class EverisCustomerRestController {
	
	@Autowired
	private EverisCustomerManagementServiceI customerService;
	
	@GetMapping(value = "/getAllCustomer}")
	public List<EverisCustomer> getAllCustomer() {
		return customerService.findAll();
	}
	
	
	@GetMapping(value = "/{name}")
	public List<EverisCustomer> searchCustomer(final @PathVariable String name) {
		return customerService.searchByName(name);
	}
	
	@PostMapping()
	public void addCustomer(@RequestBody EverisCustomer newCustomer) {
		customerService.insertNewCustomer(newCustomer);
	}
	
	
	@PostMapping()
	public void deleteCustomer(@RequestBody Long id) {
		customerService.deletedCustomerById(id);
	}
	
	

}
