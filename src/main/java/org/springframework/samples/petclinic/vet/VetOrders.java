package org.springframework.samples.petclinic.vet;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Pet;

@Entity
@Table(name = "vet_orders")
public class VetOrders extends BaseEntity {

	@ManyToOne
	private Pet pet;

	@ManyToOne
	private Vet vet;

	@ManyToOne
	private VetService vetService;

	private Double amount;

	private Double tax;

	private Double total;

	private Status status;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Vet getVet() {
		return vet;
	}

	public void setVet(Vet vet) {
		this.vet = vet;
	}

	public VetService getVetService() {
		return vetService;
	}

	public void setVetService(VetService vetService) {
		this.vetService = vetService;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
