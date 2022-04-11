package com.example.dataquerycall.models

data class WholeWeatherData(
    val coord: Coord,
    val weather: List<Weather>,
    val base: Base,
    val main: Main,
    val visibility: Visibility,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Dt,
    val system: System,
    val timeZone: TimeZone,
    val id: Id,
    val name: Name,
    val cod: Cod
)
