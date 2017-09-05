package ro.microservices.inventory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.microservices.inventory.config.KafkaGateway;
import ro.microservices.inventory.entities.Product;
import ro.microservices.inventory.mappers.ProductMapper;
import ro.microservices.inventory.models.ProductModel;
import ro.microservices.inventory.repositories.ProductRepository;

import java.util.function.Function;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final KafkaGateway kafkaGateway;

    @Autowired
    public ProductService(ProductRepository productRepository, KafkaGateway kafkaGateway) {
        this.productRepository = productRepository;
        this.kafkaGateway = kafkaGateway;
    }

    public ProductModel save(final ProductModel productModel){
        Product p = productRepository.findByCode(productModel.getCode()).stream()
                .findFirst()
                .map(product -> {
                    product.setPrice(productModel.getPrice());
                    return product;
                })
                .map(updateStock(productModel))
                .orElseGet(() -> ProductMapper.toEntity(productModel));

        return ProductMapper.toModel(productRepository.save(p));
    }

    private Function<Product, Product> updateStock(final ProductModel productModel) {
        return p -> {
            Integer initStock = p.getStock();
            if (!initStock.equals(productModel.getStock())){
                p.setStock(productModel.getStock());

                if (initStock == 0 || productModel.getStock() == 0){
                    kafkaGateway.write(productModel);
                }
            }
            return p;
        };
    }
}
