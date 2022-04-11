package com.example.dataquerycall.models

import com.google.gson.annotations.SerializedName

data class Base(
    @SerializedName("stations")
    val stations: String
)
