package ru.example.coffee.machine;

import ru.example.brewer.DripBrewer;
import ru.example.heater.Heater;
import ru.example.water.provider.WaterProvider;

import javax.inject.Inject;

public class DripCoffeeMachine extends AbstractCoffeeMachine {

    @Inject
    public DripCoffeeMachine(
            DripBrewer brewer,
            Heater heater,
            WaterProvider waterProvider
    ) {
        super(brewer, heater, waterProvider);
    }

}
