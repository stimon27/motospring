package me.dev.motospring.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Group extends BaseEntity {
    private String name;
    private String nationality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
