package com.example.microservicesproduits.repository;

import com.example.microservicesproduits.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
