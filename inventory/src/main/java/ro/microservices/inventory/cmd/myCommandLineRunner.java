package ro.microservices.inventory.cmd;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ro.microservices.inventory.entities.Product;
import ro.microservices.inventory.repositories.ProductRepository;

@Component
public class myCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		List<Product> products = Arrays.asList(
					Product.builder().code("PROD1").stock(5).price(new BigDecimal(20)).build(),
					
					Product.builder().code("PROD2").price(new BigDecimal(20.21)).stock(1).build(),
					
					Product.builder().code("PROD3").price(new BigDecimal(394.29)).stock(23).build()
		);
		
		productRepository.save(products);
	}
	
}
