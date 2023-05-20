package me.dev.motospring.services.map;

import me.dev.motospring.model.Style;
import me.dev.motospring.services.StyleService;

import java.util.Set;

public class StyleServiceMap extends AbstractMapService<Style, Long> implements StyleService {
    @Override
    public Set<Style> findAll() {
        return super.findAll();
    }

    @Override
    public Style findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Style save(Style style) {
        return super.save(style);
    }

    @Override
    public void delete(Style style) {
        super.delete(style);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
