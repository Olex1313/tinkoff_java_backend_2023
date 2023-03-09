package ru.example.coffee.machine;

import dagger.Component;

@Component(modules = {WaterProviderModule.class, HeaterModule.class, FurnitureModule.class})
public interface CoffeeMachineComponent {

    EspressoCoffeeMachine espressoCoffeeMachine();

    DripCoffeeMachine dripCoffeeMachine();

}
