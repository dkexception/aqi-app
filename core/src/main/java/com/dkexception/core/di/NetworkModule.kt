package com.dkexception.core.di

import com.dkexception.core.network.air_visual_api.AirVisualAPIClient
import com.dkexception.core.network.air_visual_api.AirVisualAPIInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    internal fun provideAirVisualAPIInterface(): AirVisualAPIInterface = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()

    @Provides
    fun provideDefaultOkHttpClientBuilder(): OkHttpClient.Builder =
        OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS)

    @Provides
    fun provideDefaultRetrofitBuilder(): Retrofit.Builder =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    fun provideAirVisualAPIClient(
        retrofitBuilder: Retrofit.Builder,
        okHttpBuilder: OkHttpClient.Builder
    ): AirVisualAPIClient = AirVisualAPIClient(
        retrofitBuilder = retrofitBuilder,
        okHttpBuilder = okHttpBuilder
    )
}
