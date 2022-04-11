package com.example.dataquerycall.models

import com.google.gson.annotations.SerializedName

data class System(
    @SerializedName("sys")
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
