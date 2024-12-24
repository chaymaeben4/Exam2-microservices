package com.example.microservicescommandes.repository;

import com.example.microservicescommandes.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
