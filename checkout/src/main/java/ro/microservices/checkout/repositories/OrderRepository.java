package ro.microservices.checkout.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.microservices.checkout.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
