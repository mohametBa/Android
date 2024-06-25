package com.example.weather

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var tvReponse : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvReponse = findViewById(R.id.tvReponse)

        //retrofit
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/weather/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val weatherService = retrofit.create(weatherService::class.java)
        //api call

        val result = weatherService.getWeatherByCity()

        result.enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, reponse: Response<String>) {
                if(reponse.isSuccessful){
                    tvReponse.text  = reponse.body()
                }
            }

            override fun onFailure(p0: Call<String>, p1: Throwable) {
                Toast.makeText(applicationContext,"Erreur seveur", Toast.LENGTH_SHORT).show()
            }

        })
    }

}