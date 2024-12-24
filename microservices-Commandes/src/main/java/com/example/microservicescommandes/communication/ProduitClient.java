package com.example.microservicescommandes.communication;

import com.example.microservicesproduits.entity.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produit-service")
public interface ProduitClient {

    @GetMapping("/api/produits/{id}")
    Produit getProduitById(@PathVariable Long id);
}

