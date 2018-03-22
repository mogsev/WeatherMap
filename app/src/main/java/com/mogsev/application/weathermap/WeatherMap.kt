package com.mogsev.application.weathermap

import android.app.Application
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatDelegate
import com.mogsev.application.weathermap.network.Api
import timber.log.Timber

/**
 * Created by Eugene Sikaylo on 3/22/2018.
 * email: mogsev@gmail.com
 */

class WeatherMap : Application() {

    private lateinit var mApi: Api

    override fun onCreate() {
        super.onCreate()

        // initialize Timber
        initTimber()

        //we use vector drawables
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        // enable debug of fragment manager
        FragmentManager.enableDebugLogging(BuildConfig.DEBUG)

        mApi = Api()
    }

    fun getApi(): Api {
        return mApi
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
