package me.dev.motospring.controllers;

import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.RacingTeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RacingTeamControllerTest {

    @Mock
    RacingTeamService racingTeamService;

    @InjectMocks
    RacingTeamController controller;

    Set<RacingTeam> racingTeams;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        racingTeams = new HashSet<>();
        racingTeams.add(RacingTeam.builder().id(1L).build());
        racingTeams.add(RacingTeam.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listRacingTeams() throws Exception {
        when(racingTeamService.findAll()).thenReturn(racingTeams);

        mockMvc.perform(get("/racingteams"))
                .andExpect(status().isOk())
                .andExpect(view().name("racingTeams/index"))
                .andExpect(model().attribute("racingteams", hasSize(2)));
    }

    @Test
    void listRacingTeamsByIndex() throws Exception {
        when(racingTeamService.findAll()).thenReturn(racingTeams);

        mockMvc.perform(get("/racingteams/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("racingTeams/index"))
                .andExpect(model().attribute("racingteams", hasSize(2)));
    }

    @Test
    void findRacingTeams() throws Exception {
        mockMvc.perform(get("/racingteams/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyNoInteractions(racingTeamService);
    }
}