package ro.microservices.store.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import ro.microservices.store.entities.Category;
import ro.microservices.store.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@RestResource(path="by-code")
	Collection<Product> findByCode(@Param("code") final String code);
	
	Collection<Product> getProductByCategory(final Category category);
}
