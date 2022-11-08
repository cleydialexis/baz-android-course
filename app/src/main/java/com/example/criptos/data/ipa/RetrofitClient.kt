package com.example.criptos.data.ipa

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("")
        .addCallAdapterFactory(GsonConverterFactory.create())
        .build()

}