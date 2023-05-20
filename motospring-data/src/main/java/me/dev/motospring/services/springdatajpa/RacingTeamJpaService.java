package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.repositories.CarRepository;
import me.dev.motospring.repositories.MakeRepository;
import me.dev.motospring.repositories.RacingTeamRepository;
import me.dev.motospring.services.RacingTeamService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class RacingTeamJpaService implements RacingTeamService {

    private final RacingTeamRepository racingTeamRepository;
    private final CarRepository carRepository;
    private final MakeRepository makeRepository;

    public RacingTeamJpaService(RacingTeamRepository racingTeamRepository,
                                CarRepository carRepository,
                                MakeRepository makeRepository) {
        this.racingTeamRepository = racingTeamRepository;
        this.carRepository = carRepository;
        this.makeRepository = makeRepository;
    }

    @Override
    public Set<RacingTeam> findAll() {
        Set<RacingTeam> racingTeams = new HashSet<>();
        racingTeamRepository.findAll().forEach(racingTeams::add);
        return racingTeams;
    }

    @Override
    public RacingTeam findById(Long id) {
        return racingTeamRepository.findById(id).orElse(null);
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
}
