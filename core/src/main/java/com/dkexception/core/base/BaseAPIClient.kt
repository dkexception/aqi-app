package com.dkexception.core.base

import com.dkexception.aqiapp.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

open class BaseAPIClient<I : BaseAPIInterface>(
    private val baseURL: String,
    private val apiServiceClass: Class<I>,
    private val retrofitBuilder: Retrofit.Builder,
    private val okHttpClientBuilder: OkHttpClient.Builder,
    private vararg val extraInterceptors: Interceptor = emptyArray(),
) {

    protected lateinit var apiService: I

    private val httpLoggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    init {
        createApiService()
    }

    private fun createApiService() {

        apiService = retrofitBuilder
            .baseUrl(baseURL)
            .client(getOkHttpClient())
            .build()
            .create(apiServiceClass)
    }

    private fun getOkHttpClient(): OkHttpClient = okHttpClientBuilder.apply {
        extraInterceptors.forEach(::addInterceptor)
        addNetworkInterceptor(httpLoggingInterceptor)
    }.build()
}
