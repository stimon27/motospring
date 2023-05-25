package me.dev.motospring.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class GarageCommand {
    private Long id;
    private String name;
    private String nationality;
    private Set<StyleCommand> styles;
}
