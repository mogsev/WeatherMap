package com.mogsev.application.weathermap.network.model

import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import com.google.gson.annotations.SerializedName


/**
 * Created by Eugene Sikaylo on 3/22/2018.
 * email: mogsev@gmail.com
 */

class Sys {

    @SerializedName("message")
    var message: Double? = null

    @SerializedName("country")
    var country: String? = null

    @SerializedName("sunrise")
    var sunrise: Int? = null

    @SerializedName("sunset")
    var sunset: Int? = null

    override fun toString(): String {
        return ReflectionToStringBuilder.toString(this)
    }

}
