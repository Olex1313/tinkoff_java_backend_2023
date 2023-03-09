package ru.example.model;

import ru.example.model.enums.Temperature;

public class Water {

    private Temperature temperature;

    public Water() {
        temperature = Temperature.COLD;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Temperature getTemperature() {
        return temperature;
    }

}
