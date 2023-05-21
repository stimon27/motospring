package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.model.Tuning;
import me.dev.motospring.repositories.TuningRepository;
import me.dev.motospring.services.TuningService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class TuningJpaService implements TuningService {

    private final TuningRepository tuningRepository;

    public TuningJpaService(TuningRepository tuningRepository) {
        this.tuningRepository = tuningRepository;
    }

    @Override
    public Set<Tuning> findAll() {
        Set<Tuning> tunings = new HashSet<>();
        tuningRepository.findAll().forEach(tunings::add);
        return tunings;
    }

    @Override
    public Tuning findById(Long id) {
        return tuningRepository.findById(id).orElse(null);
    }

    @Override
    public Tuning save(Tuning tuning) {
        return tuningRepository.save(tuning);
    }

    @Override
    public void delete(Tuning tuning) {
        tuningRepository.delete(tuning);
    }

    @Override
    public void deleteById(Long id) {
        tuningRepository.deleteById(id);
    }
}
