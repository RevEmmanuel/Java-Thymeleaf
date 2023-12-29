/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.vet;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
class VetController {

	private final VetRepository vetRepository;
	private final VetServiceRepository vetServiceRepository;
	private final TaxRepository taxRepository;
	private final VetOrderRepository vetOrderRepository;

	public VetController(VetRepository clinicService, VetServiceRepository vetServiceRepository, TaxRepository taxRepository, VetOrderRepository vetOrderRepository) {
		this.vetRepository = clinicService;
		this.vetServiceRepository = vetServiceRepository;
		this.taxRepository = taxRepository;
		this.vetOrderRepository = vetOrderRepository;
	}


	@GetMapping("/vets.html")
	public String showVetList(@RequestParam(defaultValue = "1") int page, Model model) {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects so it is simpler for Object-Xml mapping
		Vets vets = new Vets();
		Page<Vet> paginated = findPaginated(page);
		vets.getVetList().addAll(paginated.toList());
		return addPaginationModel(page, paginated, model);
	}


	@GetMapping("/animalStats.html")
	public String getAnimalStats() {
		return "fragments/animalStats";
	}


	@GetMapping("/vets/login")
	public String loginVets() {
		return "vets/login_vets";
	}


	@GetMapping("/vets/services")
	public String getVetsService(@RequestParam Integer vetId, @RequestParam(defaultValue = "1") int page, Model model, HttpSession session) {
		session.setAttribute("vetId", vetId);
		Services vets = new Services();
		Page<VetService> paginated = findPaginatedServices(vetId, page);
		vets.getVetServiceList().addAll(paginated.toList());
		return addPaginationModelService(page, paginated, model);
	}

	@GetMapping("/vets/orders")
	public String getVetsOrder(@RequestParam Integer orderId, @RequestParam(defaultValue = "1") int page, Model model, HttpSession session) {
		session.setAttribute("vetOrderId", orderId);
		Orders vets = new Orders();
		Page<VetOrders> paginated = findPaginatedVetOrders(orderId, page);
		vets.getVetOrdersList().addAll(paginated.toList());
		return addPaginationModelOrder(page, paginated, model);
	}

	@PostMapping("/vets/orders/complete")
	public String vetsCompleteOrder(@RequestParam Integer orderId, HttpSession session) {
		session.setAttribute("vetOrderId", orderId);
		VetOrders order = vetOrderRepository.findById(orderId);
		order.setStatus(Status.COMPLETED);
		vetOrderRepository.save(order);
		return "redirect:/vets/orders";
	}


	@PostMapping("/vets/order")
	public String orderVetService(@RequestParam Integer vetId, @RequestParam Integer serviceId, Model model) {
		VetOrders order = new VetOrders();
		order.setVet(vetRepository.findById(vetId));
		order.setAmount(vetServiceRepository.findById(serviceId).getServicePrice());
		order.setVetService(vetServiceRepository.findById(serviceId));
		order.setStatus(Status.NEW);
		order.setTax(taxRepository.findTaxesByCountryEqualsIgnoreCase(vetRepository.findById(vetId).getCountry()).getPercentage() * order.getAmount() / 100);
		order.setTotal(order.getAmount() + order.getTax());
		order.setPet(null);
		vetOrderRepository.save(order);
		model.addAttribute("serviceName", order.getVetService().getServiceName());
		model.addAttribute("amount", order.getAmount());
		model.addAttribute("tax", order.getTax());
		model.addAttribute("total", order.getTotal());
		return "fragments/checkout";
	}


	@PostMapping("/vets-login")
	public String loginVets(@RequestParam String username, @RequestParam String password, Model model) {
		// Validate username and password (perform authentication logic here)
		Vet foundVet = vetRepository.findVetByFirstName(username);
//		System.out.println("pass here");
		if (foundVet.getFirstName().equals(username) && foundVet.getPassword().equals(password)) {
			return "redirect:/vets.html";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "vets/login_vets";
		}
	}


	private String addPaginationModel(int page, Page<Vet> paginated, Model model) {
		List<Vet> listVets = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listVets", listVets);
		return "vets/vetList";
	}


	private String addPaginationModelService(int page, Page<VetService> paginated, Model model) {
		List<VetService> listVets = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listVets", listVets);
		return "vets/vetService";
	}

	private String addPaginationModelOrder(int page, Page<VetOrders> paginated, Model model) {
		List<VetOrders> listVets = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listVets", listVets);
		return "vets/orderTable";
	}


	private Page<Vet> findPaginated(int page) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return vetRepository.findAll(pageable);
	}


	private Page<VetService> findPaginatedServices(Integer id, int page) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return vetServiceRepository.findAllByVet_Id(id, pageable);
	}

	private Page<VetOrders> findPaginatedVetOrders(Integer id, int page) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return vetOrderRepository.findAllByVet_Id(id, pageable);
	}


	@GetMapping({ "/vets" })
	public @ResponseBody Vets showResourcesVetList() {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects so it is simpler for JSon/Object mapping
		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetRepository.findAll());
		return vets;
	}


}
