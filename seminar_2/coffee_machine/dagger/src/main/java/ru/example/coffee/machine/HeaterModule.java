package ru.example.coffee.machine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ru.example.heater.ElectricCoil;
import ru.example.heater.ElectricalHeater;
import ru.example.heater.Heater;

@Module
public interface HeaterModule {

    @Binds
    Heater bindHeater(ElectricalHeater impl);
}
