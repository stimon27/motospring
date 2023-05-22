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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
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
    void displayRacingTeam() throws Exception {
        when(racingTeamService.findById(anyLong())).thenReturn(RacingTeam.builder().id(1L).build());

        mockMvc.perform(get("/racingteams/777"))
                .andExpect(status().isOk())
                .andExpect(view().name("/racingTeams/racingTeamDetails"))
                .andExpect(model().attribute("racingTeam", hasProperty("id", is(1L))));
    }

    @Test
    void processFindFormReturnMany() throws Exception {
        when(racingTeamService.findAllByNameLike(anyString())).thenReturn(Arrays.asList(RacingTeam.builder().id(1L).build(),
                RacingTeam.builder().id(2L).build()));

        mockMvc.perform(get("/racingteams"))
                .andExpect(status().isOk())
                .andExpect(view().name("racingTeams/racingTeamsList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception {
        when(racingTeamService.findAllByNameLike(anyString())).thenReturn(Collections.singletonList(RacingTeam.builder().id(1L).build()));

        mockMvc.perform(get("/racingteams"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/racingteams/1"));
    }
}