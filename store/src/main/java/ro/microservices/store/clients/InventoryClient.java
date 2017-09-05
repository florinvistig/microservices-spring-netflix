package ro.microservices.store.clients;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ro.microservices.store.models.InventoryModel;

@Service
public class InventoryClient {
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	private final String apiUrl;

	public InventoryClient(@Value("${inventory.api.url}") String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	public InventoryModel getProductInventory(final String code) {
		String url = apiUrl + "/v1/products/" + code;
		
		try {
			return restTemplate.getForEntity(url, InventoryModel.class).getBody();
		} 
		
		//@TODO DO NOT SWALLOW EXCEPTIONS!!
		catch ( Exception e ) {  
			
			return InventoryModel.builder()
					.price(BigDecimal.ZERO)
					.stock(0).build();
		}
	}
}
