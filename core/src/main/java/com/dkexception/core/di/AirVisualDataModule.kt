package com.dkexception.core.di

import com.dkexception.core.avdatamanager.AirVisualDataManagerImpl
import com.dkexception.core.avdatamanager.IAirVisualDataManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AirVisualDataModule {

    @Binds
    @Singleton
    internal abstract fun bindAirVisualDataManager(
        impl: AirVisualDataManagerImpl
    ): IAirVisualDataManager
}
