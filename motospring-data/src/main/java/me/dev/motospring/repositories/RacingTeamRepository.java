package me.dev.motospring.repositories;

import me.dev.motospring.model.RacingTeam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RacingTeamRepository extends CrudRepository<RacingTeam, Long> {
    RacingTeam findByName(String name);
    List<RacingTeam> findAllByNameLike(String name);
}
