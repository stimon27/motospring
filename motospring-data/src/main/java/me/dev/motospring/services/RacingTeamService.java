package me.dev.motospring.services;

import me.dev.motospring.model.RacingTeam;

import java.util.Set;

public interface RacingTeamService extends CrudService<RacingTeam, Long> {
    RacingTeam findByName(String name);
}
