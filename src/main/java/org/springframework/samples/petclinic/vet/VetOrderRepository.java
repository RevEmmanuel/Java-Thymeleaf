package org.springframework.samples.petclinic.vet;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.owner.Owner;

public interface VetOrderRepository extends Repository<VetOrders, Integer> {

	void save(VetOrders order);

	Page<VetOrders> findAllByVet_Id(Integer id, Pageable pageable) throws DataAccessException;

	VetOrders findById(Integer id) throws DataAccessException;
}
