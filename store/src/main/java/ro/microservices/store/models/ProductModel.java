package ro.microservices.store.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.microservices.store.entities.Category;

@Data
@AllArgsConstructor
@Builder
public class ProductModel {

	private String code;
	
	private Category category;
	
	private BigDecimal price;
	
	private Integer stock;
	
}
