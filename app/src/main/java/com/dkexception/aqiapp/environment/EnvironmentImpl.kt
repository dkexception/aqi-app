package com.dkexception.aqiapp.environment

import android.content.Context
import com.dkexception.aqiapp.BuildConfig
import com.dkexception.aqiapp.R
import com.dkexception.core.environment.IEnvironment
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class EnvironmentImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : IEnvironment {

    override val appName: String
        get() = context.getString(R.string.app_name)

    override val version: String
        get() = BuildConfig.VERSION_NAME
}
