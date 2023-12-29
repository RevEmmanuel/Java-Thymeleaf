package org.springframework.samples.petclinic.vet;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface VetServiceRepository extends Repository<VetService, Integer> {

	@Transactional(readOnly = true)
	@Cacheable("vet_service")
	Collection<VetService> findAll() throws DataAccessException;

	@Transactional(readOnly = true)
	@Cacheable("vet_service")
	VetService findById(Integer id) throws DataAccessException;

	@Transactional(readOnly = true)
	@Cacheable("vet_service")
	Page<VetService> findAll(Pageable pageable) throws DataAccessException;

	@Transactional(readOnly = true)
	@Cacheable("vet_service")
	Page<VetService> findAllByVet_Id(Integer vetId, Pageable pageable) throws DataAccessException;


}
