package com.mogsev.application.weathermap.gui.activity

import android.Manifest
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mogsev.application.weathermap.R
import com.mogsev.application.weathermap.databinding.ActivityMainBinding
import com.mogsev.application.weathermap.network.Api
import com.mogsev.application.weathermap.network.model.WeatherInfo
import timber.log.Timber
import android.location.LocationManager
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.content.Context
import android.location.Location
import android.location.LocationListener
import com.mogsev.application.weathermap.transformer.DefaultSchedulerTransformer


class MainActivity : AppCompatActivity(), LocationListener {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mLocationManager: LocationManager
    private lateinit var mLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Timber.i("Last location is empty")
            takeWeatherInfo(35.0, 139.0)
        } else {
            mLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (mLocation != null) {
                Timber.i("Location: %s, %s", mLocation.getLatitude(), mLocation.getLongitude())
                takeWeatherInfo(mLocation.getLatitude(), mLocation.getLongitude())
            }
        }
    }

    override fun onLocationChanged(location: Location?) {
        // empty
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        //empty
    }

    override fun onProviderEnabled(provider: String?) {
        //empty
    }

    override fun onProviderDisabled(provider: String?) {
        //empty
    }

    private fun takeWeatherInfo(lat: Double, lon: Double) {
        Api.from(this).apiService.rxFetchNews(lat, lon, "b6907d289e10d714a6e88b30761fae22")
                .compose(DefaultSchedulerTransformer())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(result: WeatherInfo) {
        Timber.i("handleResponse: %s", result)
        mBinding.weather = result
    }

    private fun handleError(error: Throwable?) {
        Timber.e("handleError: %s", error)
        mBinding.model?.appError?.set(true)
    }

}
