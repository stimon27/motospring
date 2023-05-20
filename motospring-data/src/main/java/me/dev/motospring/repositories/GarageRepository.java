package me.dev.motospring.repositories;

import me.dev.motospring.model.Garage;
import org.springframework.data.repository.CrudRepository;

public interface GarageRepository extends CrudRepository<Garage, Long> {
}
