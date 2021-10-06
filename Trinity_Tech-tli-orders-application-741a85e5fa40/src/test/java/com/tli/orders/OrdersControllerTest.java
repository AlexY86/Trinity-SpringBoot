package com.tli.orders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tli.orders.controller.OrdersController;
import com.tli.orders.model.Order;
import com.tli.orders.repository.OrdersRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@RunWith(MockitoJUnitRunner.class)
public class OrdersControllerTest {

	@InjectMocks
	private OrdersController ordersController;

	@Mock
	OrdersRepository ordersRepository;

	private MockMvc mockMvc;

	private JacksonTester<List<Order>> ordersListJson;
	private JacksonTester<Order> ordersJson;

	Order orders;
	List<Order> ordersList;

	@BeforeAll
	public void setup() {
		this.ordersController = new OrdersController();

		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(ordersController).build();

		ordersList = new ArrayList<>();
		orders = new Order();
		orders.setId(1);
		orders.setName("alex");
		ordersList.add(orders);
	}

	@Testable
	public void shouldGetAllOrders()  throws Exception {
		
		given(ordersRepository()).willReturn(ordersList);
		MockHttpServletResponse response = mockMvc
								.perform(MockMvcRequestBuilders.get("/allOrders").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

								assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
								assertThat(response.getContentAsString()).isEqualTo(ordersListJson.write(ordersList).getJson());

	}

	private Object ordersRepository() {
		return null;
	}

	// @Testable
	// public void shouldGetOrdersById() {
	// 	// TODO: initialize args
	// 	long id;

	// 	ResponseEntity<orders> actualValue = ordersController.getOrdersById(id);

	// 	// TODO: assert scenario
	// }

	// @Testable
	// public void shouldCreateOrder() {
	// 	// TODO: initialize args
	// 	orders orders;

	// 	ResponseEntity<orders> actualValue = ordersController.createOrder(orders);

	// 	// TODO: assert scenario
	// }

	// @Testable
	// public void shouldUpdateOrders() {
	// 	// TODO: initialize args
	// 	long id;
	// 	orders orders;

	// 	ResponseEntity<orders> actualValue = ordersController.updateOrders(id, orders);

	// 	// TODO: assert scenario
	// }

	// @Testable
	// public void shouldCancelOrders() {
	// 	// TODO: initialize args
	// 	long id;

	// 	String actualValue = ordersController.cancelOrders(id);

	// 	// TODO: assert scenario
	// }

	// @Testable
	// public void shouldRemoveLineItem() {
	// 	// TODO: initialize args
	// 	List<orders> order;

	// 	String actualValue = ordersController.removeLineItem(order);

	// 	// TODO: assert scenario
	// }
}
