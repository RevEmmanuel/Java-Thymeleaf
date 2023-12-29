package org.springframework.samples.petclinic.vet;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Services {

	private List<VetService> vetServices;

	@XmlElement
	public List<VetService> getVetServiceList() {
		if (vetServices == null) {
			vetServices = new ArrayList<>();
		}
		return vetServices;
	}

}
