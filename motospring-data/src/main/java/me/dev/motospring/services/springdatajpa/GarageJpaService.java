package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.exceptions.NotFoundException;
import me.dev.motospring.model.Garage;
import me.dev.motospring.repositories.GarageRepository;
import me.dev.motospring.services.GarageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
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
        Optional<Garage> garageOptional = garageRepository.findById(id);

        if (garageOptional.isEmpty()) {
            throw new NotFoundException("Garage with id=" + id + " could not be found.");
        }

        return garageOptional.get();
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
