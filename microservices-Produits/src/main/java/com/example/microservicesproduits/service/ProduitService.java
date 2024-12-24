package com.example.microservicesproduits.service;

import com.example.microservicesproduits.entity.Produit;
import com.example.microservicesproduits.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Long id, Produit updatedProduit) {
        Produit existingProduit = getProduitById(id);
        existingProduit.setNom(updatedProduit.getNom());
        existingProduit.setDescription(updatedProduit.getDescription());
        existingProduit.setPrix(updatedProduit.getPrix());
        existingProduit.setQuantite(updatedProduit.getQuantite());
        return produitRepository.save(existingProduit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}

