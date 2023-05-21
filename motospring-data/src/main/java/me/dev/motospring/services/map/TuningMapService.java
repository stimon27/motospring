package me.dev.motospring.services.map;

import me.dev.motospring.model.Tuning;
import me.dev.motospring.services.TuningService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class TuningMapService extends AbstractMapService<Tuning, Long> implements TuningService {
    @Override
    public Set<Tuning> findAll() {
        return super.findAll();
    }

    @Override
    public Tuning findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Tuning save(Tuning tuning) {
        if (tuning.getCar() == null || tuning.getCar().getRacingTeam() == null || tuning.getCar().getId() == null) {
            throw new RuntimeException("Invalid Tuning");
        }

        return super.save(tuning);
    }

    @Override
    public void delete(Tuning tuning) {
        super.delete(tuning);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
