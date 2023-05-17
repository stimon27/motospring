package me.dev.motospring.services.map;

import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.RacingTeamService;
import org.hibernate.cfg.NotYetImplementedException;

import java.util.Set;

public class RacingTeamServiceMap extends AbstractMapService<RacingTeam, Long> implements RacingTeamService {
    @Override
    public Set<RacingTeam> findAll() {
        return super.findAll();
    }

    @Override
    public RacingTeam findById(Long id) {
        return super.findById(id);
    }

    @Override
    public RacingTeam save(RacingTeam racingTeam) {
        return super.save(racingTeam.getId(), racingTeam);
    }

    @Override
    public void delete(RacingTeam racingTeam) {
        super.delete(racingTeam);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public RacingTeam findByName(String name) {
        throw new NotYetImplementedException();
    }
}
