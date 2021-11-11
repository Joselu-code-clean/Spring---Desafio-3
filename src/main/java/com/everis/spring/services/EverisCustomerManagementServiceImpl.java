package com.everis.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.repository.EverisCustomerRepository;

/**
 * Formación Spring.
 * 
 * @author Everis
 *
 */
@Service
public class EverisCustomerManagementServiceImpl implements EverisCustomerManagementServiceI {

	/** Repositorio - Tabla: t_h_customer */
	@Autowired
	private EverisCustomerRepository customerRepository;

	@Override
	public EverisCustomer insertNewCustomer(EverisCustomer newCustomer) {

		// Verificación de nulidad.
		if (newCustomer != null && newCustomer.getId() == null) {

			// Insercción de cliente.
			newCustomer = customerRepository.save(newCustomer);
		}

		return newCustomer;
	}

	@Override
	public void searchAllCustomers() {

		// Consulta clientes.
		final Iterable<EverisCustomer> customerList = customerRepository.findAll();

		// Itera e imprime los clientes.
		customerList.forEach((final EverisCustomer customer) -> System.out.println(customer.toString()));
	}

	@Override
	public void searchByFullName(final String name, final String surname1, final String surname2) {

		// Obtención del listado de clientes por nombre completo.
		final List<EverisCustomer> searchClients = customerRepository.findByNameAndSurName1AndSurName2(name, surname1, surname2);

		// Muestra el listado obtenido.
		printCustomers(searchClients);
	}

	@Override
	public List<EverisCustomer> searchByName(final String name) {

		// Obtención del listado de clientes por nombre.
		final List<EverisCustomer> searchCustomers = customerRepository.findByName(name);

		return searchCustomers;
	}

	/**
	 * Recorre e imprime listado de clientes.
	 * 
	 * @param searchCustomers
	 */
	private void printCustomers(final List<EverisCustomer> searchCustomers) {
		if (!CollectionUtils.isEmpty(searchCustomers)) {
			for (EverisCustomer customer : searchCustomers) {
				System.out.println(customer.toString());
			}
		}
	}

	@Override
	public List<EverisCustomer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void deletedCustomerById(Long id) {
		customerRepository.deleteById(id);
	}


}
