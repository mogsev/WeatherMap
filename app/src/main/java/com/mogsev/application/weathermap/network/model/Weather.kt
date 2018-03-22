package com.mogsev.application.weathermap.network.model

import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ReflectionToStringBuilder


/**
 * Created by Eugene Sikaylo on 3/22/2018.
 * email: mogsev@gmail.com
 */

class Weather {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("main")
    var main: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("icon")
    var icon: String? = null

    override fun toString(): String {
        return ReflectionToStringBuilder.toString(this)
    }

}
