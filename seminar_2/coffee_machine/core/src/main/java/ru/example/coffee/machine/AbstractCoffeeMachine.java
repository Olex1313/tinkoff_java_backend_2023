package ru.example.coffee.machine;

import ru.example.brewer.Brewer;
import ru.example.heater.Heater;
import ru.example.model.Coffee;
import ru.example.model.Water;
import ru.example.model.enums.CoffeeStrength;
import ru.example.water.provider.WaterProvider;

public abstract class AbstractCoffeeMachine {

    private final Brewer brewer;
    private final Heater heater;
    private final WaterProvider waterProvider;

    protected AbstractCoffeeMachine(
            Brewer brewer,
            Heater heater,
            WaterProvider waterProvider
    ) {
        this.brewer = brewer;
        this.heater = heater;
        this.waterProvider = waterProvider;
    }

    public Coffee brewCoffee() {
        Water water = waterProvider.provideWater();
        heater.heatWater(water);
        Coffee coffee = brewer.brew(water);
        System.out.printf("Brewing coffee with strength %s\n", coffee.coffeeStrength().name());
        return coffee;
    }

}

