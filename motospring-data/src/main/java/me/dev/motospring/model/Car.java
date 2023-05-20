package me.dev.motospring.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @Column(name = "model")
    private String model;
    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;
    @ManyToOne
    @JoinColumn(name = "racingteam_id")
    private RacingTeam racingTeam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Set<Tuning> tunings = new HashSet<>();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public RacingTeam getRacingTeam() {
        return racingTeam;
    }

    public void setRacingTeam(RacingTeam racingTeam) {
        this.racingTeam = racingTeam;
    }

    public Set<Tuning> getTunings() {
        return tunings;
    }

    public void setTunings(Set<Tuning> tunings) {
        this.tunings = tunings;
    }
}
