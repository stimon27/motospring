package me.dev.motospring.services.map;

import me.dev.motospring.model.RacingTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RacingTeamMapServiceTest {

    RacingTeamMapService racingTeamMapService;

    final Long racingTeamId = 1L;
    final String racingTeamName = "rtname";

    @BeforeEach
    void setUp() {
        racingTeamMapService = new RacingTeamMapService(new MakeMapService(), new CarMapService());
        racingTeamMapService.save(RacingTeam.builder().id(racingTeamId).name(racingTeamName).build());
    }

    @Test
    void findAll() {
        Set<RacingTeam> racingTeams = racingTeamMapService.findAll();
        assertEquals(1, racingTeams.size());
    }

    @Test
    void findById() {
        RacingTeam racingTeam = racingTeamMapService.findById(racingTeamId);
        assertEquals(racingTeamId, racingTeam.getId());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        RacingTeam racingTeam2 = RacingTeam.builder().id(id).build();
        RacingTeam savedRacingTeam = racingTeamMapService.save(racingTeam2);
        assertEquals(id, savedRacingTeam.getId());
    }

    @Test
    void saveNoId() {
        RacingTeam savedRacingTeam = racingTeamMapService.save(RacingTeam.builder().build());
        assertNotNull(savedRacingTeam);
        assertNotNull(savedRacingTeam.getId());
    }

    @Test
    void delete() {
        racingTeamMapService.delete(racingTeamMapService.findById(racingTeamId));
        assertEquals(0, racingTeamMapService.findAll().size());
    }

    @Test
    void deleteById() {
        racingTeamMapService.deleteById(racingTeamId);
        assertEquals(0, racingTeamMapService.findAll().size());
    }

    @Test
    void findByName() {
        RacingTeam racingTeam = racingTeamMapService.findByName(racingTeamName);
        assertNotNull(racingTeam);
        assertEquals(racingTeamId, racingTeam.getId());
    }

    @Test
    void findByNameNotFound() {
        RacingTeam racingTeam = racingTeamMapService.findByName("foo");
        assertNull(racingTeam);
    }
}