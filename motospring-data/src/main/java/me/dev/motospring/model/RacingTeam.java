package me.dev.motospring.model;

import java.util.Set;

public class RacingTeam extends Group {

    private Set<Car> cars;

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
