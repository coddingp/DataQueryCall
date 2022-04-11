package com.example.dataquerycall.models

import com.google.gson.annotations.SerializedName

data class TimeZone(
    @SerializedName("timezone")
    val timezone: Int
)

