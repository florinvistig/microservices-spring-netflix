package ro.microservices.inventory.services;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.microservices.inventory.entities.Product;


@Aspect
@Component
public class AspectService {

    @Before("execution(* ro.microservices.inventory.repositories.ProductRepository.save(*)) && args(product)")

    public void beforeSampleCreation(Product product) {
        System.out.println("test");

    }

}
