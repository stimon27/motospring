package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.exceptions.NotFoundException;
import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.repositories.RacingTeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RacingTeamJpaServiceTest {

    public static final String EXAMPLE_NAME = "example_name";
    @Mock
    RacingTeamRepository racingTeamRepository;
    @InjectMocks
    RacingTeamJpaService service;

    RacingTeam returnRacingTeam;

    @BeforeEach
    void setUp() {
        returnRacingTeam = RacingTeam.builder().id(1L).name(EXAMPLE_NAME).build();
    }

    @Test
    void findAll() {
        Set<RacingTeam> returnRacingTeamsSet = new HashSet<>();
        returnRacingTeamsSet.add(RacingTeam.builder().id(1L).build());
        returnRacingTeamsSet.add(RacingTeam.builder().id(2L).build());

        when(racingTeamRepository.findAll()).thenReturn(returnRacingTeamsSet);

        Set<RacingTeam> racingTeams = service.findAll();

        assertNotNull(racingTeams);
        assertEquals(2, racingTeams.size());
    }

    @Test
    void findById() {
        when(racingTeamRepository.findById(anyLong())).thenReturn(Optional.of(returnRacingTeam));
        RacingTeam racingTeam = service.findById(1L);
        assertNotNull(racingTeam);
    }

    @Test
    void findByIdNotFound() {
        when(racingTeamRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.findById(1L));
    }

    @Test
    void save() {
        RacingTeam racingTeamToSave = RacingTeam.builder().id(1L).build();
        when(racingTeamRepository.save(any())).thenReturn(returnRacingTeam);
        RacingTeam savedRacingTeam = service.save(racingTeamToSave);
        assertNotNull(savedRacingTeam);
        verify(racingTeamRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnRacingTeam);
        verify(racingTeamRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(racingTeamRepository).deleteById(anyLong());
    }

    @Test
    void findByName() {
        when(racingTeamRepository.findByName(any())).thenReturn(returnRacingTeam);
        RacingTeam racingTeam = service.findByName(EXAMPLE_NAME);
        assertEquals(EXAMPLE_NAME, racingTeam.getName());
        verify(racingTeamRepository).findByName(any());
    }
}