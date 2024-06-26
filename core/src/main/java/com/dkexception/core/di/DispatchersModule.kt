package com.dkexception.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

interface StandardDispatchers {

    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

internal class StandardDispatchersImpl @Inject constructor() : StandardDispatchers {

    override val io: CoroutineDispatcher = Dispatchers.IO
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val default: CoroutineDispatcher = Dispatchers.Default
    override val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DispatchersModule {

    @Binds
    @Singleton
    abstract fun provideStandardDispatchers(
        standardDispatchersImpl: StandardDispatchersImpl
    ): StandardDispatchers
}
