package com.example.microservicescommandes.repository;

import com.example.microservicescommandes.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeItemRepository extends JpaRepository<CommandeItem, Long> {
}

