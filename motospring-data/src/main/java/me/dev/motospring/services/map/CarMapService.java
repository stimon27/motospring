package me.dev.motospring.services.map;

import me.dev.motospring.model.Car;
import me.dev.motospring.services.CarService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarMapService extends AbstractMapService<Car, Long> implements CarService {
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
        return super.save(car);
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
