package io.pivotal.workshop;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import io.pivotal.workshop.activemq.Producer;
import io.pivotal.workshop.activemq.Product;

@EnableJms
@SpringBootApplication
public class SimpleRpcConsumerActiveApplication {

	@Autowired
	Producer producer;
 
	public static void main(String[] args) {
		SpringApplication.run(SimpleRpcConsumerActiveApplication.class, args);
	}
 
	public void run(String... args) throws Exception {
		/*
		 * APPLE
		 */
		Product iphone7 = new Product("Iphone 7", "iphone");
		Product iPadPro = new Product("IPadPro", "ipad");
		
		// sending
        producer.send(iphone7, "apple");
        producer.send(iPadPro, "apple");
        
        /*
         * SAMSUNG 
         */
        Product gearS3 = new Product("Gear S3", "smartwatch");
        Product galaxyS8 = new Product("Galaxy S8", "smartphone");
        
        // sending
        producer.send(gearS3, "samsung");
        producer.send(galaxyS8, "samsung");
	}
}
