package ro.microservices.checkout.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
	
	private String code;
	
	private BigDecimal price;
	
	private Integer stock;
}
