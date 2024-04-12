package com.dkexception.aqiapp.feature.aqisdk.di

import com.dkexception.aqiapp.feature.aqisdk.contract.IAirVisualDataManager
import com.dkexception.aqiapp.feature.aqisdk.impl.AirVisualDataManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AirVisualDataModule {

    @Binds
    @Singleton
    abstract fun bindAirVisualDataManager(
        impl: AirVisualDataManagerImpl
    ): IAirVisualDataManager
}
