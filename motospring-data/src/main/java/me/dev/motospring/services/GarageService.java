package me.dev.motospring.services;

import me.dev.motospring.model.Garage;

import java.util.Set;

public interface GarageService {
    Garage findById(Long id);
    Garage save(Garage garage);
    Set<Garage> findAll();
}
