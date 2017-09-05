package ro.microservices.inventory.resources;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.microservices.inventory.mappers.ProductMapper;
import ro.microservices.inventory.models.ProductModel;
import ro.microservices.inventory.repositories.ProductRepository;

@RestController
@RequestMapping("v1/products")
public class ProductResource {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductResource (final ProductRepository productRepository) {
		this.productRepository = Objects.requireNonNull(productRepository, "product repository should not be null"); 
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<ProductModel> getProductsByCode(@PathVariable final String code) {
		
		return productRepository.findByCode(code)
				.stream()
				.findFirst()
				.map(e -> ResponseEntity.ok( ProductMapper.toModel(e)))
				.orElseGet( () -> new ResponseEntity("Sorry. Could not find any product matching that code.", HttpStatus.NOT_FOUND))
			;
	}
	
}
