package com.example.criptos.data

import com.example.criptos.domain.api.ApiService
import com.example.criptos.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory


lateinit var httpClientBuilder: OkHttpClient.Builder
lateinit var logging : HttpLoggingInterceptor

fun createInterceptor(): OkHttpClient{
    httpClientBuilder = OkHttpClient.Builder()
    logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    httpClientBuilder.addInterceptor(logging)
    return httpClientBuilder.build()
}

var retrofit = retrofit2.Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(createInterceptor())
    .build().create(ApiService::class.java)