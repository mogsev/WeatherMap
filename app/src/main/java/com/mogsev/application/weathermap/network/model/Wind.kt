package com.mogsev.application.weathermap.network.model

import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ReflectionToStringBuilder


/**
 * Created by Eugene Sikaylo on 3/22/2018.
 * email: mogsev@gmail.com
 */

class Wind {

    @SerializedName("speed")
    var speed: Double = 0.0

    @SerializedName("deg")
    var deg: Double = 0.0

    override fun toString(): String {
        return ReflectionToStringBuilder.toString(this)
    }

}