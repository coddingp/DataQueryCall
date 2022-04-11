package com.example.dataquerycall.api

import com.example.dataquerycall.models.WholeWeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/data/2.5/weather")
    fun getWeatherData(
        @Query("q") cityName: String,
        @Query("appid") appid: String,
        @Query("units") units: String,
        @Query("lang") lang: String,
    ): Call<WholeWeatherData>
}