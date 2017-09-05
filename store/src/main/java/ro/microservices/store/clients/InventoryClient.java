package ro.microservices.store.clients;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import ro.microservices.store.models.InventoryModel;

import javax.validation.constraints.NotNull;

@FeignClient(name="inventory-service", fallbackFactory = InventoryClientFallback.class)
public interface InventoryClient {

	@RequestMapping(value = "/v1/products/{code}", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<InventoryModel> getProductInventory(@PathVariable("code") @NotNull String code);
}
