package com.everis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.services.EverisCustomerManagementServiceI;

/**
 * Formación Spring.
 * 
 * @author Everis
 *
 */
@SpringBootApplication
public class MainApplicationSD3 implements CommandLineRunner {

	/** Servicio de gestión de clientes */
	@Autowired
	private EverisCustomerManagementServiceI customerService;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainApplicationSD3.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("----- EVERIS SYS - INI -----");

		// Nuevos clientes.
		final EverisCustomer newCustomer1 = new EverisCustomer();
		newCustomer1.setName("Alejandro");
		newCustomer1.setSurName1("Téllez");
		newCustomer1.setSurName2("Rubio");
		newCustomer1.setIdentityDocNumber("28999666A");
		customerService.insertNewCustomer(newCustomer1);

		final EverisCustomer newCustomer2 = new EverisCustomer();
		newCustomer2.setName("Alejandro");
		newCustomer2.setSurName1("Brazo");
		newCustomer2.setSurName2("Luque");
		newCustomer2.setIdentityDocNumber("30111555B");
		customerService.insertNewCustomer(newCustomer2);

		final EverisCustomer newCustomer3 = new EverisCustomer();
		newCustomer3.setName("Estefanía");
		newCustomer3.setSurName1("Cano");
		newCustomer3.setSurName2("Muñiz");
		newCustomer3.setIdentityDocNumber("27000888C");
		customerService.insertNewCustomer(newCustomer3);

		System.out.println("----- INICIO TODOS LOS CLIENTES -----");
		
		// Muestra todos los clientes.
		customerService.searchAllCustomers();
		
		System.out.println("----- FIN TODOS LOS CLIENTES -----");

		System.out.println("----- INICIO TODOS LOS CLIENTES POR NOMBRE -----");
		
		// Obtiene los clientes por nombre.
		customerService.searchByName("Alejandro");

		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE -----");
		
		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE Y APELLIDOS -----");
		
		// Obtiene los clientes por nombre y apellidos.
		customerService.searchByFullName("Alejandro", "Téllez", "Rubio");

		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE Y APELLIDOS -----");
		
		System.out.println("----- EVERIS SYS - FIN -----");

	}

}
