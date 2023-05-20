package me.dev.motospring.repositories;

import me.dev.motospring.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
