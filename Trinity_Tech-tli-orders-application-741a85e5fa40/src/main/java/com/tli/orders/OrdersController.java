package com.tli.orders;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrdersController {

	@Autowired OrdersRepository ordersRepository;

	@GetMapping("/allOrders")
  	public Iterable<orders> getAllOrders() {
    return ordersRepository.findAll();
}

	@GetMapping("/orders/{id}")
	public ResponseEntity<orders> getOrdersById(@PathVariable("id") long id) {
		Optional<orders> orderData = ordersRepository.findById(id);

		if (orderData.isPresent()) {
			return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
		} else {	
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/orders/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<orders> createOrder(@Valid @RequestBody orders orders) {
		return ResponseEntity.ok(ordersRepository.save(orders));
	}

	@PutMapping("/orders/{id}/update")
	public ResponseEntity<orders> updateOrders(@PathVariable("id") long id, @RequestBody orders orders) {
		Optional<orders> ordersData = ordersRepository.findById(id);

		if (ordersData.isPresent()) {
			orders _orders = ordersData.get();
			_orders.setNumber(orders.getNumber());
			_orders.setOrderId(orders.getOrderId());
			_orders.setName(orders.getName());
			_orders.setPrice(orders.getPrice());
			_orders.setQuantity(orders.getQuantity());
			return new ResponseEntity<>(ordersRepository.save(_orders), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/orders/{id}/cancel")
	@ResponseBody
	public String cancelOrders(@PathVariable("id") long id) {
			ordersRepository.deleteById(id);
			return "Canceled Order";
	}

	@RequestMapping(value = "/orders/{id}/deleteItem",
		method = RequestMethod.DELETE)
	@ResponseBody
	public String removeLineItem(@PathVariable("id") @RequestBody List<orders> order) {
		OrdersService.removeLineItem(order);
		return "Deleted passed items";
	}

}