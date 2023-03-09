package ru.example.heater;

import ru.example.model.Water;
import ru.example.model.enums.Temperature;

import javax.inject.Inject;

public class ElectricalHeater implements Heater {

    private final ElectricCoil electricCoil;

    @Inject
    public ElectricalHeater(ElectricCoil electricCoil) {
        this.electricCoil = electricCoil;
    }

    @Override
    public void heatWater(Water water) {
        water.setTemperature(Temperature.HOT);
    }

}
