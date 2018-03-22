package com.mogsev.application.weathermap.network.model

import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import com.google.gson.annotations.SerializedName


/**
 * Created by Eugene Sikaylo on 3/22/2018.
 * email: mogsev@gmail.com
 */

class Main {

    @SerializedName("temp")
    var temp: Double? = null

    @SerializedName("pressure")
    var pressure: Double? = null

    @SerializedName("humidity")
    var humidity: Int = 0

    @SerializedName("temp_min")
    var tempMin: Double? = null

    @SerializedName("temp_max")
    var tempMax: Double? = null

    @SerializedName("sea_level")
    var seaLevel: Double? = null

    @SerializedName("grnd_level")
    var grndLevel: Double? = null

    override fun toString(): String {
        return ReflectionToStringBuilder.toString(this)
    }

}