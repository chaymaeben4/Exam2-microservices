package com.example.microservicesproduits.controller;


import com.example.microservicesproduits.entity.Produit;
import com.example.microservicesproduits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @QueryMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @QueryMapping
    public Produit getProduitById(@Argument Long id) {
        return produitService.getProduitById(id);
    }

    @MutationMapping
    public Produit createProduit(@Argument String nom, @Argument String description,
                                 @Argument double prix, @Argument int quantite) {
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setDescription(description);
        produit.setPrix(prix);
        produit.setQuantite(quantite);
        return produitService.createProduit(produit);
    }

    @MutationMapping
    public Produit updateProduit(@Argument Long id, @Argument String nom,
                                 @Argument String description, @Argument double prix,
                                 @Argument int quantite) {
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setDescription(description);
        produit.setPrix(prix);
        produit.setQuantite(quantite);
        return produitService.updateProduit(id, produit);
    }

    @MutationMapping
    public String deleteProduit(@Argument Long id) {
        produitService.deleteProduit(id);
        return "Produit supprimé avec succès";
    }
}

