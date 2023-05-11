package me.dev.motospring.services;

import me.dev.motospring.model.Car;

import java.util.Set;

public interface CarService {
    Car findById(Long id);
    Car save(Car car);
    Set<Car> findAll();
}
