package ru.example.coffee.machine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ru.example.water.provider.WaterProvider;
import ru.example.water.provider.WaterReservoir;

@Module
public interface WaterProviderModule {

    @Binds
    WaterProvider bindWaterProvider(WaterReservoir impl);

}
