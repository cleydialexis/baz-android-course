package com.example.criptos.data

import com.example.criptos.domain.api.ApiService
import com.example.criptos.util.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGson(): Gson{
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.HEADERS
        }
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .addNetworkInterceptor {
                chain -> chain.proceed(
                chain.request()
                    .newBuilder()
                    .head("User-Agent", "User-Agent").build()
                )
            }.build()
    }
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BASIC
    }

    private val client =
        OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor{
            chain -> chain.proceed(
            chain.request()
                .newBuilder()
                .head("User-Agent", "User-agent")
                .build()
            )
        }
}