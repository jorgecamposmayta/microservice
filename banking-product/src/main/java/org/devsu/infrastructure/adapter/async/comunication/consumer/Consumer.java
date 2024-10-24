package org.devsu.infrastructure.adapter.async.comunication.consumer;

import lombok.extern.slf4j.Slf4j;
import org.devsu.infrastructure.adapter.async.comunication.payload.ResponseCustomer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @RabbitListener(queues = {"${devsu.queue.name.rs}"})
    public void receive(@Payload ResponseCustomer message){
        log.info("Received message to string {}", message.getId());

        log.info("Received message {}", message);
    }
}
