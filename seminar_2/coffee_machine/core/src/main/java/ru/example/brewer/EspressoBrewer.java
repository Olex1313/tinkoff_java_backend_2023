package ru.example.brewer;

import ru.example.heater.ElectricCoil;
import ru.example.model.Coffee;
import ru.example.model.Water;
import ru.example.model.enums.CoffeeStrength;

import javax.inject.Inject;

public class EspressoBrewer implements Brewer {

    private final ElectricCoil electricCoil;

    @Inject
    public EspressoBrewer(ElectricCoil electricCoil) {
        this.electricCoil = electricCoil;
    }

    @Override
    public Coffee brew(Water water) {
        return new Coffee(CoffeeStrength.HIGH);
    }
}
