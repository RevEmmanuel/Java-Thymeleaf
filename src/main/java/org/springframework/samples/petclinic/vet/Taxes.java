package org.springframework.samples.petclinic.vet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "taxes")
public class Taxes extends BaseEntity {

//	@Column(unique = true)
	private String country;

	private Double percentage;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
}
