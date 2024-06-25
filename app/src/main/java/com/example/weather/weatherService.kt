package com.example.weather

import retrofit2.Call
import retrofit2.http.GET

interface weatherService {

    @GET("?q=Toulouse&appid=6f3c0bae04d5a0edcc8de9b147ccbb33")
    fun getWeatherByCity() : Call<String>
}