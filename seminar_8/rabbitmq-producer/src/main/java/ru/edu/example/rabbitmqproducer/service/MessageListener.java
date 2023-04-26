package ru.edu.example.rabbitmqproducer.service;

import static ru.edu.example.rabbitmqproducer.config.RabbitMqConfig.QUEUE_NAME;
import static ru.edu.example.rabbitmqproducer.config.RabbitMqConfig.SUB_QUEUE_NAME;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageListener {

    @RabbitListener(queues = QUEUE_NAME)
    public void receiveQueue(String message) {
        log.info("Received message {} for queue {}", message, QUEUE_NAME);
    }

    @RabbitListener(queues = SUB_QUEUE_NAME)
    public void receiveSubQueue(String message) {
        log.info("Received message {} for queue {}", message, SUB_QUEUE_NAME);
    }

}
