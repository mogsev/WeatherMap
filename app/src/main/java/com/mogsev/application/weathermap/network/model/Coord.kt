package com.mogsev.application.weathermap.network.model

import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ReflectionToStringBuilder


/**
 * Created by Eugene Sikaylo on 3/22/2018.
 * email: mogsev@gmail.com
 */

class Coord() {

    @SerializedName("lat")
    val latitude: Double? = null

    @SerializedName("lon")
    val longitude: Double? = null

    override fun toString(): String {
        return ReflectionToStringBuilder.toString(this)
    }

}
