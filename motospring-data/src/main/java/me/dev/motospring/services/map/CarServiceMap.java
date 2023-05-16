package me.dev.motospring.services.map;

import me.dev.motospring.model.Car;
import me.dev.motospring.services.CrudService;

import java.util.Set;

public class CarServiceMap extends AbstractMapService<Car, Long> implements CrudService<Car, Long> {
    @Override
    public Set<Car> findAll() {
        return super.findAll();
    }

    @Override
    public Car findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Car save(Car car) {
        return super.save(car.getId(), car);
    }

    @Override
    public void delete(Car car) {
        super.delete(car);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
