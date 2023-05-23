package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.exceptions.NotFoundException;
import me.dev.motospring.model.Car;
import me.dev.motospring.repositories.CarRepository;
import me.dev.motospring.services.CarService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
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
        Optional<Car> carOptional = carRepository.findById(id);

        if (carOptional.isEmpty()) {
            throw new NotFoundException("Car with id=" + id + " could not be found.");
        }

        return carOptional.get();
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
