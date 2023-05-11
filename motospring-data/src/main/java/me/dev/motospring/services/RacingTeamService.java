package me.dev.motospring.services;

import me.dev.motospring.model.RacingTeam;

import java.util.Set;

public interface RacingTeamService {
    RacingTeam findByName(String name);
    RacingTeam findById(Long id);
    RacingTeam save(RacingTeam racingTeam);
    Set<RacingTeam> findAll();
}
