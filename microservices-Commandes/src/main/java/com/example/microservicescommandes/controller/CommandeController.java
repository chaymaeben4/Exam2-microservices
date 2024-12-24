package com.example.microservicescommandes.controller;

import com.example.microservicescommandes.DTO.CommandeDTO;
import com.example.microservicescommandes.communication.KafkaMessageProducer;
import com.example.microservicescommandes.entity.Commande;
import com.example.microservicescommandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @PostMapping
    public Commande creerCommande(@RequestBody CommandeDTO commandeDTO) {
        return commandeService.creerCommande(
                commandeDTO.getClientId(),
                commandeDTO.getItems()
        );
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @DeleteMapping("/{id}")
    public void supprimerCommande(@PathVariable Long id) {
        commandeService.supprimerCommande(id);
    }

    @PostMapping
    public String createCommande(@RequestBody String commande) {
        System.out.println("Commande créée : " + commande);

        kafkaMessageProducer.sendMessage(commande);

        return "Commande créée et notification envoyée.";
    }
}

