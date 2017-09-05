package ro.microservices.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

import ro.microservices.store.entities.Category;
import ro.microservices.store.entities.Product;
import ro.microservices.store.repositories.CategoryRepository;
import ro.microservices.store.repositories.ProductRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	
	@Component
	class DummyData implements CommandLineRunner {

		@Autowired
		private CategoryRepository categoryRepository; 
		
		@Autowired
		private ProductRepository productRepository;
		
		@Override
		public void run(String... args) throws Exception {
			
			Category category = categoryRepository.save(
					Category.builder().name("Category 1").build()
				);
			
			productRepository.save(Product.builder().code("PROD1").category(category).build());
			
		}
		
	}
}
