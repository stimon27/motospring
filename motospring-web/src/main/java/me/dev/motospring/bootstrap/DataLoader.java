package me.dev.motospring.bootstrap;

import me.dev.motospring.model.Garage;
import me.dev.motospring.model.Make;
import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.GarageService;
import me.dev.motospring.services.MakeService;
import me.dev.motospring.services.RacingTeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RacingTeamService racingTeamService;
    private final GarageService garageService;
    private final MakeService makeService;

    public DataLoader(RacingTeamService racingTeamService, GarageService garageService, MakeService makeService) {
        this.racingTeamService = racingTeamService;
        this.garageService = garageService;
        this.makeService = makeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Make honda = new Make();
        honda.setName("Honda");

        Make saveHondaMake = makeService.save(honda);

        Make chevrolet = new Make();
        chevrolet.setName("Chevrolet");

        Make savedChevroletMake = makeService.save(chevrolet);

        RacingTeam racingTeam1 = new RacingTeam();
        racingTeam1.setName("Nitrofans");
        racingTeam1.setNationality("USA");

        racingTeamService.save(racingTeam1);

        RacingTeam racingTeam2 = new RacingTeam();
        racingTeam2.setName("Burnt Tires");
        racingTeam2.setNationality("Japan");

        racingTeamService.save(racingTeam2);

        System.out.println("Loaded Racing Teams...");

        Garage garage1 = new Garage();
        garage1.setName("Mighty pistons");
        garage1.setNationality("USA");

        garageService.save(garage1);

        Garage garage2 = new Garage();
        garage2.setName("Graffiti masters");
        garage2.setNationality("Belgium");

        garageService.save(garage2);

        System.out.println("Loaded Garages...");
    }
}
