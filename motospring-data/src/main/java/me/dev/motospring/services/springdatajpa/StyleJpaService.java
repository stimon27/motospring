package me.dev.motospring.services.springdatajpa;

import me.dev.motospring.model.Style;
import me.dev.motospring.repositories.StyleRepository;
import me.dev.motospring.services.StyleService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        return styleRepository.findById(id).orElse(null);
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
