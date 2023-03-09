package ru.example;

import ru.example.coffee.machine.CoffeeMachineComponent;
import ru.example.coffee.machine.DaggerCoffeeMachineComponent;

public class App {

    public static void main(String[] args) {
        CoffeeMachineComponent coffeeMachineComponent = DaggerCoffeeMachineComponent.create();
        coffeeMachineComponent.espressoCoffeeMachine().brewCoffee();
        coffeeMachineComponent.dripCoffeeMachine().brewCoffee();
    }

}
