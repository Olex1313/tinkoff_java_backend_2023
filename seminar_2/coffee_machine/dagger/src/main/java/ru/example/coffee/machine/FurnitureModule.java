package ru.example.coffee.machine;

import dagger.Module;
import dagger.Provides;
import ru.example.heater.ElectricCoil;
import ru.example.water.provider.WaterReservoir;

@Module
public class FurnitureModule {

    @Provides
    public WaterReservoir provideWaterReservoir() {
        return new WaterReservoir();
    }

    @Provides
    public ElectricCoil provideElectricCoil() {
        return new ElectricCoil();
    }

}
