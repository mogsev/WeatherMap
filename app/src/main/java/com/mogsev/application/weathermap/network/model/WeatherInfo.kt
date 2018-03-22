package com.mogsev.application.weathermap.network.model

import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import com.google.gson.annotations.SerializedName


/**
 * Created by Eugene Sikaylo on 3/22/2018.
 * email: mogsev@gmail.com
 */

class WeatherInfo {

    @SerializedName("id")
    private var id: Int = 0

    @SerializedName("coord")
    private var coord: Coord? = null

    @SerializedName("weather")
    private var weather: List<Weather>? = null

    @SerializedName("base")
    private var base: String? = null

    @SerializedName("main")
    private var main: Main? = null

    @SerializedName("wind")
    private var wind: Wind? = null

    @SerializedName("dt")
    private var dt: Long = 0

    @SerializedName("sys")
    private var sys: Sys? = null

    @SerializedName("name")
    private var name: String? = null

    @SerializedName("cod")
    private var cod: Int? = null

    override fun toString(): String {
        return ReflectionToStringBuilder.toString(this)
    }

}