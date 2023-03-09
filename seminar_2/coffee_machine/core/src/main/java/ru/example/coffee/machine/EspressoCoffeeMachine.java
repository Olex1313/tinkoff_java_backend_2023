package ru.example.coffee.machine;

import ru.example.brewer.EspressoBrewer;
import ru.example.heater.ElectricalHeater;
import ru.example.water.provider.WaterProvider;

import javax.inject.Inject;

public class EspressoCoffeeMachine extends AbstractCoffeeMachine {

    @Inject
    public EspressoCoffeeMachine(
            EspressoBrewer brewer,
            ElectricalHeater heater,
            WaterProvider waterProvider
    ) {
        super(brewer, heater, waterProvider);
    }

}
