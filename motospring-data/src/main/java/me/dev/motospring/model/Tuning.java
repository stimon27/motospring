package me.dev.motospring.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tunings")
public class Tuning extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
