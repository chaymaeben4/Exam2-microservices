package com.example.microservicescommandes.communication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer {

    private static final String TOPIC = "commande_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.println("Envoi du message à Kafka : " + message);
        kafkaTemplate.send(TOPIC, message);
    }
}
