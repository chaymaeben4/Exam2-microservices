package com.example.microservicescommandes.entity;

import jakarta.persistence.*;

@Entity
@lombok.Data
public class CommandeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;

    private Long produitId; // Référence au produit (lié au microservice Produit)

    private int quantite;

    private double prix;

    // Getters et Setters
}
