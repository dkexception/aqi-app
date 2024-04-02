package com.dkexception.ui.maps.initializer

import android.content.Context
import com.dkexception.ui.BuildConfig
import com.mappls.sdk.maps.Mappls
import com.mappls.sdk.services.account.MapplsAccountManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MapsInitializer @Inject constructor() {

    fun initialiseAQIMaps(applicationContext: Context) {

        initMapMyIndia(applicationContext = applicationContext)
    }

    private fun initMapMyIndia(applicationContext: Context) {

        MapplsAccountManager.getInstance().restAPIKey = BuildConfig.mapMyIndiaKey
        MapplsAccountManager.getInstance().mapSDKKey = BuildConfig.mapMyIndiaKey
        MapplsAccountManager.getInstance().atlasClientId = BuildConfig.mapMyIndiaClientId
        MapplsAccountManager.getInstance().atlasClientSecret = BuildConfig.mapMyIndiaClientSecret
        Mappls.getInstance(applicationContext)
    }
}
