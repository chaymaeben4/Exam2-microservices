package com.example.microservicescommandes.service;

import com.example.microservicescommandes.entity.Commande;
import com.example.microservicescommandes.entity.CommandeItem;
import com.example.microservicescommandes.repository.CommandeItemRepository;
import com.example.microservicescommandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeItemRepository commandeItemRepository;

    @Transactional
    public Commande creerCommande(Long clientId, List<CommandeItem> items) {
        Commande commande = new Commande();
        commande.setClientId(clientId);
        commande.setDateCommande(LocalDateTime.now());

        // Calculer le total
        double total = items.stream().mapToDouble(item -> item.getPrix() * item.getQuantite()).sum();
        commande.setTotal(total);

        // Associer les items à la commande
        items.forEach(item -> item.setCommande(commande));
        commande.setItems(items);

        // Sauvegarder la commande
        commandeRepository.save(commande);

        // Sauvegarder les items
        commandeItemRepository.saveAll(items);

        return commande;
    }

    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public void supprimerCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}

