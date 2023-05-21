package me.dev.motospring.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
