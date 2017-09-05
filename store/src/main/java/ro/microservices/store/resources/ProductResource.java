package ro.microservices.store.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.microservices.store.models.ProductModel;
import ro.microservices.store.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("v1/products")
public class ProductResource {
	
	private final ProductService productService;
	
	@Autowired
	public ProductResource(ProductService productService) {
		this.productService= productService;
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<ProductModel> getProduct(@PathVariable("code") final String code) {
		
		System.out.println("=================================");
		System.out.println("Searching for :: " + code);
		System.out.println("=================================");
		
		return productService.getByCode(code)
				.map(p -> ResponseEntity.ok(p))
				.orElseGet(() -> new ResponseEntity("We are sorry for your stupidness.", HttpStatus.NOT_FOUND))
		;
	}
	
}
