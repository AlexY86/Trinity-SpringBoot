package com.tli.orders.controller;

import javax.validation.Valid;

import com.tli.orders.model.Order;
import com.tli.orders.repository.OrdersRepository;
import com.tli.orders.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;

	@GetMapping("/allOrders")
	public List<Order> getAllOrders() {
		return ordersRepository.findAll();
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrdersById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Order orders = ordersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for id :: " + id));
		return ResponseEntity.ok().body(orders);
	}

	@PostMapping("/orders/create")
	public Order createOrder(@Valid @RequestBody Order orders) {
		return ordersRepository.save(orders);
	}

	@PutMapping("/orders/{id}/update")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long id, @Valid @RequestBody Order orderUpdate)
			throws ResourceNotFoundException {
		Order orders = ordersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		orders.setNumber(orderUpdate.getNumber());
		orders.setOrderId(orderUpdate.getOrderId());
		orders.setName(orderUpdate.getName());
		orders.setPrice(orderUpdate.getPrice());
		orders.setQuantity(orderUpdate.getQuantity());
		orders.setCreatedBy(orderUpdate.getCreatedBy());
		orders.setCreatedDate(orderUpdate.getCreatedDate());
		orders.setModifiedBy(orderUpdate.getModifiedBy());
		orders.setModifiedDate(orderUpdate.getModifiedDate());
		orders.setStatusId(orderUpdate.getStatusId());
		orders.setOrderStatusName(orderUpdate.getOrderStatusName());
		final Order updatOrder = ordersRepository.save(orders);
		return ResponseEntity.ok(updatOrder);
	}

	@DeleteMapping("/orders/{id}/cancel")
	public Map<String, Boolean> cancelOrders(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Order orders = ordersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		ordersRepository.delete(orders);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/orders/{id}/deleteItem/name")
	public Map<String, Boolean> deleteItem(@PathVariable(value = "id") String name, Long id) throws ResourceNotFoundException {
		Order orders = ordersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this name :: " + name));

		ordersRepository.delete(orders);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}