package com.example.microservicesnotifications.listener;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationListener {

    @KafkaListener(topics = "commande_topic", groupId = "notification-group")
    public void handleCommandeCreated(String message) {
        System.out.println("Notification reçue pour la commande : " + message);

        sendNotification(message);
    }

    private void sendNotification(String message) {
        System.out.println("Envoi de la notification : " + message);
    }
}

