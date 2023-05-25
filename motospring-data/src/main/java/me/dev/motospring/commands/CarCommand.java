package me.dev.motospring.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CarCommand {
    private Long id;
    private String model;
    private MakeCommand make;
    private RacingTeamCommand racingTeam;
    private Set<TuningCommand> tunings;
}
