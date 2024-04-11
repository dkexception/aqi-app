package com.dkexception.aqiapp.di

import com.dkexception.aqiapp.environment.EnvironmentImpl
import com.dkexception.core.environment.IEnvironment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class EnvironmentModule {

    @Binds
    @Singleton
    abstract fun bindEnvironment(
        impl: EnvironmentImpl
    ): IEnvironment
}
