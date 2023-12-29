package org.springframework.samples.petclinic.vet;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface TaxRepository extends Repository<Taxes, Integer> {

	@Transactional(readOnly = true)
	@Cacheable("taxes")
	Taxes findTaxesByCountryEqualsIgnoreCase(String country);


}
