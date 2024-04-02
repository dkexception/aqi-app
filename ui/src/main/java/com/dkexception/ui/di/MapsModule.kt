package com.dkexception.ui.di

import com.dkexception.ui.maps.IMapView
import com.dkexception.ui.maps.ProviderAwareMapView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapsModule {

    @Binds
    internal abstract fun bindMapView(
        providerAwareMapView: ProviderAwareMapView
    ): IMapView
}
