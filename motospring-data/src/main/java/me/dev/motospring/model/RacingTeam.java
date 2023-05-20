package me.dev.motospring.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "racingteams")
public class RacingTeam extends Group {

    @Column(name = "racing_discipline")
    private String racingDiscipline;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "motto")
    private String motto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "racingTeam")
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
