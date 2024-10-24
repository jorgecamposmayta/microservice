package org.devsu.infrastructure.adapter.in.consumer;

import lombok.extern.slf4j.Slf4j;
import org.devsu.application.port.out.CustomerRepository;
import org.devsu.domain.model.Customer;
import org.devsu.infrastructure.adapter.async.comunication.payload.RequestCustomer;
import org.devsu.infrastructure.adapter.async.comunication.payload.ResponseCustomer;
import org.devsu.infrastructure.adapter.async.comunication.publisher.Publisher;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class Consumer {

    private final CustomerRepository cumRepository;

    private final Publisher publisher;

    @Autowired
    public Consumer(CustomerRepository cumRepository, Publisher publisher) {
        this.cumRepository = cumRepository;
        this.publisher = publisher;
    }

    @RabbitListener(queues = {"${devsu.queue.name.rq}"})
    public void receive(@Payload RequestCustomer message){
        Long id=Long.valueOf(message.getId());
        log.info("Received message to string {}", message.getId());
        Optional<Customer> customer=cumRepository.finById(id);
        ResponseCustomer rsCustomer= new ResponseCustomer(String.valueOf(customer.get().getId()), customer.get().getName());
        this.publisher.send(rsCustomer);

    }
}
