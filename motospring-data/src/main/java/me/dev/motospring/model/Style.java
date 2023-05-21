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
@Table(name = "styles")
public class Style extends BaseEntity {

    @Column(name = "tag")
    private String tag;
}
