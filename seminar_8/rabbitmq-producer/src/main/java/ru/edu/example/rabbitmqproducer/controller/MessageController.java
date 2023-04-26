package ru.edu.example.rabbitmqproducer.controller;

import static ru.edu.example.rabbitmqproducer.config.RabbitMqConfig.EXCHANGE_NAME;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.example.rabbitmqproducer.model.MessageRequest;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public void sendMessage(@RequestBody MessageRequest message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", message.payload());
    }

}
