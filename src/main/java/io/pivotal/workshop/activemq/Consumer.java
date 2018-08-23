package io.pivotal.workshop.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
		
		@JmsListener(destination = "${jsa.activemq.queue.consumer}", containerFactory="jsaFactory")
		public void appleReceive(Product product, @Header("type") String productType){
			if("iphone".equals(productType)){
				System.out.println("Recieved Iphone: " + product);			
			}else if("ipad".equals(productType)){
				System.out.println("Recieved Ipad: " + product);		
			}
		}

}
