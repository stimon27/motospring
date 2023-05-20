package me.dev.motospring.bootstrap;

import me.dev.motospring.model.*;
import me.dev.motospring.services.GarageService;
import me.dev.motospring.services.MakeService;
import me.dev.motospring.services.RacingTeamService;
import me.dev.motospring.services.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final RacingTeamService racingTeamService;
    private final GarageService garageService;
    private final MakeService makeService;
    private final StyleService styleService;

    public DataLoader(RacingTeamService racingTeamService, GarageService garageService, MakeService makeService, StyleService styleService) {
        this.racingTeamService = racingTeamService;
        this.garageService = garageService;
        this.makeService = makeService;
        this.styleService = styleService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = makeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Make honda = new Make();
        honda.setName("Honda");

        Make saveHondaMake = makeService.save(honda);

        Make chevrolet = new Make();
        chevrolet.setName("Chevrolet");

        Make savedChevroletMake = makeService.save(chevrolet);

        Style style1 = new Style();
        style1.setTag("Muscle");
        Style savedStyle1 = styleService.save(style1);

        Style style2 = new Style();
        style2.setTag("JDM");
        Style savedStyle2 = styleService.save(style2);

        Style style3 = new Style();
        style3.setTag("Classics");
        Style savedStyle3 = styleService.save(style3);

        RacingTeam racingTeam1 = new RacingTeam();
        racingTeam1.setName("Nitrofans");
        racingTeam1.setNationality("USA");
        racingTeam1.setRacingDiscipline("Quarter mile");
        racingTeam1.setCreationDate(LocalDate.of(2023, 1, 1));
        racingTeam1.setMotto("Faster than stopwatch");

        Car car1 = new Car();
        car1.setModel("Camaro");
        car1.setMake(savedChevroletMake);
        car1.setRacingTeam(racingTeam1);
        racingTeam1.getCars().add(car1);

        racingTeamService.save(racingTeam1);

        RacingTeam racingTeam2 = new RacingTeam();
        racingTeam2.setName("Burnt Tires");
        racingTeam2.setNationality("Japan");
        racingTeam2.setRacingDiscipline("Drift");
        racingTeam2.setCreationDate(LocalDate.of(2020, 2, 2));
        racingTeam2.setMotto("Sideways always");

        Car car2 = new Car();
        car2.setModel("NSX");
        car2.setMake(saveHondaMake);
        car2.setRacingTeam(racingTeam2);
        racingTeam2.getCars().add(car2);

        racingTeamService.save(racingTeam2);

        System.out.println("Loaded Racing Teams...");

        Garage garage1 = new Garage();
        garage1.setName("Mighty pistons");
        garage1.setNationality("USA");
        garage1.getStyles().add(style1);

        garageService.save(garage1);

        Garage garage2 = new Garage();
        garage2.setName("Graffiti masters");
        garage2.setNationality("Belgium");
        garage2.getStyles().add(style2);

        garageService.save(garage2);

        System.out.println("Loaded Garages...");
    }
}
