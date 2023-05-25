package me.dev.motospring.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TuningCommand {
    private Long id;
    private LocalDate date;
    private String description;
    private CarCommand car;
}
