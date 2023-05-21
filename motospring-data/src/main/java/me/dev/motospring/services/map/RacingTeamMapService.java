package me.dev.motospring.services.map;

import me.dev.motospring.model.Car;
import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.CarService;
import me.dev.motospring.services.MakeService;
import me.dev.motospring.services.RacingTeamService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RacingTeamMapService extends AbstractMapService<RacingTeam, Long> implements RacingTeamService {

    private final MakeService makeService;
    private final CarService carService;

    public RacingTeamMapService(MakeService makeService, CarService carService) {
        this.makeService = makeService;
        this.carService = carService;
    }

    @Override
    public Set<RacingTeam> findAll() {
        return super.findAll();
    }

    @Override
    public RacingTeam findById(Long id) {
        return super.findById(id);
    }

    @Override
    public RacingTeam save(RacingTeam racingTeam) {
        if (racingTeam != null) {
            if (racingTeam.getCars() != null) {
                racingTeam.getCars().forEach(car -> {
                    if (car.getMake() != null) {
                        if (car.getMake().getId() == null) {
                            car.setMake(makeService.save(car.getMake()));
                        }
                    } else {
                        throw new RuntimeException("Make is required");
                    }

                    if (car.getId() == null) {
                        Car savedCar = carService.save(car);
                        car.setId(savedCar.getId());
                    }
                });
            }
            return super.save(racingTeam);
        } else {
            return null;
        }

    }

    @Override
    public void delete(RacingTeam racingTeam) {
        super.delete(racingTeam);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public RacingTeam findByName(String name) {
        throw new NotYetImplementedException();
    }
}
