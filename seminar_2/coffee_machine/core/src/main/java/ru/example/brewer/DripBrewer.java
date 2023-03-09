package ru.example.brewer;

import ru.example.model.Coffee;
import ru.example.model.Water;
import ru.example.model.enums.CoffeeStrength;

import javax.inject.Inject;

public class DripBrewer implements Brewer {

    private final DripPack dripPack;

    @Inject
    public DripBrewer(DripPack dripPack) {
        this.dripPack = dripPack;
    }

    @Override
    public Coffee brew(Water water) {
        return switch (water.getTemperature()) {
            case COLD -> throw new IllegalArgumentException("Water should be hot");
            case HOT -> new Coffee(CoffeeStrength.LOW);
        };
    }

}
