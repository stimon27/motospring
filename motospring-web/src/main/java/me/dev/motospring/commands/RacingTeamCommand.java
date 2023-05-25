package me.dev.motospring.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RacingTeamCommand {
    private Long id;
    private String name;
    private String nationality;
    private String racingDiscipline;
    private LocalDate creationDate;
    private String motto;
    private Set<CarCommand> cars;

}
