package com.example.microservicescommandes.DTO;

import com.example.microservicescommandes.entity.CommandeItem;

import java.util.List;

@lombok.Data
public class CommandeDTO {
    private Long clientId;
    private List<CommandeItem> items;

    // Getters et Setters
}

