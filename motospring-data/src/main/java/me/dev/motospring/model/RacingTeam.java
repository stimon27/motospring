package me.dev.motospring.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class RacingTeam extends Group {

    private String racingDiscipline;
    private LocalDate creationDate;
    private String motto;
    private Set<Car> cars = new HashSet<>();

    public String getRacingDiscipline() {
        return racingDiscipline;
    }

    public void setRacingDiscipline(String racingDiscipline) {
        this.racingDiscipline = racingDiscipline;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
