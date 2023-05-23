package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.exceptions.NotFoundException;
import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.repositories.RacingTeamRepository;
import me.dev.motospring.services.RacingTeamService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class RacingTeamJpaService implements RacingTeamService {

    private final RacingTeamRepository racingTeamRepository;

    public RacingTeamJpaService(RacingTeamRepository racingTeamRepository) {
        this.racingTeamRepository = racingTeamRepository;
    }

    @Override
    public Set<RacingTeam> findAll() {
        Set<RacingTeam> racingTeams = new HashSet<>();
        racingTeamRepository.findAll().forEach(racingTeams::add);
        return racingTeams;
    }

    @Override
    public RacingTeam findById(Long id) {
        Optional<RacingTeam> racingTeamOptional = racingTeamRepository.findById(id);

        if (racingTeamOptional.isEmpty()) {
            throw new NotFoundException("Racing Team with id=" + id + " could not be found.");
        }

        return racingTeamOptional.get();
    }

    @Override
    public RacingTeam save(RacingTeam racingTeam) {
        return racingTeamRepository.save(racingTeam);
    }

    @Override
    public void delete(RacingTeam racingTeam) {
        racingTeamRepository.delete(racingTeam);
    }

    @Override
    public void deleteById(Long id) {
        racingTeamRepository.deleteById(id);
    }

    @Override
    public RacingTeam findByName(String name) {
        return racingTeamRepository.findByName(name);
    }

    @Override
    public List<RacingTeam> findAllByNameLike(String name) {
        return racingTeamRepository.findAllByNameLike(name);
    }
}
