package com.example.dataquerycall

import com.example.dataquerycall.api.Api
import com.example.dataquerycall.models.WholeWeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val API_KEY = "7f3c4dca8bafcb34ed54d37e04c089e6"

class PresenterActivity(private val api: Api) {
    private var interfaceContract: InterfaceContract? = null

    fun attach(view: InterfaceContract) {
        interfaceContract = view
    }

    fun detach(view: InterfaceContract) {
        interfaceContract = null
    }

    fun getWeatherData(city: String, apId: String) {
        api.getWeatherData("Kara-Balta", API_KEY, "metric", "eng")
            .enqueue(object : Callback<WholeWeatherData> {
                override fun onResponse(call: Call<WholeWeatherData>, response: Response<WholeWeatherData>) {
                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()!!
                        interfaceContract?.showWeatherData(data)
                    }
                }
                override fun onFailure(call: Call<WholeWeatherData>, t: Throwable) {
                    t.message?.let { interfaceContract?.onDataFailure(it)}
                }
            })
    }
}