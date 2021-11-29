package com.example.infoappexample.network.webservice

import com.example.infoappexample.model.InfoResponse
import com.example.infoappexample.network.Api
import com.example.infoappexample.network.api.RandomUserApi

class RandomWebService {
    private val service = Api.createApi(RandomUserApi::class.java)

    suspend fun getInfo(): InfoResponse{
        return service.getInfo()
    }
}