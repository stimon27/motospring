package me.dev.motospring.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "makes")
public class Make extends BaseEntity {
    @Column(name = "name")
    private String name;
}
