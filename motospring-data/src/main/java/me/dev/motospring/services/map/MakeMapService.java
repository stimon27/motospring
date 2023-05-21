package me.dev.motospring.services.map;

import me.dev.motospring.model.Make;
import me.dev.motospring.services.MakeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class MakeMapService extends AbstractMapService<Make, Long> implements MakeService {
    @Override
    public Set<Make> findAll() {
        return super.findAll();
    }

    @Override
    public Make findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Make save(Make make) {
        return super.save(make);
    }

    @Override
    public void delete(Make make) {
        super.delete(make);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
