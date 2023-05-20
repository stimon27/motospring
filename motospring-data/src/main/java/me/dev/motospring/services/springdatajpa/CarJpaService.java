package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.model.Car;
import me.dev.motospring.repositories.CarRepository;
import me.dev.motospring.services.CarService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CarJpaService implements CarService {

    private final CarRepository carRepository;

    public CarJpaService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Set<Car> findAll() {
        Set<Car> cars = new HashSet<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
