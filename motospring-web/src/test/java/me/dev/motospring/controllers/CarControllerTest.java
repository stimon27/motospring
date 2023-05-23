package me.dev.motospring.controllers;

import me.dev.motospring.model.Car;
import me.dev.motospring.model.Make;
import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.CarService;
import me.dev.motospring.services.MakeService;
import me.dev.motospring.services.RacingTeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    CarService carService;
    @Mock
    RacingTeamService racingTeamService;
    @Mock
    MakeService makeService;

    MockMvc mockMvc;

    RacingTeam racingTeam;
    Set<Make> makes;

    @InjectMocks
    CarController carController;

    @BeforeEach
    void setUp() {
        racingTeam = RacingTeam.builder().id(1L).build();
        makes = Set.of(Make.builder().id(1L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(racingTeamService.findById(anyLong())).thenReturn(racingTeam);
        when(makeService.findAll()).thenReturn(makes);

        mockMvc.perform(get("/racingteams/1/cars/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("racingTeam"))
                .andExpect(model().attributeExists("car"))
                .andExpect(view().name("cars/createOrUpdateCarForm"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(racingTeamService.findById(anyLong())).thenReturn(racingTeam);
        when(makeService.findAll()).thenReturn(makes);

        mockMvc.perform(post("/racingteams/1/cars/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/racingteams/1"));

        verify(carService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception {
        when(racingTeamService.findById(anyLong())).thenReturn(racingTeam);
        when(makeService.findAll()).thenReturn(makes);
        when(carService.findById(anyLong())).thenReturn(Car.builder().id(2L).build());

        mockMvc.perform(get("/racingteams/1/cars/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("racingTeam"))
                .andExpect(model().attributeExists("car"))
                .andExpect(view().name("cars/createOrUpdateCarForm"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(racingTeamService.findById(anyLong())).thenReturn(racingTeam);
        when(makeService.findAll()).thenReturn(makes);

        mockMvc.perform(post("/racingteams/1/cars/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/racingteams/{racingTeamId}"));

        verify(carService).save(any());
    }
}