package com.example.electronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.electronics.dto.ApiResponseMessage;
import com.example.electronics.dto.CreateOrderRequest;
import com.example.electronics.dto.OrderUpdateRequest;
import com.example.electronics.dto.PageableResponse;
import com.example.electronics.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// create
	@PostMapping
	public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody CreateOrderRequest request) {
		OrderDto order = orderService.createOrder(request);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}

	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<ApiResponseMessage> removeOrder(@PathVariable String orderId) {
		orderService.removeOrder(orderId);
		ApiResponseMessage responseMessage = new ApiResponseMessage.Builder().status(HttpStatus.OK)
				.message("order is removed !!").success(true).build();
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);

	}

	// get orders of the user

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<OrderDto>> getOrdersOfUser(@PathVariable String userId) {
		List<OrderDto> ordersOfUser = orderService.getOrdersOfUser(userId);
		return new ResponseEntity<>(ordersOfUser, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<PageableResponse<OrderDto>> getOrders(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "orderedDate", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "desc", required = false) String sortDir) {
		PageableResponse<OrderDto> orders = orderService.getOrders(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	// Assignment Solution: update order
	@PutMapping("/{orderId}")
	public ResponseEntity<OrderDto> updateOrder(@PathVariable("orderId") String orderId,
			@RequestBody OrderUpdateRequest request) {

		OrderDto dto = this.orderService.updateOrder(orderId, request);
		return ResponseEntity.ok(dto);

	}

}