package ro.microservices.store.clients;

import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ro.microservices.store.models.InventoryModel;

import java.math.BigDecimal;

@Component
public class InventoryClientFallback implements FallbackFactory<InventoryClient> {
    @Override
    public InventoryClient create(Throwable throwable) {
        return new InventoryClient() {
            @Override
            public ResponseEntity<InventoryModel> getProductInventory(String code) {
                return ResponseEntity.ok(InventoryModel.builder()
                        .price(BigDecimal.ZERO)
                        .stock(0)
                        .build());
            }
        };
    }
}
