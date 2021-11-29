package com.example.infoappexample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private const val BASE_URL = "https://randomuser.me/"
    private val client = OkHttpClient.Builder().build()
    fun <T> createApi(api: Class<T>, baseUrl: String = BASE_URL): T =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(
            client).build().create(api)
}