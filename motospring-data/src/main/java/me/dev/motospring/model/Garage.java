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
@Table(name = "garages")
public class Garage extends Group {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "garage_style",
            joinColumns = @JoinColumn(name = "garage_id"),
            inverseJoinColumns = @JoinColumn(name = "style_id"))
    private Set<Style> styles = new HashSet<>();
}
