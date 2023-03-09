package ru.example.water.provider;


import ru.example.model.Water;

public class WaterReservoir implements WaterProvider {

    private final Water water;

    public WaterReservoir() {
        this.water = new Water();
    }

    @Override
    public Water provideWater() {
        return this.water;
    }

}
