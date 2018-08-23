package io.pivotal.workshop.activemq;


import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

@Service
public class Producer  {

		@Autowired
		JmsTemplate jmsTemplate;
		
		@Value("${jsa.activemq.queue.producer}")
		String queue;
		
		public void send(Product product, String companyName){
			jmsTemplate.convertAndSend(queue, product, new MessagePostProcessor() {
		        public Message postProcessMessage(Message message) throws JMSException {
		            message.setStringProperty("company", companyName);
		            return message;
		        }
		    });
		}
	
	
}
