package me.dev.motospring.formatters;

import me.dev.motospring.model.Make;
import me.dev.motospring.services.MakeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class MakeFormatter implements Formatter<Make> {

    private final MakeService makeService;

    public MakeFormatter(MakeService makeService) {
        this.makeService = makeService;
    }

    @Override
    public String print(Make make, Locale locale) {
        return make.getName();
    }

    @Override
    public Make parse(String text, Locale locale) throws ParseException {
        Collection<Make> findMakes = makeService.findAll();
        for (Make make : findMakes) {
            if (make.getName().equals(text)) {
                return make;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
