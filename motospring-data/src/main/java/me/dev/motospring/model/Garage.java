package me.dev.motospring.model;

import java.util.HashSet;
import java.util.Set;

public class Garage extends Group {

    private Set<Style> styles = new HashSet<>();

    public Set<Style> getStyles() {
        return styles;
    }

    public void setStyles(Set<Style> styles) {
        this.styles = styles;
    }
}
