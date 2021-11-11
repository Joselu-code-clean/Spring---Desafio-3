package com.everis.spring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.services.EverisCustomerManagementServiceI;

@RestController
@RequestMapping("/customers")
public class EverisCustomerRestController {
	
	@Autowired
	private EverisCustomerManagementServiceI customerService;
	
	@GetMapping(value = "/all}")
	public List<EverisCustomer> getCustomerByDni() {
		return customerService.findAll();
	}
	
	@PostMapping()
	public void addCustomer(@RequestBody EverisCustomer newCustomer) {
		customerService.insertNewCustomer(newCustomer);
	}
	
	

}
