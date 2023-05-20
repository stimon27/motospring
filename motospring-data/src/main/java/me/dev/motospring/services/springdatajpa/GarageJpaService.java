package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.model.Garage;
import me.dev.motospring.repositories.GarageRepository;
import me.dev.motospring.services.GarageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class GarageJpaService implements GarageService {
    
    private final GarageRepository garageRepository;

    public GarageJpaService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Set<Garage> findAll() {
        Set<Garage> garages = new HashSet<>();
        garageRepository.findAll().forEach(garages::add);
        return garages;
    }

    @Override
    public Garage findById(Long id) {
        return garageRepository.findById(id).orElse(null);
    }

    @Override
    public Garage save(Garage garage) {
        return garageRepository.save(garage);
    }

    @Override
    public void delete(Garage garage) {
        garageRepository.delete(garage);
    }

    @Override
    public void deleteById(Long id) {
        garageRepository.deleteById(id);
    }
}
