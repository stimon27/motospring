package me.dev.motospring.bootstrap;

import me.dev.motospring.model.*;
import me.dev.motospring.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final MakeService makeService;
    private final RacingTeamService racingTeamService;
    private final StyleService styleService;
    private final GarageService garageService;

    public DataLoader(MakeService makeService,
                      RacingTeamService racingTeamService,
                      StyleService styleService,
                      GarageService garageService) {
        this.makeService = makeService;
        this.racingTeamService = racingTeamService;
        this.styleService = styleService;
        this.garageService = garageService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = makeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Garage garage1 = new Garage();
        garage1.setName("Mighty pistons");
        garage1.setNationality("USA");
        Style style1 = new Style();
        style1.setTag("Muscle");
        styleService.save(style1);
        garage1.getStyles().add(style1);
        garageService.save(garage1);

        Garage garage2 = new Garage();
        garage2.setName("Graffiti masters");
        garage2.setNationality("Japan");
        Style style2 = new Style();
        style2.setTag("JDM");
        styleService.save(style2);
        garage2.getStyles().add(style2);
        garageService.save(garage2);

        RacingTeam racingTeam1 = new RacingTeam();
        racingTeam1.setName("Night riders");
        racingTeam1.setNationality("Belgium");
        racingTeam1.setRacingDiscipline("Street racing");
        racingTeam1.setCreationDate(LocalDate.of(2023, 5, 20));
        racingTeam1.setMotto("5-0!");
        Make make1 = new Make();
        make1.setName("Audi");
        makeService.save(make1);
        Car car1 = new Car();
        car1.setModel("RS7");
        car1.setMake(make1);
        car1.setRacingTeam(racingTeam1);
        Tuning tuning1 = new Tuning();
        tuning1.setDate(LocalDate.of(2008, 11, 1));
        tuning1.setDescription("Chip tuning");
        tuning1.setCar(car1);
        car1.getTunings().add(tuning1);
        racingTeam1.getCars().add(car1);
        racingTeamService.save(racingTeam1);

        RacingTeam racingTeam2 = new RacingTeam();
        racingTeam2.setName("Burnt Tires");
        racingTeam2.setNationality("Japan");
        racingTeam2.setRacingDiscipline("Drift");
        racingTeam2.setCreationDate(LocalDate.of(2004, 7, 5));
        racingTeam2.setMotto("Sideways always");
        Make make2 = new Make();
        make2.setName("Honda");
        makeService.save(make2);
        Car car2 = new Car();
        car2.setModel("Civic");
        car2.setMake(make2);
        car2.setRacingTeam(racingTeam2);
        Tuning tuning2 = new Tuning();
        tuning2.setDate(LocalDate.of(2001, 12, 16));
        tuning2.setDescription("Drift suspension");
        tuning2.setCar(car2);
        car2.getTunings().add(tuning2);
        racingTeam2.getCars().add(car2);
        racingTeamService.save(racingTeam2);

        RacingTeam racingTeam3 = new RacingTeam();
        racingTeam3.setName("Nitrofans");
        racingTeam3.setNationality("USA");
        racingTeam3.setRacingDiscipline("Quarter mile");
        racingTeam3.setCreationDate(LocalDate.of(1996, 2, 18));
        racingTeam3.setMotto("Faster than stopwatch");
        Make make3 = new Make();
        make3.setName("Ford");
        makeService.save(make3);
        Car car3 = new Car();
        car3.setModel("Mustang");
        car3.setMake(make3);
        car3.setRacingTeam(racingTeam3);
        Tuning tuning3 = new Tuning();
        tuning3.setDate(LocalDate.of(2015, 5, 10));
        tuning3.setDescription("Exhaust replace");
        tuning3.setCar(car3);
        car3.getTunings().add(tuning3);
        racingTeam3.getCars().add(car3);
        racingTeamService.save(racingTeam3);

        RacingTeam racingTeam4 = new RacingTeam();
        racingTeam4.setName("VIP Club");
        racingTeam4.setNationality("Italy");
        racingTeam4.setRacingDiscipline("Time attacks");
        racingTeam4.setCreationDate(LocalDate.of(2010, 6, 30));
        racingTeam4.setMotto("Faster than stopwatch");
        Make make4 = new Make();
        make4.setName("Lamborghini");
        makeService.save(make4);
        Car car4 = new Car();
        car4.setModel("Aventador");
        car4.setMake(make4);
        car4.setRacingTeam(racingTeam4);
        Tuning tuning4 = new Tuning();
        tuning4.setDate(LocalDate.of(2021, 2, 8));
        tuning4.setDescription("New rims");
        tuning4.setCar(car4);
        car4.getTunings().add(tuning4);
        racingTeam4.getCars().add(car4);
        racingTeamService.save(racingTeam4);
    }
}
