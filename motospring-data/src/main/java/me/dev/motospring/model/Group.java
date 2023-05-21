package me.dev.motospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Group extends BaseEntity {
    public Group(Long id, String name, String nationality) {
        super(id);
        this.name = name;
        this.nationality = nationality;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "nationality")
    private String nationality;
}
