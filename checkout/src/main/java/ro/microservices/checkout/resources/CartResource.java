package ro.microservices.checkout.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.microservices.checkout.entities.Order;
import ro.microservices.checkout.entities.OrderItem;
import ro.microservices.checkout.models.Cart;
import ro.microservices.checkout.repositories.OrderItemRepository;
import ro.microservices.checkout.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("cart")
public class CartResource {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;


	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody final Cart cart){
		Order newOrder = orderRepository.save(new Order());
		List<OrderItem> orderItems = cart.getProducts().stream()
				.map(p -> {
					OrderItem orderItem = new OrderItem();
					orderItem.setCode(p.getCode());
					orderItem.setQuantity(p.getQuantity());
					orderItem.setOrderId(newOrder.getId());

					return orderItemRepository.save(orderItem);
				})
				.collect(Collectors.toList());
		newOrder.setOrderItems(orderItems);
		return ResponseEntity.ok(newOrder);
	}
}
