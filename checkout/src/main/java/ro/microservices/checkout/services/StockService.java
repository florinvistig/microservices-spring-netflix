package ro.microservices.checkout.services;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import ro.microservices.checkout.models.ProductModel;

@Service
public class StockService {
	@StreamListener("stockChannel")
	public void onReceiving(final Message<ProductModel> message){
		ProductModel payload = message.getPayload();

		System.out.println("received message from kafka " + payload);
	}
}
