package com.example.dataquerycall

import com.example.dataquerycall.models.WholeWeatherData


interface InterfaceContract {
fun showWeatherData(data: WholeWeatherData)
fun onDataFailure(message: String)
}