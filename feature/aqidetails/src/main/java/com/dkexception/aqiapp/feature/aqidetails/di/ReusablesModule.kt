package com.dkexception.aqiapp.feature.aqidetails.di

import com.dkexception.aqiapp.feature.aqidetails.contract.IAQIDetailsCard
import com.dkexception.aqiapp.feature.aqidetails.reusables.AQIDetailsCardImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ReusablesModule {

    @Binds
    abstract fun bindAQIDetailsCard(
        impl: AQIDetailsCardImpl
    ): IAQIDetailsCard
}
