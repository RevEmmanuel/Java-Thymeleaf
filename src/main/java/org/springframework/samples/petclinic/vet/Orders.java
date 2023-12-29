package org.springframework.samples.petclinic.vet;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Orders {

	private List<VetOrders> vets;

	@XmlElement
	public List<VetOrders> getVetOrdersList() {
		if (vets == null) {
			vets = new ArrayList<>();
		}
		return vets;
	}
}
