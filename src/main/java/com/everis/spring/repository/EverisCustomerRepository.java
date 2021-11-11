package com.everis.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Formación Spring.
 * 
 * @author Everis
 *
 */
@Repository
public interface EverisCustomerRepository extends JpaRepository<EverisCustomer, Long> {

	/**
	 * Obtención del cliente mediante el nombre.
	 * 
	 * @param name
	 * @return List<EverisClient>
	 */
	public List<EverisCustomer> findByName(final String name);

	/**
	 * Obtención del cliente mediante el nombre completo.
	 * 
	 * @param name
	 * @return List<EverisClient>
	 */
	public List<EverisCustomer> findByNameAndSurName1AndSurName2(final String name, final String surname1, final String surname2);
	
}
