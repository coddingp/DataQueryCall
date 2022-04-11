package com.example.dataquerycall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dataquerycall.api.Api
import com.example.dataquerycall.api.Retrofit.getRetrofit
import com.example.dataquerycall.databinding.ActivityMainBinding
import com.example.dataquerycall.models.WholeWeatherData
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), InterfaceContract {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val api: Api = Retrofit.getRetrofit().create(Api::class.java)
    private val presenter: WeatherPresenter = WeatherPresenter(api)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attach(this)
        binding.apply {
            val city = editCityTextView.text.toString()
            presenter.getWeatherData(city, API_KEY)
            setContentView(root)
        }
    }

    override fun showWeatherData(data: WeatherData) = with(binding) {
        cityTextView.text = data.name
        cloudsTextView.text = data.weather[0].description
        temperatureTextView.text = "temp: ${data.main.temp} °C"
        humidityTextView.text = "humidity \n     ${data.main.humidity}"
        windTextView.text = "Wind speed \n${data.wind.speed} m/sec "
        setContentView(root)
    }

    override fun onDataFailure(message: String) {
        error(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach(this)
    }

}