package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.exceptions.NotFoundException;
import me.dev.motospring.model.Style;
import me.dev.motospring.repositories.StyleRepository;
import me.dev.motospring.services.StyleService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class StyleJpaService implements StyleService {

    private final StyleRepository styleRepository;

    public StyleJpaService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public Set<Style> findAll() {
        Set<Style> styles = new HashSet<>();
        styleRepository.findAll().forEach(styles::add);
        return styles;
    }

    @Override
    public Style findById(Long id) {
        Optional<Style> styleOptional = styleRepository.findById(id);

        if (styleOptional.isEmpty()) {
            throw new NotFoundException("Style with id=" + id + " could not be found.");
        }

        return styleOptional.get();
    }

    @Override
    public Style save(Style style) {
        return styleRepository.save(style);
    }

    @Override
    public void delete(Style style) {
        styleRepository.delete(style);
    }

    @Override
    public void deleteById(Long id) {
        styleRepository.deleteById(id);
    }
}
