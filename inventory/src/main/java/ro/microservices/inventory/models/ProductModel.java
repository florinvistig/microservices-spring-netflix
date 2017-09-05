package ro.microservices.inventory.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
	
	private String code;
	
	private BigDecimal price;
	
	private Integer stock;
}
