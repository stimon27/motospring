package me.dev.motospring.services.map;

import me.dev.motospring.model.Garage;
import me.dev.motospring.services.GarageService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GarageServiceMap extends AbstractMapService<Garage, Long> implements GarageService {
    @Override
    public Set<Garage> findAll() {
        return super.findAll();
    }

    @Override
    public Garage findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Garage save(Garage garage) {
        return super.save(garage);
    }

    @Override
    public void delete(Garage garage) {
        super.delete(garage);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
