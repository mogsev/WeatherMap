package com.mogsev.application.weathermap.network

import com.mogsev.application.weathermap.network.model.WeatherInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Eugene Sikaylo on 3/22/2018.
 * email: mogsev@gmail.com
 */

interface ApiService {

    @Headers("accept: application/json", "content-type: application/json")
    @GET("data/2.5/weather")
    fun rxFetchNews(@Query("lat") lat: Double,
                    @Query("lon") lon: Double,
                    @Query("appid") appId: String): Observable<WeatherInfo>

}
