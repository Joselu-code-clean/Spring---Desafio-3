package com.everis.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.services.EverisCustomerManagementServiceI;

@Controller
public class EverisCustomerController {

	@Autowired
	private EverisCustomerManagementServiceI everisCustomerService;
	private List<EverisCustomer> listCustomer;
	
	
	private static String INDEX_VIEW = "index";
	private static String INSERT_VIEW = "insertCustomerView";
	private static String SEARCH_VIEW = "searchCustomerByView";
	private static String SHOW_ALL_VIEW = "showAllView";
	
	
	
	@GetMapping("/*")
	public String errorView() {
		return INDEX_VIEW;
	}
	
	@GetMapping("/index")
	public String index() {
		return INDEX_VIEW;
	}
	
	@GetMapping("/insertView")
	public String insertView() {
		return INSERT_VIEW;
	}
	
    @PostMapping(value = "/insertCustomer")
	public String insertCustomer(@ModelAttribute("customer") EverisCustomer customer) {
    	everisCustomerService.insertNewCustomer(customer);
		return "redirect:/showAllCustomer";
	}
	
	@GetMapping("/searchBy")
	public String searchBy() {
		return SEARCH_VIEW;
	}
	
	@PostMapping(value = "/searchCustomer")
	public String searchCustomer(@RequestParam("name") String name, Model model) {
		List<EverisCustomer> searchCustomers = everisCustomerService.searchByName(name);
		model.addAttribute("listCustomer", searchCustomers);
		return SHOW_ALL_VIEW;
	}
	
	@GetMapping("/showAllCustomer")
	public String showAllCustomer(Model model) {
		this.listCustomer = everisCustomerService.findAll();
		model.addAttribute("listCustomer", listCustomer);
		return SHOW_ALL_VIEW;
	}
	
	@PostMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") Long id) {
		everisCustomerService.deletedCustomerById(id);
		return "redirect:/showAllCustomer";
	}
	
}
