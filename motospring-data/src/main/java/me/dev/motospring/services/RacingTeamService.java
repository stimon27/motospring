package me.dev.motospring.services;

import me.dev.motospring.model.RacingTeam;

import java.util.List;

public interface RacingTeamService extends CrudService<RacingTeam, Long> {
    RacingTeam findByName(String name);
    List<RacingTeam> findAllByNameLike(String name);
}
