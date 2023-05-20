package me.dev.motospring.services.map;

import me.dev.motospring.model.Garage;
import me.dev.motospring.model.Style;
import me.dev.motospring.services.GarageService;
import me.dev.motospring.services.StyleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GarageServiceMap extends AbstractMapService<Garage, Long> implements GarageService {

    private final StyleService styleService;

    public GarageServiceMap(StyleService styleService) {
        this.styleService = styleService;
    }

    @Override
    public Set<Garage> findAll() {
        return super.findAll();
    }

    @Override
    public Garage findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Garage save(Garage garage) {
        if (garage.getStyles().size() > 0) {
            garage.getStyles().forEach(style -> {
                if (style.getId() == null) {
                    Style savedStyle = styleService.save(style);
                    style.setId(savedStyle.getId());
                }
            });
        }

        return super.save(garage);
    }

    @Override
    public void delete(Garage garage) {
        super.delete(garage);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
