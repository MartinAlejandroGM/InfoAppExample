package com.example.infoappexample.network.api

import com.example.infoappexample.model.InfoResponse
import retrofit2.http.GET

interface RandomUserApi {
    @GET("api/")
    suspend fun getInfo(): InfoResponse
}