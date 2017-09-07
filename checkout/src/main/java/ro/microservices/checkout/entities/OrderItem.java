package ro.microservices.checkout.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderItem {

	@Id
	@GeneratedValue
	private Long id;

	private String code;

	private Integer quantity;

	private Long orderId;
}
