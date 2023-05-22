package me.dev.motospring.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "racingteams")
public class RacingTeam extends Group {

    @Builder
    public RacingTeam(Long id, String name, String nationality, String racingDiscipline, LocalDate creationDate, String motto, Set<Car> cars) {
        super(id, name, nationality);
        this.racingDiscipline = racingDiscipline;
        this.creationDate = creationDate;
        this.motto = motto;
        this.cars = cars;
    }

    @Column(name = "racing_discipline")
    private String racingDiscipline;
    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
    @Column(name = "motto")
    private String motto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "racingTeam")
    private Set<Car> cars = new HashSet<>();
}
