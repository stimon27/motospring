package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.exceptions.NotFoundException;
import me.dev.motospring.model.Make;
import me.dev.motospring.repositories.MakeRepository;
import me.dev.motospring.services.MakeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class MakeJpaService implements MakeService {

    private final MakeRepository makeRepository;

    public MakeJpaService(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    @Override
    public Set<Make> findAll() {
        Set<Make> makes = new HashSet<>();
        makeRepository.findAll().forEach(makes::add);
        return makes;
    }

    @Override
    public Make findById(Long id) {
        Optional<Make> makeOptional = makeRepository.findById(id);

        if (makeOptional.isEmpty()) {
            throw new NotFoundException("Make with id=" + id + " could not be found.");
        }

        return makeOptional.get();
    }

    @Override
    public Make save(Make make) {
        return makeRepository.save(make);
    }

    @Override
    public void delete(Make make) {
        makeRepository.delete(make);
    }

    @Override
    public void deleteById(Long id) {
        makeRepository.deleteById(id);
    }
}
