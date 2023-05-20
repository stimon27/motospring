package me.dev.motospring.repositories;

import me.dev.motospring.model.RacingTeam;
import org.springframework.data.repository.CrudRepository;

public interface RacingTeamRepository extends CrudRepository<RacingTeam, Long> {
}
